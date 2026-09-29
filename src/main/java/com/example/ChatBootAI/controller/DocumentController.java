package com.example.ChatBootAI.controller;



import com.example.ChatBootAI.service.PdfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final PdfService pdfService;

    public DocumentController(PdfService pdfService) {

        this.pdfService = pdfService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(pdfService.uploadPdf(file));
    }
}