package com.spring.ai.chatClient_api.config;

import com.spring.ai.chatClient_api.adviser.TokenPrintAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.logging.Logger;

@Configuration
public class AiConfig {

    private Logger  log = Logger.getLogger(String.valueOf(AiConfig.class));

//    @Bean
//    public ChatMemory chatMemory( JdbcChatMemoryRepository jdbcChatMemoryRepository) {
//        return  MessageWindowChatMemory.builder()
//                .chatMemoryRepository(jdbcChatMemoryRepository)
//                .maxMessages(10) // maxm 10 msg store
//                .build();
//
//    }

    @Bean
    public ChatMemory chatMemory() {
        InMemoryChatMemoryRepository memory = new InMemoryChatMemoryRepository();
        return MessageWindowChatMemory.builder().maxMessages(10).chatMemoryRepository(memory).build();
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.log.info("chatMemory implementation class"+chatMemory.getClass().getName());

        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

        return builder

                .defaultAdvisors(messageChatMemoryAdvisor,new TokenPrintAdvisor(), new SimpleLoggerAdvisor(),new SafeGuardAdvisor(List.of("games")))
                .defaultOptions(OpenAiChatOptions.builder()
//                        .model("text-embedding-3-small")

                        .temperature(0.3)
                        .maxTokens(200)

                        .build())
                .build();
    }

}
