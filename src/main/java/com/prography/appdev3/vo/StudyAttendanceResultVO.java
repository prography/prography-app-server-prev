package com.prography.appdev3.vo;

import java.util.ArrayList;
import java.util.List;

public class StudyAttendanceResultVO {
	
	private boolean success = false;
	private List<StudyAttendanceVO> stuAttendanceList = new ArrayList<StudyAttendanceVO>();
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<StudyAttendanceVO> getResultStuAttendance() {
		return stuAttendanceList;
	}
	public void setResultStuAttendance(List<StudyAttendanceVO> stuAttendanceList) {
		this.stuAttendanceList = stuAttendanceList;
	}
	
}
