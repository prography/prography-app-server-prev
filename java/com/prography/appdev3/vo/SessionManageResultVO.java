package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class SessionManageResultVO {	//session table¿ª arrayList∑Œ π≠æÓ¡‹

	private boolean success = false;
	private List<SessionManageVO> sessionManageList = new ArrayList<SessionManageVO>();
	public String message = "";
	
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<SessionManageVO> getResultSessionManage() {
		return sessionManageList;
	}
	public void setResultSessionManage(List<SessionManageVO> sessionManageList) {
		this.sessionManageList = sessionManageList;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
