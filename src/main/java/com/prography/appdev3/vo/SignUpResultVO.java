package com.prography.appdev3.vo;

public class SignUpResultVO { 	//회원가입 성공여부 및 메세지출력
	
	public boolean success;
	public String message = "";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	

}
