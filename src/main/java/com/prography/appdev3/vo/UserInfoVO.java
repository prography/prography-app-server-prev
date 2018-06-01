package com.prography.appdev3.vo;



public class UserInfoVO {
	
	private String memCode = "";
	private String id = "";
	private String pw = "";
	private String name = "";
	private String nickname = "";
	private String team = "";
	private String birth = "";
	private int recBalloon = 0;
	
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getRecBalloon() {
		return recBalloon;
	}
	public void setRecBalloon(int recBalloon) {
		this.recBalloon = recBalloon;
	}
	public int getBalloon() {
		return balloon;
	}
	public void setBalloon(int balloon) {
		this.balloon = balloon;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	private int balloon = 0;
	private int icon = 0;

}
