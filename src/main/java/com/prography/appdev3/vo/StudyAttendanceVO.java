package com.prography.appdev3.vo;

public class StudyAttendanceVO {	//studyAttendance table: 팀별  스터디 출결관리
	
	private int stuCode = 0;
	private int tmCode = 0;
	private String picture = "";
	private String absentee = "";
	private String memo = "";
	private String uploadTime = "";
	
	
	public int getStuCode() {
		return stuCode;
	}
	public void setStuCode(int stuCode) {
		this.stuCode = stuCode;
	}
	public int getTmCode() {
		return tmCode;
	}
	public void setTmCode(int tmCode) {
		this.tmCode = tmCode;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAbsentee() {
		return absentee;
	}
	public void setAbsentee(String absentee) {
		this.absentee = absentee;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}
