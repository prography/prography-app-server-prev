package com.prography.appdev3.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.*;

import com.prography.appdev3.mapper.dataMapper;
import com.prography.appdev3.vo.DeleteFreeResultVO;
import com.prography.appdev3.vo.FreeBoardResultVO;
import com.prography.appdev3.vo.FreeBoardVO;
import com.prography.appdev3.vo.IdCheckResultVO;
import com.prography.appdev3.vo.IdCheckVO;
import com.prography.appdev3.vo.LoginResultVO;
import com.prography.appdev3.vo.LoginVO;
import com.prography.appdev3.vo.PostFreeResultVO;
import com.prography.appdev3.vo.PostStuMemoResultVO;
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

@RestController // 이 클래스를 송수신을 담당하는 클래스로 지정
				// 이 아이를 사용해서 rest api를 만들수 있음 뷰를 만들어내는 것 뿐 아니라 데이터 처리를 위한 컨트롤러를 만들어낼 수 있음
public class Project {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired // bean이랑 비슷한 애 이거를 선언하면 getter setter를 자동으로 만들음
	private dataMapper dataMapper;// dataMapper연결

	// member=====================================================================================================================================

	// 로그인
	@RequestMapping(value = "/Login", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody LoginResultVO UserCheck(@RequestBody Map<String, Object> json) {// 앱에서 객체로 주는 것을 제이슨으로 받아옴
		// @RequestBody 어노테이션은 @RequestMapping에 의해 POST 방식으로 전송된 HTTP 요청 데이터를 String 타입의
		// body 파라미터로 전달된다.(수신)
		// 그리고 @ResponseBody 어노테이션이 @RequestMapping 메서드에서 적용되면 해당 메서드의 리턴 값을 HTTP 응답
		// 데이터로 사용한다.
		// simpleTest() 메서드의 리턴 값이 String 타입이므로 String 데이터를 HTTP 응답 데이터로 전송한다.(송신)

		logger.debug("user check > " + json.get("id") + "/" + json.get("pw"));

		String id = (String) json.get("id");// 이름 dataMapper.java이름과 동일하게
		String pw = (String) json.get("pw");

		LoginResultVO login = new LoginResultVO();
		ArrayList<LoginVO> loginresult = new ArrayList<LoginVO>();

		try {
			loginresult = dataMapper.UserCheck(id, pw);

			if (loginresult.size() > 0) {
				login.setSuccess(true);
				login.setMessage(id);
			} else {
				login.setSuccess(false);
				login.setMessage("아이디 또는 비밀번호가 일치하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;

	}

	// ID중복확인
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody IdCheckResultVO IdCheck(@RequestBody Map<String, Object> json) {

		String id = (String) json.get("id");

		IdCheckResultVO idCheck = new IdCheckResultVO();
		ArrayList<UserInfoVO> idCheckResult = new ArrayList<UserInfoVO>();

		try {

			idCheckResult = dataMapper.IdCheck(id);
			// logger.debug("user check > " + idCheckResult.size());
			if (idCheckResult.isEmpty()) {
				idCheck.setSuccess(true);
				idCheck.setMessage("사용할 수 있는 아이디입니다");

			} else {
				idCheck.setSuccess(false);
				idCheck.setMessage("입력하신 아이디는 이미 있는 아이디 입니다. 다른 아이디를 입력해주세요");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return idCheck;

	}

	// 회원가입
	@RequestMapping(value = "/member", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SignUpResultVO SignUpCheck(@RequestBody Map<String, Object> json) {

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

			dataMapper.SignUpCheck(memCode, id, pw, name, nickname, tmCode, birth, recBalloon, balloon, icon, sesAbsent,
					stuAbsent, totPenalty);
			signUp.setSuccess(true);
			signUp.setMessage("환영합니다^_^");

		} catch (Exception e) {

			signUp.setSuccess(false);
			signUp.setMessage("입력한 아이디는 이미 있는 아이디입니다. 다른 아이디로 가입해주세요");
			e.printStackTrace();
		}
		return signUp;

	}

	// 회원정보(member table)출력
	@RequestMapping(value = "/member", method = RequestMethod.GET) // #getUsersInfo => getUserInfo
	public @ResponseBody UserInfoResultVO getUserInfo(
			@RequestParam(value = "memCode", required = false) Integer memCode,
			@RequestParam(value = "tmCode", required = false) Integer tmCode) {
		UserInfoResultVO result = new UserInfoResultVO();
		List<UserInfoVO> userInfoList = new ArrayList<UserInfoVO>();
		if (memCode != null) {
			try {

				userInfoList = dataMapper.getUserInfoByMemCode(memCode);

				result.setSuccess(true);
				result.setResultUserInfo(userInfoList);
			} catch (Exception e) {

				e.printStackTrace();

				result.setSuccess(false);
				result.setResultUserInfo(null);
			}
		} else if (tmCode != null) {
			try {

				userInfoList = dataMapper.getUserInfoByTeam(tmCode);

				result.setSuccess(true);
				result.setResultUserInfo(userInfoList);
			} catch (Exception e) {

				e.printStackTrace();

				result.setSuccess(false);
				result.setResultUserInfo(null);
			}
		} else {
			try {

				userInfoList = dataMapper.getUserInfo();

				result.setSuccess(true);
				result.setResultUserInfo(userInfoList);
			} catch (Exception e) {

				e.printStackTrace();

				result.setSuccess(false);
				result.setResultUserInfo(null);
			}
		}

		return result;
	}

	
	// 개인 누적 스터디 출결 출력
		@RequestMapping(value = "/getStuAbsent", method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody UserInfoResultVO GetStuAbsent(@RequestBody Map<String, Object> json) {// 제이슨으로 결과리턴

			int memCode = (int) json.get("memCode");

			UserInfoResultVO GetStuAbsent = new UserInfoResultVO();// 함수
			ArrayList<UserInfoVO> totStuAbsent = new ArrayList<UserInfoVO>();// 리스트

			try {

				totStuAbsent = dataMapper.getStuAbsent(memCode);

				if (totStuAbsent.size() > 0) {

					GetStuAbsent.setSuccess(true);
					GetStuAbsent.setGetStuAbsent(totStuAbsent);

				}

				else {
					GetStuAbsent.setSuccess(false);
				}

			} catch (Exception e) {
				e.printStackTrace();

			}

			return GetStuAbsent;
		}
	
	
	
	
	
	// team=========================================================================================================================================

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public @ResponseBody TeamInfoResultVO getTeamInfo() {

		TeamInfoResultVO result = new TeamInfoResultVO();
		List<TeamInfoVO> teamList = new ArrayList<TeamInfoVO>();

		try {

			teamList = dataMapper.getTeamsInfo();

			result.setSuccess(true);
			result.setResultTeamInfo(teamList);
		} catch (Exception e) {

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultTeamInfo(null);
		}

		return result;
	}
	
	
	
	
	

	// 팀별 스터디출결(study attendance table)
	@RequestMapping(value = "/getStudyAttendance", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody StudyAttendanceResultVO getStudyAttendance(@RequestBody Map<String, Object> json) {

		String getStudyAttendance = (String) json.get("getStudyAttendance");

		StudyAttendanceResultVO result = new StudyAttendanceResultVO();

		try {

			List<StudyAttendanceVO> resultStuAttendance = dataMapper.getStudyAttendance();

			result.setSuccess(true);
			result.setResultStuAttendance(resultStuAttendance);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultStuAttendance(null);
		}

		return result;
	}

	// 주차별 스터디(study table)
	@RequestMapping(value = "/getStudyManage", method = RequestMethod.GET) // GET으로 바꾸기*****
	public @ResponseBody StudyManageResultVO getStudyManage() {

		StudyManageResultVO result = new StudyManageResultVO();

		List<StudyManageVO> studyManageList = new ArrayList<StudyManageVO>();

		try {

			studyManageList = dataMapper.getStudyManage();

			result.setSuccess(true);
			result.setResultStudyManage(studyManageList);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultStudyManage(null);
		}

		return result;
	}

	// 스터디메모 글쓰기
	@RequestMapping(value = "/postStuMemo", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody PostStuMemoResultVO PostStuMemo(@RequestBody Map<String, Object> json) {

		PostStuMemoResultVO postStuMemo = new PostStuMemoResultVO();

		int stuCode = (int) json.get("stuCode");
		int tmCode = (int) json.get("tmCode");
		String picture = (String) json.get("picture");
		String absentee = (String) json.get("absentee");
		String memo = (String) json.get("memo");
		String uploadTime = (String) json.get("uploadTime");

		try {

			dataMapper.PostStuMemo(stuCode, tmCode, picture, absentee, memo, uploadTime);
			postStuMemo.setSuccess(true);
			postStuMemo.setMessage("글이 등록되었습니다");

			String[] absentee_array = absentee.split(","); // *****json 파싱해서 이름을 얻음
			for (String name : absentee_array) { // *****파싱된 이름의 멤버의 결석횟수를 1 더함
				try { // *****sql 에러가 날 수 있으니 try catch.
					dataMapper.updateStuAbsent(name);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

			postStuMemo.setSuccess(false);
			postStuMemo.setMessage("글을 등록하지 못했습니다");
			e.printStackTrace();
		}
		return postStuMemo;

	}

	// 스터디 불참자 리스트 출력
	@RequestMapping(value = "/selectAbsentee", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody UserInfoResultVO SelectAbsentee(@RequestBody Map<String, Object> json) {// 제이슨으로 결과리턴

		int tmCode = (int) json.get("tmCode");

		UserInfoResultVO SelectAbsentee = new UserInfoResultVO();// 함수
		ArrayList<UserInfoVO> tmMemberList = new ArrayList<UserInfoVO>();// 리스트

		try {

			tmMemberList = dataMapper.selectAbsentee(tmCode);

			if (tmMemberList.size() > 0) {

				SelectAbsentee.setSuccess(true);
				SelectAbsentee.setSelectAbsentee(tmMemberList);

			}

			else {
				SelectAbsentee.setSuccess(false);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return SelectAbsentee;
	}

	
	
	// studyAttendance===============================================================================================================
	
	
	
	
	
	
	

	
	
	
	
	
	// sessinAttendance===============================================================================================================

	// 세션 출결정보 출력
	@RequestMapping(value = "/sessionAttendance", method = RequestMethod.GET)
	public @ResponseBody SessionAttendanceResultVO getSessionAttendance() {

		SessionAttendanceResultVO result = new SessionAttendanceResultVO();

		List<SessionAttendanceVO> sesAttendanceList = new ArrayList<SessionAttendanceVO>();
		try {

			sesAttendanceList = dataMapper.getSessionAttendance();

			result.setSuccess(true);
			result.setResultSesAttendance(sesAttendanceList);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultSesAttendance(null);
		}

		return result;
	}

	// 세션 출결정보 입력
	@RequestMapping(value = "/sessionAttendance", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SessionAttendanceResultVO PostSessionAttendance(@RequestBody Map<String, Object> json) {

		SessionAttendanceResultVO PostSessionAttendance = new SessionAttendanceResultVO();

		int sesCode = (int) json.get("sesCode");
		int memCode = (int) json.get("memCode");
		int sesAttendance = (int) json.get("sesAttendance");
		int late = (int) json.get("late");
		int penalty = (int) json.get("penalty");

		try {

			dataMapper.PostSessionAttendance(sesCode, memCode, sesAttendance, late, penalty);
			PostSessionAttendance.setSuccess(true);
			PostSessionAttendance.setMessage("세션 출결정보가 등록되었습니다");

		} catch (Exception e) {

			PostSessionAttendance.setSuccess(false);
			PostSessionAttendance.setMessage("세션 출결정보를 등록하지 못했습니다");
			e.printStackTrace();
		}
		return PostSessionAttendance;

	}

	
	
	
	
	
	// session============================================================================================================================================

	// 세션정보 출력
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public @ResponseBody SessionManageResultVO getSessionManage() {

		SessionManageResultVO result = new SessionManageResultVO();
		List<SessionManageVO> sessionList = new ArrayList<SessionManageVO>();

		try {

			sessionList = dataMapper.getSession();

			result.setSuccess(true);
			result.setResultSessionManage(sessionList);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultSessionManage(null);
		}

		return result;
	}

	// 세션정보 입력
	@RequestMapping(value = "/session", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SessionManageResultVO PostSession(@RequestBody Map<String, Object> json) {

		SessionManageResultVO postSession = new SessionManageResultVO();

		int sesCode = (int) json.get("sesCode");
		String sesDate = (String) json.get("sesDate");
		String sesInfo = (String) json.get("sesInfo");
		String sesContent = (String) json.get("sesContent");

		try {

			dataMapper.PostSession(sesCode, sesDate, sesInfo, sesContent);
			postSession.setSuccess(true);
			postSession.setMessage("글이 등록되었습니다");

		} catch (Exception e) {

			postSession.setSuccess(false);
			postSession.setMessage("글을 등록하지 못했습니다");
			e.printStackTrace();
		}
		return postSession;

	}

	
	
	

	// freeBoard=================================================================================================================================================

	// 자유게시판(free table)출력
	@RequestMapping(value = "/freeBoard", method = RequestMethod.GET)
	public @ResponseBody FreeBoardResultVO getFreeBoard() {

		FreeBoardResultVO result = new FreeBoardResultVO();
		List<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();

		try {

			freeBoardList = dataMapper.getFreeBoard();

			result.setSuccess(true);
			result.setResultFreeBoard(freeBoardList);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			result.setSuccess(false);
			result.setResultFreeBoard(null);
		}

		return result;
	}

	// 자유게시판 글쓰기
	@RequestMapping(value = "/freeBoard", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody PostFreeResultVO PostFreeBoard(@RequestBody Map<String, Object> json) {

		PostFreeResultVO result = new PostFreeResultVO();

		int freNum = (int) json.get("freNum");
		String freTitle = (String) json.get("freTitle");
		String freContent = (String) json.get("freContent");
		String freDate = (String) json.get("freDate");
		int memCode = (int) json.get("memCode");

		try {

			dataMapper.PostFreeBoard(freNum, freTitle, freContent, freDate, memCode);
			result.setSuccess(true);
			result.setMessage("글이 등록되었습니다");

		} catch (Exception e) {

			result.setSuccess(false);
			result.setMessage("글을 등록하지 못했습니다");
			e.printStackTrace();
		}
		return result;

	}

	@RequestMapping(value = "/freeBoard", method = RequestMethod.DELETE)
	public @ResponseBody DeleteFreeResultVO DeleteFreeBoard(
			@RequestParam(value = "freNum", required = false) Integer freNum,
			@RequestParam(value = "memCode", required = false) Integer memCode) {

		DeleteFreeResultVO result = new DeleteFreeResultVO();

		int authorCode = dataMapper.getFreeBoardByFreNum(freNum).getMemCode();
		if (memCode == authorCode) { // 여기에 운영진 글 삭제 권한 추가하기!
			try {
				dataMapper.DeleteFreeBoard(freNum);
				result.setSuccess(true);
				result.setMessage("글이 삭제되었습니다.");
			} catch (Exception e) {
				// TODO: handle exception

				e.printStackTrace();

				result.setSuccess(false);
				result.setMessage("글을 삭제하지 못했습니다.");
			}
		} else {
			result.setSuccess(false);
			result.setMessage("작성자 및 운영진만 글을 삭제할 수 있습니다.");
		}

		return result;
	}

}
