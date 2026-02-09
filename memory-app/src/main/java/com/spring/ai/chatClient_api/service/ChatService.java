package com.spring.ai.chatClient_api.service;

import reactor.core.publisher.Flux;

public interface ChatService {
    String  chatTemplate(String query);
    Flux<String> streamChat(String query);

}
