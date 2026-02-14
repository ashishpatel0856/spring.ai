package com.spring.ai.chatClient_api.controller;
import com.spring.ai.chatClient_api.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class ChatController {

//    using call chatservice through
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

   @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String msg,
                                       @RequestHeader("userId") String userId
   ) {
        return ResponseEntity.ok(chatService.chatTemplate(msg,userId));
   }

    @GetMapping("/rag")
    public ResponseEntity<Flux<String>> streamChat(
            @RequestParam("q") String query,
            @RequestHeader("userId") String userId
    ){
        return ResponseEntity.ok(this.chatService.streamChat(query, userId));


    }}

