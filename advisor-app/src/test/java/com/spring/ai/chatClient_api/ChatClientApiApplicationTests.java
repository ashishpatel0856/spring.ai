package com.spring.ai.chatClient_api;

import com.spring.ai.chatClient_api.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatClientApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ChatService chatService;

	@Test
	void testTemplateRender(){
		System.out.println("TemplateRender");
		var output = this.chatService.chatTemplate();
		System.out.println(output);
	}

}
