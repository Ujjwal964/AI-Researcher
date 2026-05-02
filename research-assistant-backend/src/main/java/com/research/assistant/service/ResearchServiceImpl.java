package com.research.assistant.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import com.research.assistant.model.ResearchRequest;

@Service
public class ResearchServiceImpl implements ResearchService{
    private final ChatClient chatClient;

    public ResearchServiceImpl(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @Override
    public String processContent(ResearchRequest researchRequest){
        String systemPrompt = buildPrompt(researchRequest);

        String AIResponse = chatClient.
                            prompt()
                            .system(systemPrompt)
                            .user(researchRequest.getContent())
                            .call()
                            .content();
        
        return AIResponse;

    }

    //HELPER METHOD
    static String buildPrompt(ResearchRequest researchRequest){
        StringBuilder prompt = new StringBuilder();

        switch(researchRequest.getOperation()){
            case "summarize" -> prompt.append("Provide a clear and concise summary of the following text in a few sentences : \n\n");
            case "suggest" -> prompt.append("Based on the following content : suggest related topics and further reading.Format the response with clear headings and bullet points : \n\n");
            default -> throw new IllegalArgumentException("Undefined Operation : " + researchRequest.getOperation());
        }
       
        return prompt.toString();
    }
}

















// MANUAL AI API INTEGRATION
// @Service
// public class ResearchService {
//     @Value("&{gemini.api.url}")
//     private String geminiUrl;
//     @Value("&{gemini.api.key}")
//     private String geminiApi;

//     private final WebClient webClient;

//     public ResearchService(WebClient.Builder builder){
//         this.webClient = builder.build();
//     }

//     public String processContent(ResearchRequest researchRequest){
//         //build prompt
//         String prompt = buildPrompt(researchRequest);

//         //query ai api model
//         //input structure for gemini is : contents[] object -> parts[] object -> text : prompt(string).
//         Map<String , Object> requestBody = Map.of(
//             "contents" , new Object[] {
//                 Map.of("parts" , new Object[]{
//                     Map.of("text" , prompt)
//                 })
//             }
//         );
//         System.out.println(requestBody);

//         String response = webClient.post()
//                 .uri(geminiUrl+geminiApi)
//                 .bodyValue(requestBody)
//                 .retrieve()
//                 .bodyToMono(String.class)
//                 .block();


//         //parse response
//         //return response
//         //make method which use same exact way of output return the way gemini gives and return that response here.
//         return ""; 
//     }

//     static String buildPrompt(ResearchRequest researchRequest){
//         StringBuilder prompt = new StringBuilder();

//         switch(researchRequest.getOperation()){
//             case "summarize" -> prompt.append("Provide a clear and concise summary of the following text in a few sentences : \n\n");
//             case "suggest" -> prompt.append("Based on the following content : suggest related topics and further reading.Format the response with clear headings and bullet points : \n\n");
//             default -> throw new IllegalArgumentException("Unknown Operation" + researchRequest.getOperation());
//         }

//         prompt.append(researchRequest.getContent());
//         return prompt.toString();
//     }

// }
