package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class TeamInfoResultVO {

	private boolean success = false;
	private List<TeamInfoVO> teamInfoList = new ArrayList<TeamInfoVO>();
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<TeamInfoVO> getResultTeamInfo() {
		return teamInfoList;
	}
	public void setResultTeamInfo(List<TeamInfoVO> teamInfoList) {
		this.teamInfoList = teamInfoList;
	}
	
}
