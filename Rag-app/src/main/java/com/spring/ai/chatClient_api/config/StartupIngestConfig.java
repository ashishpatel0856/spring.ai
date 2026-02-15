//package com.spring.ai.chatClient_api.config;
//import com.spring.ai.chatClient_api.helper.Helper;
//import com.spring.ai.chatClient_api.service.ChatService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StartupIngestConfig {
//
//    @Bean
//    CommandLineRunner ingestOnStartup(ChatService chatService) {
//        return args -> {
//            chatService.saveData(Helper.getData());
//        };
//    }
//}
//
