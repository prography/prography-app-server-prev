package com.prography.appdev3.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.IdCheckResultVO;
import com.prography.appdev3.vo.IdCheckVO;
import com.prography.appdev3.vo.LoginVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.StudyManageVO;
import com.prography.appdev3.vo.TeamInfoVO;
import com.prography.appdev3.vo.UserInfoVO;


public interface dataMapper {
	
	//사용자 정보DB
	public ArrayList<LoginVO> userCheck(@Param("id") String id, @Param("pw") String pw);//누가 로그인하는지 알려줌
	public void SignUpCheck(@Param("memCode") int memCode, @Param("id") String id, @Param("pw") String pw, @Param("name") String name, @Param("nickname") String nickname, @Param("tmCode") int tmCode, @Param("birth") String birth,
			@Param("recBalloon") int recBalloon, @Param("balloon") int balloon, @Param("icon") String icon, @Param("sesAbsent") int sesAbsent, @Param("stuAbsent") int stuAbsent, @Param("totPenalty") int totPenalty);

	public IdCheckResultVO IdCheck(@Param("id") String id);
	public void addUserInfo(UserInfoVO userInfo) throws Exception;
	public ArrayList<UserInfoVO> getUserInfo() throws Exception;
	
	
		
	//팀 정보DB
	public ArrayList<TeamInfoVO> getTeamInfo() throws Exception;
	
	//팀별 스터디 출결DB
	public ArrayList<StudyAttendanceVO> getStudyAttendance() throws Exception;
	
	//주차별 스터디DB 
	public ArrayList<StudyManageVO> getStudyManage() throws Exception;
	
	//주차에 따른 개인별 세션출결DB
	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;
	
	//주차별 세션DB
	public ArrayList<SessionManageVO> getSessionManage() throws Exception;
	
	//자유게시판DB
	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;
	public void PostFreeBoard(@Param("freNum") int freNum, @Param("freTitle") String freTitle, @Param("freContent") String freContent, @Param("freDate") String freDate, @Param("memCode") int memCode);
	
	
	
}
