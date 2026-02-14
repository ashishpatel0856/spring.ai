package com.spring.ai.chatClient_api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@Service
public class chatServiceImpl implements ChatService{

    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    public chatServiceImpl(ChatClient chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;


    @Override
    public String chatTemplate(String query,String userId){


        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,userId))
                .system(system ->
                        system.text(this.systemMessage))
                .user(user ->
                        user.text(userMessage)
                                .param("concept",query))
                .call()
                .content();

    }

//    @Override
//    public Flux<String> streamChat(String query) {
//        return Flux.just(
//                this.chatClient
//                        .prompt()
//                        .system(system -> system.text(this.systemMessage))
//                        .user(user -> user.text(this.userMessage).param("concept", query))
//                        .call()
//                        .content()
//        );
//    }

    @Override
    public Flux<String> streamChat(String query, String userId) {

        return this.chatClient
                .prompt()
                .advisors(advisorSpec ->
                        advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
                .system(system -> system.text(this.systemMessage))
                .user(user -> user.text(this.userMessage)
                        .param("concept", query))
                .stream()
                .content();
    }

    @Override
    public void saveData(List<String> list) {
        System.out.println("Saving documents: " + list.size());
        List<Document> documentList = list.stream()
                .map(Document::new)
                .toList();
        vectorStore.add(documentList);
    }


}
