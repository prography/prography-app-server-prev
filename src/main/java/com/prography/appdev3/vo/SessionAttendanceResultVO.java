package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class SessionAttendanceResultVO {	//sessionAttendance table¿ª arrayList∑Œ π≠æÓ¡‹
	
	
	private boolean success = false;
	private List<SessionAttendanceVO> sesAttendanceList = new ArrayList<SessionAttendanceVO>();
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
	public List<SessionAttendanceVO> getResultSesAttendance() {
		return sesAttendanceList;
	}
	public void setResultSesAttendance(List<SessionAttendanceVO> sesAttendanceList) {
		this.sesAttendanceList = sesAttendanceList;
	}
	

}
