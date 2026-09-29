package com.example.ChatBootAI.controller;
import com.example.ChatBootAI.model.ChatRequest;
import com.example.ChatBootAI.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String askQuestion(@RequestBody ChatRequest request) {

        return chatService.askQuestion(
                request.getQuestion());
    }
}