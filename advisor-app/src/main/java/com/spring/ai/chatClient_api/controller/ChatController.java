package com.spring.ai.chatClient_api.controller;
import com.spring.ai.chatClient_api.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String msg) {
        return ResponseEntity.ok(chatService.chatTemplate(msg));
   }

    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamChat(
            @RequestParam("q") String query
    ){
        return ResponseEntity.ok(this.chatService.streamChat(query));
    }}

