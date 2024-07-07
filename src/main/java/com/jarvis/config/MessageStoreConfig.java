package com.jarvis.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class MessageStoreConfig implements ChatMemoryProvider {

    @Inject
    Logger logger;

    @Override
    public ChatMemory get(Object o) {
        return MessageWindowChatMemory.builder().id(o).chatMemoryStore(new InMemoryChatMemoryStore()).maxMessages(50).build();
    }

    @Scheduled(every="10s")
    void increment() {
        logger.info("Compiling...");
    }
}
