package PRACTICE.Api_Login.model;

import org.springframework.stereotype.Component;

@Component
public class NaverLoginVo {

    // 접근 토큰, 발급 후 expires_in 파라미터에 설정된 시간(초)이 지나면 만료됨
    private String access_token;

    // 갱신 토큰, 접근 토큰이 만료될 경우 접근 토큰을 다시 발급받을 때 사용
    private String refresh_token;

    // 접근 토큰의 타입으로 Bearer와 MAC의 두 가지를 지원
    private String token_type;

    // 	접근 토큰의 유효 기간(초 단위)
    private String expires_in;

    // 에러 코드
    private String error;

    // 에러 메시지
    private String error_description;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

}
