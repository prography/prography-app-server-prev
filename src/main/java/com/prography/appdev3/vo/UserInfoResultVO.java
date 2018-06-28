package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoResultVO {
	
	private boolean success = false;
	private List<UserInfoVO> userInfoList = new ArrayList<UserInfoVO>();
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<UserInfoVO> getResultUserInfo() {
		return userInfoList;
	}
	public void setResultUserInfo(List<UserInfoVO> userInfoList) {
		this.userInfoList = userInfoList;
	}

}
