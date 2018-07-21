package com.prography.appdev3.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.IdCheckResultVO;
import com.prography.appdev3.vo.LoginVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.StudyManageVO;
import com.prography.appdev3.vo.TeamInfoVO;
import com.prography.appdev3.vo.UserInfoVO;

public interface dataMapper {

	// member table========================================================================================================
	public ArrayList<LoginVO> userCheck(@Param("id") String id, @Param("pw") String pw);// 누가 로그인하는지 알려줌

	public ArrayList<UserInfoVO> idCheck(@Param("id") String id);
	
	public void signUpCheck(@Param("memCode") int memCode, @Param("id") String id, @Param("pw") String pw,
			@Param("name") String name, @Param("nickname") String nickname, @Param("tmCode") int tmCode,
			@Param("birth") String birth, @Param("recBalloon") int recBalloon, @Param("balloon") int balloon,
			@Param("icon") String icon, @Param("sesAbsent") int sesAbsent, @Param("stuAbsent") int stuAbsent,
			@Param("totPenalty") int totPenalty);

	public ArrayList<UserInfoVO> getUserInfo() throws Exception;
	public ArrayList<UserInfoVO> getUserInfoByMemCode(@Param("memCode") int memCode) throws Exception;//#####
	public ArrayList<UserInfoVO> getUserInfoByTeam(@Param("tmCode") int tmCode) throws Exception;//#####

	//세션 결석 업데이트
	public void updateSesAbsent(int memCode);
	
	
	
	
	// team table========================================================================================================
	public ArrayList<TeamInfoVO> getTeamsInfo() throws Exception;

	
	
	
	// studyAttendance table========================================================================================================
	
	public ArrayList<StudyAttendanceVO> getStudyAttendance() throws Exception;

	public void postStudyAttendance(@Param("stuCode") int stuCode, @Param("tmCode") int tmCode,
			@Param("picture") String picture, @Param("absentee") String absentee, @Param("memo") String memo, @Param("uploadTime") String uploadTime);
	
	// ***** 스터디 결석 업데이트
	public void updateStuAbsent(String name);
	
	
	
	// study table========================================================================================================
	
	public ArrayList<StudyManageVO> getStudy() throws Exception;
	
	

	// sessionAttendance table========================================================================================================

	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;

	public void postSessionAttendance(@Param("sesCode") int sesCode, @Param("memCode") int memCode, @Param("sesAttendance") int sesAttendance, @Param("late") int late, @Param("penalty") int penalty);


	
	
	// session table========================================================================================================

	public ArrayList<SessionManageVO> getSession() throws Exception;
	
	public void postSession(@Param("sesCode") int sesCode, @Param("sesDate") String sesDate, @Param("sesInfo") String sesInfo, @Param("sesContent") String sesContent);
	
	
	
	// free table========================================================================================================

	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;

	public FreeBoardVO getFreeBoardByFreNum(@Param("freNum") int freNum);

	public ArrayList<FreeBoardVO> getFreeBoardByKeyword(@Param("keyword") String keyword);

	public ArrayList<FreeBoardVO> getFreeBoardByMemCode(@Param("memCode") int memCode);

	public void postFreeBoard(@Param("freNum") int freNum, @Param("freTitle") String freTitle,
			@Param("freContent") String freContent, @Param("freDate") String freDate, @Param("memCode") int memCode);

	public void deleteFreeBoard(Integer freNum);

	

}
