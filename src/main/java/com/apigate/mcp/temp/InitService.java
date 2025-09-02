package com.apigate.mcp.temp;

import com.apigate.mcp.oas.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitService {

    private final ApiService apiService;

    public void init() {

        // 1. 전자 (Electronics) - Level 1
        String title1 = "전자제품 스펙 조회";
        String description1 = "모델명으로 특정 전자제품의 상세 스펙을 조회하는 API";
        int level1 = 1;
        String endpoint1 = "/electronics/specs";
        apiService.registerApi(title1, description1, level1, endpoint1);

        // 2. 반도체 (Semiconductor) - Level 1
        String title2 = "반도체 재고 확인";
        String description2 = "반도체 부품 코드를 이용해 현재 재고 수량을 확인합니다.";
        int level2 = 1; // level1과 동일한 레벨로 설정하여 테스트 용이성 확보
        String endpoint2 = "/semiconductors/inventory";
        apiService.registerApi(title2, description2, level2, endpoint2);

        // 3. 자동차 (Automotive) - Level 2
        String title3 = "자동차 연비 정보";
        String description3 = "차량 모델과 연식을 기반으로 공식 연비 정보를 제공하는 API";
        int level3 = 2;
        String endpoint3 = "/cars/fuel-economy";
        apiService.registerApi(title3, description3, level3, endpoint3);

        // 4. 금융 (Finance) - Level 2
        String title4 = "실시간 주가 조회";
        String description4 = "종목 코드를 입력받아 현재 주가를 실시간으로 반환합니다.";
        int level4 = 2;
        String endpoint4 = "/finance/stocks/realtime";
        apiService.registerApi(title4, description4, level4, endpoint4);

        // 5. 날씨 (Weather) - Level 3
        String title5 = "주간 날씨 예보";
        String description5 = "지역 코드를 이용해 해당 지역의 7일간 날씨 예보를 조회하는 API";
        int level5 = 3;
        String endpoint5 = "/weather/weekly-forecast";
        apiService.registerApi(title5, description5, level5, endpoint5);

        for (int i = 0; i < 10; i++) {
            String title = "levelTestSearchTitle API" + i;
            String description = "levelTestSearchDescription API" + i;
            int level6 = 4;
            String endpoint = "/levelTest" + i;
            apiService.registerApi(title, description, level6, endpoint);
        }
    }
}
