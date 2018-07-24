package com.prography.appdev3.vo;

public class NicknameCheckResultVO {//닉네임 중복확인 성공여부 판단 및 메세지출력 

	
	public boolean success;
	public String message = "";
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
