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
	public ArrayList<LoginVO> UserCheck(@Param("id") String id, @Param("pw") String pw);// 누가 로그인하는지 알려줌

	public void SignUpCheck(@Param("memCode") int memCode, @Param("id") String id, @Param("pw") String pw,
			@Param("name") String name, @Param("nickname") String nickname, @Param("tmCode") int tmCode,
			@Param("birth") String birth, @Param("recBalloon") int recBalloon, @Param("balloon") int balloon,
			@Param("icon") String icon, @Param("sesAbsent") int sesAbsent, @Param("stuAbsent") int stuAbsent,
			@Param("totPenalty") int totPenalty);

	public ArrayList<UserInfoVO> IdCheck(@Param("id") String id);

	public void addUserInfo(UserInfoVO userInfo) throws Exception;

	public ArrayList<UserInfoVO> getUserInfo() throws Exception;

	public ArrayList<UserInfoVO> getUserInfoByMemCode(@Param("memCode") int memCode) throws Exception;

	public ArrayList<UserInfoVO> getUserInfoByTeam(@Param("tmCode") int tmCode) throws Exception;

	
	
	
	
	
	// team table========================================================================================================
	public ArrayList<TeamInfoVO> getTeamsInfo() throws Exception;

	
	
	
	
	
	// 스터디 결석자 고르기
	public ArrayList<UserInfoVO> selectAbsentee(@Param("tmCode") int tmCode);

	// 팀별 스터디 출결DB
	public ArrayList<StudyAttendanceVO> getStudyAttendance() throws Exception;

	// 개인 누적 스터디 출결 출력
	public ArrayList<UserInfoVO> getStuAbsent(@Param("memCode") int memCode);

	

	// 스터디 메모 글쓰기
	public void PostStuMemo(@Param("stuCode") int stuCode, @Param("tmCode") int tmCode,
			@Param("picture") String picture, @Param("absentee") String absentee, @Param("memo") String memo,
			@Param("uploadTime") String uploadTime);

	// ***** 스터디 결석 업데이트
	public void updateStuAbsent(String name);
	
	
	// studyAttendance table========================================================================================================
	
	
	
	
	
	// study table========================================================================================================
	
	public ArrayList<StudyManageVO> getStudy() throws Exception;
	
	

	// sessionAttendance table========================================================================================================

	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;

	public void PostSessionAttendance(@Param("sesCode") int sesCode, @Param("memCode") int memCode, @Param("sesAttendance") int sesAttendance, @Param("late") int late, @Param("penalty") int penalty);


	
	
	// session table========================================================================================================

	public ArrayList<SessionManageVO> getSession() throws Exception;
	
	public void PostSession(@Param("sesCode") int sesCode, @Param("sesDate") String sesDate, @Param("sesInfo") String sesInfo, @Param("sesContent") String sesContent);
	
	
	
	// free table========================================================================================================

	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;

	public FreeBoardVO getFreeBoardByFreNum(@Param("freNum") int freNum);

	public ArrayList<FreeBoardVO> getFreeBoardByKeyword(@Param("keyword") String keyword);

	public ArrayList<FreeBoardVO> getFreeBoardByMemCode(@Param("memCode") int memCode);

	public void PostFreeBoard(@Param("freNum") int freNum, @Param("freTitle") String freTitle,
			@Param("freContent") String freContent, @Param("freDate") String freDate, @Param("memCode") int memCode);

	public void DeleteFreeBoard(Integer freNum);

	

}
