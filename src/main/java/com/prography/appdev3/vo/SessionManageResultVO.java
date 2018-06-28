package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class SessionManageResultVO {

	private boolean success = false;
	private List<SessionManageVO> sessionManageList = new ArrayList<SessionManageVO>();
	
	
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
	
	
	
}
