package com.prography.appdev3.vo;

public class SessionAttendanceVO {
	
	private int sesCode = 0;
	private int memCode = 0;
	private int sesAttendance = 0;
	private int late = 0;
	private int penalty = 0;
	
	
	public int getSesCode() {
		return sesCode;
	}
	public void setSesCode(int sesCode) {
		this.sesCode = sesCode;
	}
	public int getMemCode() {
		return memCode;
	}
	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}
	public int getSesAttendance() {
		return sesAttendance;
	}
	public void setSesAttendance(int sesAttendance) {
		this.sesAttendance = sesAttendance;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

}
