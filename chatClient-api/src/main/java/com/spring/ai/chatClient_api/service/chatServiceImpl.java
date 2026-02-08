package com.spring.ai.chatClient_api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class chatServiceImpl implements ChatService{


    private ChatClient chatClient;

    public chatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Override
    public String chat(String query) {
//        String prompt = "tell me about lord krishna";
        // call the llm for response
//        String content  = chatClient
//                .prompt()
//                .user(prompt)
//                .system("As as expet in cricket")
//                .call()
//                .content();
//        return content;


//        Prompt prompt1 = new Prompt(query);
//        Tut tutorial = chatClient
//                .prompt(prompt1)
//                .call()
//                .entity(Tut.class);
//                .chatResponse()
//                .getResult()
//                .getOutput()
//                .getText();
//        System.out.println(content);
//        return content;
//        return tutorial;




        Prompt prompt = new Prompt(query);
        //modify this prompt and extra things to prompt make it more interactive
        String queryStr = " as an expert in coding and programming . Always write program in java now reply for this question : {query}";

        var tutorials = chatClient
                .prompt()
                .user(u->u.text(queryStr).param("query",query))
                .call()
                .content();
        return tutorials;
    }

    public String chatTemplate(){
         //first step
//        PromptTemplate strTemplate = PromptTemplate.builder().template("what is {techName}? tell me example {exampleName} ").build();
//
////        render the template
//      String renderMessage =  strTemplate.render(Map.of(
//              "techName", "Spring",
//              "exampleName", "Spring Boot"
//      ));
//
//      Prompt prompt = new Prompt(renderMessage);
//      var content= this.chatClient.prompt(prompt).call().content();
//        return content;



//        var systemPromptTemplate = SystemPromptTemplate.builder()
//                .template("You are a helpful coding assistant. You are an expert in coding")
//                .build();
//        var systemMessage = systemPromptTemplate.createMessage();
//        var userPromptTemplate = PromptTemplate.builder().template("what is {techName}? tell me also about {techExample}");
//        var userMessage =userPromptTemplate.renderer((org.springframework.ai.template.TemplateRenderer) Map.of(
//                "techName", "Spring",
//              "techExample", "Spring Boot"
//        ));
//        Prompt prompt = new Prompt(systemMessage, (Message) userMessage);
//
//        return this.chatClient.prompt(prompt).call().content();



        return this.chatClient
                .prompt()
                .system(system ->
                        system.text("You are a helpful coding assistant. You are an expert in coding."))
                .user(user ->
                        user.text(userMessage)
                                .param("concept", "Spring Framework validation"))
                .call()
                .content();


    }

}
