package com.spring.ai.chatClient_api.service;

import com.spring.ai.chatClient_api.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class chatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public chatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public Tut chat(String query) {
//        String prompt = "tell me about lord krishna";
        // call the llm for response
//        String content  = chatClient
//                .prompt()
//                .user(prompt)
//                .system("As as expet in cricket")
//                .call()
//                .content();
//        return content;


        Prompt prompt1 = new Prompt(query);
        Tut tutorial = chatClient
                .prompt(prompt1)
                .call()
                .entity(Tut.class);
//                .chatResponse()
//                .getResult()
//                .getOutput()
//                .getText();
//        System.out.println(content);
//        return content;

        return tutorial;
    }
}
