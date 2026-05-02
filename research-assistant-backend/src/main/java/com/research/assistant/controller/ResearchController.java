package com.research.assistant.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.research.assistant.model.ResearchRequest;
import com.research.assistant.service.ResearchService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/research")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ResearchController {

    // @Autowired   - no need to write as per new spring nowadays.
    private final ResearchService researchService;
    //OR either we do constructor injection
    // public ResearchController(ResearchService researchService){
    //     this.researchService = researchService;
    // }
    //OR just directly use lombok inbuild annotations as @AllArgsConstructor or @RequiredArgsConstructor.
    //@RequiredArgsConstructor if using this then field should be final that means Required.

    @PostMapping("/content")
    public ResponseEntity<String> processContent(@RequestBody ResearchRequest researchRequest){
        String answer = researchService.processContent(researchRequest);
        return new ResponseEntity<>(answer , HttpStatus.OK);
    }

}
