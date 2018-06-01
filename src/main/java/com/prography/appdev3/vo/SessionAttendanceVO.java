package com.prography.appdev3.vo;

public class SessionAttendanceVO {
	
	private String memCode = "";
	private int sesAbsence = 0;
	private int totalPenalty = 0;
	
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public int getSesAbsence() {
		return sesAbsence;
	}
	public void setSesAbsence(int sesAbsence) {
		this.sesAbsence = sesAbsence;
	}
	public int getTotalPenalty() {
		return totalPenalty;
	}
	public void setTotalPenalty(int totalPenalty) {
		this.totalPenalty = totalPenalty;
	}

}
