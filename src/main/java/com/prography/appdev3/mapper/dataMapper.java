package com.prography.appdev3.mapper;

import java.util.ArrayList;

import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.NoticeBoardVO;
import com.prography.appdev3.vo.QnaBoardVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.TeamPageVO;
import com.prography.appdev3.vo.UserInfoVO;

public interface dataMapper {
	public ArrayList<UserInfoVO> getUserInfo() throws Exception;
	public ArrayList<TeamPageVO> getTeamPage() throws Exception;
	public ArrayList<StudyAttendanceVO> getStudyAttendance() throws Exception;
	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;
	public ArrayList<SessionManageVO> getSessionManage() throws Exception;
	public ArrayList<NoticeBoardVO> getNoticeBoard() throws Exception;
	public ArrayList<QnaBoardVO> getQnaBoard() throws Exception;
	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;
}
