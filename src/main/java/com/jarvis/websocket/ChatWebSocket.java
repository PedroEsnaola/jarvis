package com.jarvis.websocket;

import com.jarvis.service.JarvisService;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.smallrye.mutiny.Uni;

@WebSocket(path = "/websocket")
public class ChatWebSocket {

    private final JarvisService bot;

    public ChatWebSocket(JarvisService bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return bot.chat("Ola como posso ajudar");
    }

    @OnTextMessage
    public String onMessage(String message) {
        return bot.chat(message);
    }
}
