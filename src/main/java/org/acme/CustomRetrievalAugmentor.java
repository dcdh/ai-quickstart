package org.acme;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import io.quarkiverse.langchain4j.pgvector.PgVectorEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Supplier;

@ApplicationScoped
public class CustomRetrievalAugmentor implements Supplier<RetrievalAugmentor> {

    private final RetrievalAugmentor augmentor;

    public CustomRetrievalAugmentor(final PgVectorEmbeddingStore store,
                                    final EmbeddingModel embeddingModel) {
        final EmbeddingStoreContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
                .embeddingModel(embeddingModel)
                .embeddingStore(store)
                .maxResults(3)
                .build();
        augmentor = DefaultRetrievalAugmentor
                .builder()
//                .queryTransformer(query -> {
//                    query
//                })
                .contentRetriever(contentRetriever)
                .build();
    }
// TODO je dois rajouter un id !!!
    @Override
    public RetrievalAugmentor get() {
        return augmentor;
    }
}
