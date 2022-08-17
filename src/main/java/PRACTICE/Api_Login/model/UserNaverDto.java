package PRACTICE.Api_Login.model;

import org.springframework.stereotype.Component;

@Component
public class UserNaverDto {
	  // 동일인 식별 정보는 네이버 아이디마다 고유하게 발급되는 값입니다.
    private String id;

    // 사용자 별명
    private String nickname;

    // 사용자 이름
    private String name;

    // 	사용자 메일 주소
    private String email;

    // 성별
    private String gender;

    // 사용자 연령대
    private String age;

    // 사용자 생일(MM-DD 형식)
    private String birthday;

    // 사용자 프로필 사진 URL
    private String profile_image;

    // 출생연도
    private String birthyear;

    // 휴대전화번호
    private String mobile;
    
	private int role;
	private String accessToken;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
