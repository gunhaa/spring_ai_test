package com.apigate.mcp.oas;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiService {

    private final ApiRepository apiRepository;

    public String getApiEndPoint(String query) {
        System.out.println("사용자 질문: " + query);

        // ChatClient를 사용하여 AI에게 요청을 보냅니다.
        // .prompt()를 통해 대화의 맥락을 구성하고,
        // .user()를 통해 사용자 메시지를 전달합니다.
        // .functions()를 통해 이 대화에서 AI가 사용할 수 있는 '도구'의 이름을 명시합니다.
        // 이 이름은 AiConfiguration에 @Bean으로 등록한 메서드 이름과 일치해야 합니다.
//        ChatResponse response = chatClient.prompt()
//                .user(query)
//                .functions("productFinder") // 사용 가능한 도구 이름 지정
//                .call()
//                .chatResponse();

        // AI가 생성한 최종 응답을 반환합니다.
        // 이 응답은 도구 사용 결과를 바탕으로 만들어진 자연어 문장일 것입니다.
//        return response.getResult().getOutput().getText();
        return null;
    }

    @Transactional
    public Api registerApi(String title, String description, int level, String endpoint) {
        Api createdApi = new Api(title, description, level, endpoint);
        apiRepository.save(createdApi);
        return createdApi;
    }

}
