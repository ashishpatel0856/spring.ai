package com.spring.ai.chatClient_api.service;

import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {
    String  chatTemplate(String query,String userId);
    Flux<String> streamChat(String query , String userId);
    void saveData(List<String> list);

}
