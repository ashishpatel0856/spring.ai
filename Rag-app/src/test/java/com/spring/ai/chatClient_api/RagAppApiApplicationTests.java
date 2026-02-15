package com.spring.ai.chatClient_api;

import com.spring.ai.chatClient_api.helper.Helper;
import com.spring.ai.chatClient_api.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ChatClientApiApplication.class)
class RagAppApiApplicationTests {

	@Autowired
	private ChatService chatService;

	@Test
	void saveDataToVectorDatabase(){
		System.out.println("saving data to database");
		chatService.saveData(Helper.getData());
		System.out.println("data is saved successfully");
	}


}

