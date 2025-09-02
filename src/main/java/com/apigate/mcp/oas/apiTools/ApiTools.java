package com.apigate.mcp.oas.apiTools;

import com.apigate.mcp.oas.Api;
import com.apigate.mcp.oas.ApiRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

public class ApiTools {

    private final ApiRepository apiRepository;

    public ApiTools(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Tool(description = "API의 Description을 이용해 그에 해당하는 END POINT를 찾는다")
    public String getEndPointFromDescription(@ToolParam String description) {
        return apiRepository.findByDescription(description);
    }

    @Tool(description = "API의 Level을 이용해 그에 해당하는 END POINT List를 찾는다")
    public List<String> getEndPointFromLevel(@ToolParam int level){
        return apiRepository.findByLevel(level).stream().map(Api::getEndpoint).toList();
    }

}
