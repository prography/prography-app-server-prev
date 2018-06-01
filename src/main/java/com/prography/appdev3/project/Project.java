package com.prography.appdev3.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prography.appdev3.mapper.dataMapper;
import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.NoticeBoardVO;
import com.prography.appdev3.vo.QnaBoardVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.TeamPageVO;
import com.prography.appdev3.vo.UserInfoVO;

@RestController //이 클래스를 송수신을 담당하는 클래스로 지정
public class Project {

	@Autowired
    private dataMapper dataMapper;//dataMapper연결

	@RequestMapping("/getUserInfo")    
	public List<UserInfoVO> getUserInfo() throws Exception{
           
		List<UserInfoVO> resultUserInfo = dataMapper.getUserInfo();
           
		return resultUserInfo;
	}
		
		
	@RequestMapping("/getTeamPage")    
	public List<TeamPageVO> getTeamPage() throws Exception{
	           
		List<TeamPageVO> resultTeamPage = dataMapper.getTeamPage();
	           
		return resultTeamPage;
   }
	
	
	@RequestMapping("/getStudyAttendance")    
	public List<StudyAttendanceVO> getStudyAttendance() throws Exception{
	           
		List<StudyAttendanceVO> resultStudyAttendance = dataMapper.getStudyAttendance();
	           
		return resultStudyAttendance;
   }
	
	@RequestMapping("/getSessionAttendance")    
	public List<SessionAttendanceVO> getSessionAttendance() throws Exception{
	           
		List<SessionAttendanceVO> resultSessionAttendance = dataMapper.getSessionAttendance();
	           
		return resultSessionAttendance;
   }
	
	@RequestMapping("/getSessionManage")    
	public List<SessionManageVO> getSessionManage() throws Exception{
	           
		List<SessionManageVO> resultSessionManage = dataMapper.getSessionManage();
	           
		return resultSessionManage;
   }


	@RequestMapping("/getNoticeBoard")    
	public List<NoticeBoardVO> getNoticeBoard() throws Exception{
	           
		List<NoticeBoardVO> resultNoticeBoard = dataMapper.getNoticeBoard();
	           
		return resultNoticeBoard;
   }
	
	@RequestMapping("/getQnaBoard")    
	public List<QnaBoardVO> getQnaBoard() throws Exception{
	           
		List<QnaBoardVO> resultQnaBoard = dataMapper.getQnaBoard();
	           
		return resultQnaBoard;
   }
	
	@RequestMapping("/getFreeBoard")    
	public List<FreeBoardVO> getFreeBoard() throws Exception{
	           
		List<FreeBoardVO> resultFreeBoard = dataMapper.getFreeBoard();
	           
		return resultFreeBoard;
	}


}
