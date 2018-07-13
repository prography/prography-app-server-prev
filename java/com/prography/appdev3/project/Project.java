package com.prography.appdev3.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prography.appdev3.mapper.dataMapper;
import com.prography.appdev3.vo.FreeBoardResultVO;
import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.IdCheckResultVO;
import com.prography.appdev3.vo.IdCheckVO;
import com.prography.appdev3.vo.LoginResultVO;
import com.prography.appdev3.vo.LoginVO;
import com.prography.appdev3.vo.PostFreeResultVO;
import com.prography.appdev3.vo.SessionAttendanceResultVO;
import com.prography.appdev3.vo.SessionAttendanceVO;
import com.prography.appdev3.vo.SessionManageResultVO;
import com.prography.appdev3.vo.SessionManageVO;
import com.prography.appdev3.vo.SignUpResultVO;
import com.prography.appdev3.vo.StudyAttendanceResultVO;
import com.prography.appdev3.vo.StudyAttendanceVO;
import com.prography.appdev3.vo.StudyManageResultVO;
import com.prography.appdev3.vo.StudyManageVO;
import com.prography.appdev3.vo.TeamInfoResultVO;
import com.prography.appdev3.vo.TeamInfoVO;
import com.prography.appdev3.vo.UserInfoResultVO;
import com.prography.appdev3.vo.UserInfoVO;

@RestController //이 클래스를 송수신을 담당하는 클래스로 지정
				//이 아이를 사용해서 rest api를 만들수 있음 뷰를 만들어내는 것 뿐 아니라 데이터 처리를 위한 컨트롤러를 만들어낼 수 있음
public class Project {
	
	Logger logger = LoggerFactory.getLogger(Project.class);

	@Autowired	//bean이랑 비슷한 애 이거를 선언하면  getter setter를 자동으로 만들음
    private dataMapper dataMapper;//dataMapper연결
	
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody LoginResultVO UserCheck(@RequestBody Map<String, Object> json) {//앱에서 객체로 주는 것을 제이슨으로 받아옴
		// @RequestBody 어노테이션은 @RequestMapping에 의해 POST 방식으로 전송된 HTTP 요청 데이터를 String 타입의 body 파라미터로 전달된다.(수신)

		// 그리고 @ResponseBody 어노테이션이 @RequestMapping 메서드에서 적용되면 해당 메서드의 리턴 값을 HTTP 응답 데이터로 사용한다.

		// simpleTest() 메서드의 리턴 값이 String 타입이므로 String 데이터를 HTTP 응답 데이터로 전송한다.(송신)


		
		logger.debug("user check > " + json.get("user_id") + "/" + json.get("user_pw"));
		
		
		String id = (String)json.get("id");//이름 dataMapper.java이름과 동일하게
		String pw = (String)json.get("pw");
		
		
		LoginResultVO login = new LoginResultVO();
		ArrayList<LoginVO> loginresult = new ArrayList<LoginVO>();
		
		try {
			loginresult = dataMapper.userCheck(id, pw);
			
			if(loginresult.size()>0) {
				login.setSuccess(true);
				login.setMessage(id);
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
	
	
	@RequestMapping(value="/signUp", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SignUpResultVO SignUpCheck (@RequestBody Map<String, Object> json) {
		
		SignUpResultVO signUp = new SignUpResultVO();
			
		
		int memCode = (int) json.get("memCode");
		String id = (String) json.get("id");
		String pw = (String) json.get("pw");
		String name = (String) json.get("name");
		String nickname = (String) json.get("nickname");
		int tmCode = (int) json.get("tmCode");
		String birth = (String) json.get("birth");
		int recBalloon = (int) json.get("recBalloon");
		int balloon = (int) json.get("balloon");
		String icon = (String) json.get("icon");
		int sesAbsent = (int) json.get("sesAbsent");
		int stuAbsent = (int) json.get("stuAbsent");
		int totPenalty = (int) json.get("totPenalty");

	

		try {

			dataMapper.SignUpCheck(memCode, id, pw, name, nickname, tmCode, birth, recBalloon, balloon, icon, sesAbsent, stuAbsent, totPenalty);
			signUp.setSuccess(true);
			signUp.setMessage("환영합니다^_^");

		} catch (Exception e) {

			signUp.setSuccess(false);
			signUp.setMessage("입력한 아이디는 이미 있는 아이디입니다. 다른 아이디로 가입해주세요");
			e.printStackTrace();
		}
		return signUp;
		
		
	}
	
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody IdCheckResultVO IdCheck(@RequestBody Map<String, Object> json) {

		String id = (String) json.get("id");

		IdCheckResultVO idCheck = new IdCheckResultVO();

		ArrayList<IdCheckVO> idCheckList = new ArrayList<IdCheckVO>();

		try {
			idCheck = dataMapper.IdCheck(id);

			if (idCheckList.size() > 0) {
				idCheck.setSuccess(false);
				idCheck.setMessage("입력하신 아이디는 이미 있는 아이디 입니다. 다른 아이디를 입력해주세요");
			} else {
				idCheck.setSuccess(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCheck;

	}
	

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
	
	
	
		
	@RequestMapping(value = "/getTeamInfo", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody TeamInfoResultVO getTeamInfo(@RequestBody Map<String, Object> json) {
		
		String getTeamInfo = (String)json.get("getTeamInfo");
        
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
	
	
	@RequestMapping(value = "/getStudyAttendance", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody StudyAttendanceResultVO getStudyAttendance(@RequestBody Map<String, Object> json) {
		
		String getStudyAttendance = (String)json.get("getStudyAttendance");
        
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
	
	
	@RequestMapping(value = "/getStudyManage", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody StudyManageResultVO getStudyManage(@RequestBody Map<String, Object> json) {
		
		String getStudyManage = (String)json.get("getStudyManage");
        
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
	
	
	@RequestMapping(value = "/getSessionAttendance", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody SessionAttendanceResultVO getSessionAttendance(@RequestBody Map<String, Object> json) {
		
		String getSessionAttendance = (String)json.get("getSessionAttendance");
        
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

	
	
	@RequestMapping(value = "/getSessionManage", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody SessionManageResultVO getSessionManage(@RequestBody Map<String, Object> json) {
		
		String getSessionManage = (String)json.get("getSessionManage");
	         
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

	
	
	@RequestMapping(value = "/getFreeBoard", method = RequestMethod.POST, consumes = "application/json")    
	public @ResponseBody FreeBoardResultVO getFreeBoard(@RequestBody Map<String, Object> json) {
		
		String getFreeBoard = (String)json.get("getFreeBoard");
        
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
	
	
	//자유게시글 작성
	@RequestMapping(value="/postFreeBoard", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody PostFreeResultVO PostFreeBoard (@RequestBody Map<String, Object> json) {
		
		PostFreeResultVO postFreeBoard = new PostFreeResultVO();
			
		
		int freNum = (int) json.get("freNum");
		String freTitle = (String) json.get("freTitle");
		String freContent = (String) json.get("freContent");
		String freDate = (String) json.get("freDate");
		int memCode = (int) json.get("memCode");
		
	

		try {

			dataMapper.PostFreeBoard(freNum, freTitle, freContent, freDate, memCode);
			postFreeBoard.setSuccess(true);
			postFreeBoard.setMessage("글이 등록되었습니다");

		} catch (Exception e) {

			postFreeBoard.setSuccess(false);
			postFreeBoard.setMessage("글을 등록하지 못했습니다");
			e.printStackTrace();
		}
		return postFreeBoard;
		
		
	}
	

}
