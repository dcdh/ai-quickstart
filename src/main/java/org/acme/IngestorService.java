package org.acme;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkiverse.langchain4j.pgvector.PgVectorEmbeddingStore;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.context.ManagedExecutor;

import java.io.InputStream;
import java.util.Objects;

import static dev.langchain4j.data.document.splitter.DocumentSplitters.recursive;

@ApplicationScoped
public class IngestorService {

    private final PgVectorEmbeddingStore store;
    private final EmbeddingModel embeddingModel;
    private final DocumentParser parser;
    private final ManagedExecutor managedExecutor;

    public IngestorService(final PgVectorEmbeddingStore store,
                           final EmbeddingModel embeddingModel,
                           final ManagedExecutor managedExecutor) {
        this.store = Objects.requireNonNull(store);
        this.embeddingModel = Objects.requireNonNull(embeddingModel);
        this.parser = new ApacheTikaDocumentParser();
        this.managedExecutor = Objects.requireNonNull(managedExecutor);
    }

    // The objective is to ingest during runtime after uploading a document
    void onStart(@Observes final StartupEvent ev) {
        this.managedExecutor.runAsync(() -> {
            // read
            // La version PDF est mal supportée. Beaucoup de contenu sont manquants, des erreurs d'encodages...
            // J'ai repris une version clean pour la transformer directement en txt
            final InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("sade_marquis_de_-_la_philosophie_dans_le_boudoir.txt");
            final Document document = parser.parse(inputStream);
            // ingest
            final EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                    .embeddingStore(store)
                    .embeddingModel(embeddingModel)
                    .documentSplitter(recursive(500, 0))
                    .build();
            // Warning - this can take a long time...
            Log.info("Ingestion 'philosophie dans le boudoir' started");
            ingestor.ingest(document);
            Log.info("Ingestion 'philosophie dans le boudoir' ended");
        }).whenComplete((u, ex) -> {
            if (ex != null) {
                Log.error("Fail to ingest", ex);
            }
        });
    }
}
