package com.example.ChatBootAI.service;


import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PdfService {

    private String documentText = "";

    public String uploadPdf(MultipartFile file) throws Exception {

        try (PDDocument document = Loader.loadPDF(file.getBytes())) {

            PDFTextStripper stripper = new PDFTextStripper();

            documentText = stripper.getText(document);

            return "PDF Uploaded Successfully";
        }
    }

    public String getDocumentText() {
        return documentText;
    }
}