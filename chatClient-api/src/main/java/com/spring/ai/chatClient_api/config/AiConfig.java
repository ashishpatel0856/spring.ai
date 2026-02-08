//package com.spring.ai.chatClient_api.config;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.groq.GroqChatOptions;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AiConfig {
//
////    @Bean(name = "openAiChatClient")
////    public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
////       return ChatClient.builder(chatModel).build();
////    }
////
////    @Bean(name ="ollamaChatClient" )
////    public ChatClient ollamaChatModel(OllamaChatModel chatModel) {
////        return ChatClient.builder(chatModel).build();
////    }
//




//    @Bean
//    public ChatClient chatClient(ChatClient.Builder builder) {
//        return builder
//                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
//                .defaultOptions(GroqChatOptions.builder()
//                        .model("llama-3.1-8b-instant")
//                        .temperature(0.3)
//                        .maxTokens(200)
//                        .build())
//                .build();
//    }
//
//}
