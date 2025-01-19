package org.acme;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.injector.ContentInjector;
import dev.langchain4j.rag.content.injector.DefaultContentInjector;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import io.quarkiverse.langchain4j.pgvector.PgVectorEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.function.Supplier;

@ApplicationScoped
public class CustomRetrievalAugmentor implements Supplier<RetrievalAugmentor> {

    private final RetrievalAugmentor augmentor;

    public CustomRetrievalAugmentor(final PgVectorEmbeddingStore store,
                                    final EmbeddingModel embeddingModel) {
        augmentor = DefaultRetrievalAugmentor.builder()
                .contentInjector(
                        DefaultContentInjector.builder()
                                .promptTemplate()
                )
                .build();
//        final EmbeddingStoreContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
//                .embeddingModel(embeddingModel)
//                .embeddingStore(store)
//                .build();
//        augmentor = DefaultRetrievalAugmentor
//                .builder()
////                .queryTransformer(query -> {
////                    query
////                })
//                .contentRetriever(contentRetriever)
//                .build();
    }
// TODO je dois rajouter un id !!!
    @Override
    public RetrievalAugmentor get() {
        return augmentor;
    }
}
