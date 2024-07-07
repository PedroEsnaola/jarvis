package com.jarvis.service;

import com.jarvis.config.MessageStoreConfig;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.SessionScoped;

import java.util.UUID;

@RegisterAiService
@SessionScoped
public interface JarvisService {


    @SystemMessage("""
                Voce é um assistente muito curioso com a vida do usuario
            """)
    String chat(@UserMessage String message);
}
