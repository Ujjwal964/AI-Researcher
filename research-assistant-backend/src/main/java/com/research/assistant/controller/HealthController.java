package com.research.assistant.controller;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/")
    public ResponseEntity< Map<String,String> > hello(){
        // return new ResponseEntity<>("Hi There 👋,\nAI Research Assistant Backend is running 🚀",HttpStatus.OK);
        return new ResponseEntity<>(Map.of(
            "message" , "Hi There, AI-Research Assistant Backend is running.",
            "service" , "AI-Researcher",
            "author" , "Ujjwal Bansal"
        ), HttpStatus.OK);
    }
}
