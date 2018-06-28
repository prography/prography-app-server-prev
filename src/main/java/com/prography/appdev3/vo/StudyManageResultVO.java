package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class StudyManageResultVO {
	
	
	private boolean success = false;
	private List<StudyManageVO> studyManageList = new ArrayList<StudyManageVO>();
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<StudyManageVO> getResultStudyManage() {
		return studyManageList;
	}
	public void setResultStudyManage(List<StudyManageVO> studyManageList) {
		this.studyManageList = studyManageList;
	}

}
