package com.prography.appdev3.vo;

public class LoginResultVO { //login성공 여부판단 및 메세지 출력
	
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
