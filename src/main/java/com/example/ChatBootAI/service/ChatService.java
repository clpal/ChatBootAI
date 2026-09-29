package com.example.ChatBootAI.service;


import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final PdfService pdfService;

    public ChatService(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    public String askQuestion(String question) {

        ChatModel model =
                OllamaChatModel.builder()
                        .baseUrl("http://localhost:11434")
                        .modelName("llama3.1")
                        .build();

        String prompt = """
                Answer using document context only.

                DOCUMENT:
                %s

                QUESTION:
                %s
                """
                .formatted(
                        pdfService.getDocumentText(),
                        question);

        return model.chat(prompt);
    }
}