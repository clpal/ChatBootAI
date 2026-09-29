# PDF Question Answering with Ollama & Spring Boot

## Overview

This project implements a Retrieval-Augmented Generation (RAG) solution that allows users to:

- Upload PDF documents
- Extract and process PDF content
- Ask questions about the uploaded PDFs
- Generate answers using Ollama LLMs (Llama3, Qwen, etc.)
- Perform semantic search on document content

## Architecture

```text
User
 |
 | Upload PDF
 v
Spring Boot Application
 |
 v
Apache PDFBox
 |
 v
Text Extraction
 |
 v
Chunking
 |
 v
Embeddings (Ollama)
 |
 v
Vector Store
 |
 | Ask Question
 v
Retriever
 |
 v
Ollama (Llama3)
 |
 v
Answer
```

## Tech Stack

- Java 21
- Spring Boot 3.x
- LangChain4j
- Ollama
- Apache PDFBox
- Maven

## Prerequisites

### Install Java

Verify installation:

```bash
java --version
```

### Install Ollama

Download:

https://ollama.com

Verify:

```bash
ollama --version
```

### Pull Models

```bash
ollama pull llama3
ollama pull nomic-embed-text
```

### Start Ollama

```bash
ollama serve
```

Default URL:

```text
http://localhost:11434
```

## Maven Dependencies

```xml
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j</artifactId>
    <version>1.7.1</version>
</dependency>

<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-ollama</artifactId>
    <version>1.7.1</version>
</dependency>

<dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>3.0.3</version>
</dependency>
```

## Configuration

application.yml

```yaml
ollama:
  base-url: http://localhost:11434
  model: llama3
```

## REST APIs

### Upload PDF

```http
POST /documents/upload
```

Form Data:

```text
file=sample.pdf
```

Response:

```json
{
  "message": "PDF processed successfully"
}
```

### Ask Question

```http
POST /documents/ask
```

Request:

```json
{
  "question": "What is Kafka?"
}
```

Response:

```json
{
  "answer": "Kafka is a distributed event streaming platform."
}
```

## Running the Application

Build:

```bash
mvn clean install
```

Run:

```bash
mvn spring-boot:run
```

Or: