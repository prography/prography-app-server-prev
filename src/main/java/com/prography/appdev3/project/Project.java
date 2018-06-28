package com.prography.appdev3.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prography.appdev3.mapper.dataMapper;
import com.prography.appdev3.vo.FreeBoardResultVO;
import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.LoginDataVo;
import com.prography.appdev3.vo.LoginVo;
import com.prography.appdev3.vo.SessionAttendanceResultVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageResultVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.StudyAttendanceResultVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.StudyManageResultVO;
import com.prography.appdev3.vo.StudyManageVO;
import com.prography.appdev3.vo.TeamInfoResultVO;
import com.prography.appdev3.vo.TeamInfoVO;
import com.prography.appdev3.vo.UserInfoResultVO;
import com.prography.appdev3.vo.UserInfoVO;

@RestController //이 클래스를 송수신을 담당하는 클래스로 지정
public class Project {

	@Autowired
    private dataMapper dataMapper;//dataMapper연결

	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody UserInfoResultVO getUserInfo(@RequestBody Map<String, Object> json) {
		
		String getUserInfo = (String)json.get("getUserInfo");//이름 dataMapper.java이름과 동일하게
        
		UserInfoResultVO result = new UserInfoResultVO();
		ArrayList<UserInfoVO> userInfo = new ArrayList<UserInfoVO>();
		try {

			List<UserInfoVO> resultUserInfo = dataMapper.getUserInfo();
			
			result.setSuccess(true);
			result.setResultUserInfo(resultUserInfo);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultUserInfo(null);
		}
		
	           
		return result;
   }
	
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody LoginVo UserCheck(@RequestBody Map<String, Object> json) {//앱에서 객체로 주는 것을 제이슨으로 받아옴
		
		String userid = (String)json.get("userid");//이름 dataMapper.java이름과 동일하게
		String password = (String)json.get("password");
		
		LoginVo login = new LoginVo();
		ArrayList<LoginDataVo> loginresult = new ArrayList<LoginDataVo>();
		
		try {
			loginresult = dataMapper.userCheck(userid, password);
			
			if(loginresult.size()>0) {
				login.setSuccess(true);
				login.setMessage(userid);
			}
			else {
				login.setSuccess(false);
				login.setMessage("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return login;
		
	}
		
	@RequestMapping("/getTeamInfo")    
	public TeamInfoResultVO getTeamInfo() throws Exception{
        
		TeamInfoResultVO result = new TeamInfoResultVO();
		
		try {

			List<TeamInfoVO> resultTeamInfo = dataMapper.getTeamInfo();
			
			result.setSuccess(true);
			result.setResultTeamInfo(resultTeamInfo);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultTeamInfo(null);
		}
		
	           
		return result;
   }
	
	
	@RequestMapping("/getStudyAttendance")    
	public StudyAttendanceResultVO getStudyAttendance() throws Exception{
        
		StudyAttendanceResultVO result = new StudyAttendanceResultVO();
		
		try {

			List<StudyAttendanceVO> resultStuAttendance = dataMapper.getStudyAttendance();
			
			result.setSuccess(true);
			result.setResultStuAttendance(resultStuAttendance);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultStuAttendance(null);
		}
		
	           
		return result;
   }
	
	
	@RequestMapping("/getStudyManage")    
	public StudyManageResultVO getStudyManage() throws Exception{
        
		StudyManageResultVO result = new StudyManageResultVO();
		
		try {

			List<StudyManageVO> resultStudyManage = dataMapper.getStudyManage();
			
			result.setSuccess(true);
			result.setResultStudyManage(resultStudyManage);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultStudyManage(null);
		}
		
	           
		return result;
   }
	
	
	@RequestMapping("/getSessionAttendance")    
	public SessionAttendanceResultVO getSessionAttendance() throws Exception{
        
		SessionAttendanceResultVO result = new SessionAttendanceResultVO();
		
		try {

			List<SessionAttendanceVO> resultSesAttendance = dataMapper.getSessionAttendance();
			
			result.setSuccess(true);
			result.setResultSesAttendance(resultSesAttendance);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultSesAttendance(null);
		}
		
	           
		return result;
   }

	
	
	@RequestMapping("/getSessionManage")    
	public SessionManageResultVO getSessionManage() throws Exception{
	         
		SessionManageResultVO result = new SessionManageResultVO();
		
		try {

			List<SessionManageVO> resultSessionManage = dataMapper.getSessionManage();
			
			result.setSuccess(true);
			result.setResultSessionManage(resultSessionManage);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultSessionManage(null);
		}
		
	           
		return result;
   }

	
	@RequestMapping("/getFreeBoard")    
	public FreeBoardResultVO getFreeBoard() throws Exception{
        
		FreeBoardResultVO result = new FreeBoardResultVO();
		
		try {

			List<FreeBoardVO> resultFreeBoard = dataMapper.getFreeBoard();
			
			result.setSuccess(true);
			result.setResultFreeBoard(resultFreeBoard);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();

			result.setSuccess(false);
			result.setResultFreeBoard(null);
		}
		
	           
		return result;
   }
	
	
	

}
