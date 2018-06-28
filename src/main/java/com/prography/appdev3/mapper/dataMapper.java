package com.prography.appdev3.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.LoginDataVo;
import com.prography.appdev3.vo.LoginVo;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.StudyManageVO;
import com.prography.appdev3.vo.TeamInfoVO;
import com.prography.appdev3.vo.UserInfoVO;


public interface dataMapper {
	public ArrayList<FreeBoardVO> getFreeBoard() throws Exception;
	public ArrayList<SessionAttendanceVO> getSessionAttendance() throws Exception;
	public ArrayList<SessionManageVO> getSessionManage() throws Exception;
	public ArrayList<StudyAttendanceVO> getStudyAttendance() throws Exception;
	public ArrayList<StudyManageVO> getStudyManage() throws Exception;
	public ArrayList<UserInfoVO> getUserInfo() throws Exception;
	public ArrayList<TeamInfoVO> getTeamInfo() throws Exception;
	public ArrayList<LoginDataVo> userCheck(@Param("userid") String userid,@Param("password") String password) throws Exception;//누가 로그인하는지 알려줌
	
	
}
