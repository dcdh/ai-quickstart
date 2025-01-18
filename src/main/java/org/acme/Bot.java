package org.acme;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(
        retrievalAugmentor = CustomRetrievalAugmentor.class
)
public interface Bot {

    String chat(@UserMessage String question);
}