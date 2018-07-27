package com.prography.appdev3.vo;

public class SessionManageVO {	//session table: 

	private int sesCode = 0;
	private String sesPlace="";
	private String sesDate = "";
	private String sesInfo = "";
	private String sesContent = "";


	public int getSesCode() {
		return sesCode;
	}
	public void setSesCode(int sesCode) {
		this.sesCode = sesCode;
	}
	public String getSesDate() {
		return sesDate;
	}
	public void setSesDate(String sesDate) {
		this.sesDate = sesDate;
	}
	public String getSesPlace() {
		return sesPlace;
	}
	public void setSesPlace(String sesPlace) {
		this.sesPlace = sesPlace;
	}
	public String getSesInfo() {
		return sesInfo;
	}
	public void setSesInfo(String sesInfo) {
		this.sesInfo = sesInfo;
	}
	public String getSesContent() {
		return sesContent;
	}
	public void setSesContent(String sesContent) {
		this.sesContent = sesContent;
	}

}
