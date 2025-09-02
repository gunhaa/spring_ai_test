package com.apigate.mcp.oas;

import com.apigate.mcp.oas.apiTools.ApiTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/mcp")
public class ApiController {

    private final ChatClient chatClient;
    private final ApiTools apiTools;

    public ApiController(ChatClient.Builder chatClientBuilder, ApiTools apiTools) {
        this.chatClient = chatClientBuilder
                .build();
        this.apiTools = apiTools;
    }

    @GetMapping
    public String getApi() {
        PromptTemplate pt = new PromptTemplate("""
        I want find level4 Api
        """);

        return this.chatClient.prompt(pt.create(
                        OllamaOptions.builder()
                                .model(OllamaModel.LLAMA3)
                                .toolNames("getEndPointFromDescription", "getEndPointFromLevel")
                                .build()))
                .tools(apiTools)
                .call()
                .content();
    }
}
