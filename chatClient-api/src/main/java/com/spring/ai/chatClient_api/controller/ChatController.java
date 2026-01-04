package com.spring.ai.chatClient_api.controller;
import com.spring.ai.chatClient_api.entity.Tut;
import com.spring.ai.chatClient_api.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {
//    private ChatClient chatClient;
//    public ChatController(ChatModel chatModel) {
//        System.out.println(chatModel.getClass().getName());
//        this.chatClient = ChatClient.builder(chatModel).build();
//    }

//    private ChatClient openAiChatClient;
//    private ChatClient ollamaChatClient;
//
//    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient, @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
//        this.openAiChatClient = openAiChatClient;
//        this.ollamaChatClient = ollamaChatClient;
//    }

//    private ChatClient chatClient;
//    public ChatController(ChatClient.Builder chatClient) {
//        this.chatClient = chatClient.build();
//    }

//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value = "q") String message) {
//        String response =
//                this.chatClient
//                        .prompt(message)
//                        .call()
//                        .content();
//        return ResponseEntity.ok(response);
//    }




//    using call chatservice through
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

   @GetMapping("/chat")
    public ResponseEntity<Tut> chat(@RequestParam(value = "q",required = true) String msg) {
        return ResponseEntity.ok(chatService.chat(msg));
   }
}

