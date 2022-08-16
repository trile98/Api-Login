package model;

import org.springframework.stereotype.Component;


@Component
public class NaverLoginProfileResponse {

    // API 호출 결과 코드
    private String resultcode;

    // 호출 결과 메시지
    private String message;

    // Profile 상세
    private UserNaverDto response;

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserNaverDto getResponse() {
		return response;
	}

	public void setResponse(UserNaverDto response) {
		this.response = response;
	}

}
