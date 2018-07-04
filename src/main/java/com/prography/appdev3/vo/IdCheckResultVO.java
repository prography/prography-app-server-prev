package com.prography.appdev3.vo;

public class IdCheckResultVO { 	//회원가입시 ID 및 메세지 출력

	
	boolean success;
	String message = "";
	
	
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
