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
	
	public ArrayList<UserInfoVO> nicknameCheck(@Param("nickname") String nickname);//닉네임 중복확인
	
	public void signUpCheck(@Param("memCode") int memCode, @Param("id") String id, @Param("pw") String pw,
			@Param("name") String name, @Param("nickname") String nickname, @Param("tmCode") int tmCode,
			@Param("birth") String birth, @Param("recBalloon") int recBalloon, @Param("balloon") int balloon,
			@Param("icon") String icon, @Param("sesAbsent") int sesAbsent, @Param("stuAbsent") int stuAbsent,
			@Param("totPenalty") int totPenalty);

	public ArrayList<UserInfoVO> getUserInfo() throws Exception;
	public ArrayList<UserInfoVO> getUserInfoByMemCode(@Param("memCode") int memCode) throws Exception;//#####
	public ArrayList<UserInfoVO> getMemCodeById(@Param("id") String id) throws Exception;//#####
	public ArrayList<UserInfoVO> getTmCodeById(@Param("id") String id) throws Exception;//#####
	
	public ArrayList<UserInfoVO> getUserInfoByTeam(@Param("tmCode") int tmCode) throws Exception;//#####
	public ArrayList<UserInfoVO> getUserInfoByBirth(@Param("month") String month) throws Exception;//#####
	
	//세션 결석 업데이트
	public void updateSesAbsent(int memCode);
	
	//지각비 명예의 전당
	public ArrayList<String> getPenaltyRanking() throws Exception;
	
	
	
	
	// team table========================================================================================================
	public ArrayList<TeamInfoVO> getTeamsInfo() throws Exception;
	
	public ArrayList<TeamInfoVO> getTmCodeByTmName(@Param("tmName") String tmName);//팀이름으로 팀코드찾기
	


	
	
	
	// studyAttendance table========================================================================================================
	
	public ArrayList<StudyAttendanceVO> getStudyAttendance(@Param("tmCode") int tmCode) throws Exception;

	public void postStudyAttendance(@Param("stuCode") int stuCode, @Param("tmCode") int tmCode,
			@Param("picture") String picture, @Param("absentee") String absentee, @Param("memo") String memo, @Param("uploadTime") String uploadTime);
	
	// ***** 스터디 결석 업데이트
	public void updateStuAbsent(String name);
	
	
	
	// study table========================================================================================================
	
	public ArrayList<StudyManageVO> getStudy() throws Exception;
	
	

	// sessionAttendance table========================================================================================================

	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;

	public void postSessionAttendance(@Param("sesCode") int sesCode, @Param("memCode") int memCode, @Param("sesAttendance") int sesAttendance, @Param("late") int late, @Param("penalty") int penalty);
	
	//주차 지각비 출력
	public ArrayList<SessionAttendanceVO> getPenaltyByMemCode(@Param("memCode") int memCode) throws Exception;

	
	
	// session table========================================================================================================

	public ArrayList<SessionManageVO> getSession() throws Exception;
	
	public void postSession(@Param("sesCode") int sesCode, @Param("sesDate") String sesDate, @Param("sesPlace") String sesPlace, @Param("sesInfo") String sesInfo, @Param("sesContent") String sesContent);
	
	public ArrayList<SessionManageVO> getSessionByDate(@Param("sesDate") String sesDate);

	
	// free table========================================================================================================

	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;

	public FreeBoardVO getFreeBoardByFreNum(@Param("freNum") int freNum);

	public ArrayList<FreeBoardVO> getFreeBoardByKeyword(@Param("keyword") String keyword);

	public ArrayList<FreeBoardVO> getFreeBoardByMemCode(@Param("memCode") int memCode);

	public void postFreeBoard(@Param("freNum") int freNum, @Param("freTitle") String freTitle,
			@Param("freContent") String freContent, @Param("freDate") String freDate, @Param("memCode") int memCode);

	public void deleteFreeBoard(Integer freNum);

	
	

}
