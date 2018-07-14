package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoResultVO { 	//member table¿ª arrayList∑Œ π≠æÓ¡‹
	
	private boolean success = false;
	private List<UserInfoVO> userInfoList = new ArrayList<UserInfoVO>();
	private ArrayList<UserInfoVO> tmMemberList = new ArrayList<UserInfoVO>();
	
	
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
	public void setSelectAbsentee(ArrayList<UserInfoVO> tmMemberList) {
		this.tmMemberList = tmMemberList;
		
	}
	

}
