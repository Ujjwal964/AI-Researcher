# 🚀 AI Research Assistant (Chrome Extension + Spring AI)

> An AI-powered Chrome Extension that helps users instantly summarize content and generate research insights directly from any webpage.

---

## 🧠 Overview

The AI Research Assistant is a full-stack project designed to enhance productivity for researchers, students, and professionals by eliminating the need to manually analyze large volumes of text.

With a simple text selection, users can:
- Generate structured summaries
- Get context-aware suggestions
- Save and manage research notes

---

## ❗ Problem Statement

Modern research workflows are inefficient because:
- Users must read entire articles to extract key ideas  
- Switching between tools breaks focus and flow  
- Finding related insights requires manual searching  

---

## 💡 Solution

This project introduces a browser-integrated AI assistant that:

- Works directly inside the browser (Chrome Extension)
- Uses LLM (Gemini) to process selected content
- Provides instant, structured, research-oriented output

---

## ✨ Key Features

### 🔍 Smart Text Interaction
- Select any text on a webpage
- Trigger AI processing instantly

### 📄 Research-Oriented Summarization
- Structured output:
  - Key Idea  
  - Main Points (numbered)  
  - Important Facts  
  - Insights  

### 💡 Contextual Suggestions
- Generates related ideas and directions for deeper exploration

### 📝 Notes Management
- Save research notes locally
- Persistent via LocalStorage

### 📋 Copy to Clipboard
- One-click copy for quick usage

### 🎯 Clean & Minimal UI
- Focused design for distraction-free experience
- Smooth UX with subtle animations

### ⚡ Real-time AI Processing
- Backend powered by Spring AI + Gemini LLM

---

## 🏗️ Tech Stack

### 🔹 Backend
- Java  
- Spring Boot  
- Spring AI  
- Google Gemini API  

### 🔹 Frontend (Chrome Extension)
- HTML  
- CSS  
- JavaScript  
- Chrome Extension APIs  

### 🔹 Tools & Practices
- Git & GitHub  
- REST API Design  
- Environment Variable Management  

---


## 📂 Project Structure

SMART-RESEARCH-ASSISTANT/
│
├── research-assistant-backend/
│   ├── src/main/java/com/research/assistant/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── service/
│   │   └── SmartResearchAssistantApplication.java
│   │
│   ├── src/main/resources/
│   │   └── application.yaml
│   │
│   ├── .env
│   ├── pom.xml
│   └── mvnw
│
├── research-assistant-frontend/
│   ├── images/
│   ├── sidepanel/
│   │   ├── sidepanel.html
│   │   ├── sidepanel.css
│   │   └── sidepanel.js
│   │
│   ├── background.js
│   └── manifest.json
│
└── README.md

---

## ⚙️ Setup Instructions

---

### 🔹 1. Clone Repository

bash git clone https://github.com/Ujjwal964/AI-Researcher.git cd SMART-RESEARCH-ASSISTANT 

---

### 🔹 2. Backend Setup

bash cd research-assistant-backend mvn spring-boot:run 

---

### 🔹 3. Configure Environment Variables

Add to terminal or .zshrc:

bash export GEMINI_KEY=your_api_key_here export GEMINI_MODEL=models/gemini-flash-latest 

Then run:

bash source ~/.zshrc 

---

### 🔹 4. Load Chrome Extension

1. Open Chrome → chrome://extensions/
2. Enable Developer Mode
3. Click Load Unpacked
4. Select:

research-assistant-frontend/

📘 Official Documentation: " https://developer.chrome.com/docs/extensions/ "

---

## 🚀 Usage

1. Open any webpage  
2. Highlight text  
3. Click:
   - Suggest → get related insights  
   - Summarize → get structured summary  
4. Save or copy results  

---

## 📈 Future Enhancements

- ☁️ Cloud-based note storage  
- 🔐 Authentication system  
- 📊 Export notes (PDF / Markdown)  
- ⚡ Streaming AI responses  
- 🔎 Multi-page research tracking  
- 🎨 Theme customization  

---

## 🌟 Why This Project Matters

This project demonstrates:

- Real-world LLM integration
- Full-stack system design
- Chrome Extension development
- Clean UI/UX thinking
- Production-level environment handling

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub!

---

## 🧑‍💻 Author

Ujjwal Bansal

- GitHub: ( https://github.com/Ujjwal964 )
- LinkedIn: ( https://www.linkedin.com/in/ujjwalbansall/ )  
