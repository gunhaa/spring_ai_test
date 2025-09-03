package com.apigate.mcp.oas;

import com.apigate.mcp.loggerAdvisor.LoggerAdvisor;
import com.apigate.mcp.oas.apiTools.ApiTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
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
        Advisor loggerAdvisor = new LoggerAdvisor();
        this.chatClient = chatClientBuilder
                .defaultAdvisors(loggerAdvisor)
                .build();
        this.apiTools = apiTools;
    }

    @GetMapping
    public String getApi() {
        PromptTemplate pt = new PromptTemplate("""
        I want find list of apis of level 4
        and explain reason to choose tool
        """);

        return chatClient.prompt(pt.create(
                        OllamaOptions.builder()
                                .model("qwen3:4b-instruct")
//                                .toolNames("getEndPointFromDescription", "getEndPointFromLevel")
                                .build()))
                .tools(apiTools)
                .call()
                .content();
    }
}
