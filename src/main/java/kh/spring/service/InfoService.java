package kh.spring.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.InfoDAO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.InfoBoardDTO;
import kh.spring.dto.TakingClassDTO;

@Service
public class InfoService {
	
	@Autowired
	private InfoDAO idao;

	public int login(String id, String pw) {
		return idao.login(id,pw);
	}

	public String getName(String id, String pw) {
		return idao.getName(id,pw);
	}

	public String getMajor(String id, String pw) {
		return idao.getMajor(id,pw);
	}

	//학사,장학, 입학 최근 게시물
	public List<InfoBoardDTO> getRecentStd() {
		return idao.getRecentStd();
	}

	public List<InfoBoardDTO> getRecentScholar() {
		return idao.getRecentScholar();
	}

	public List<InfoBoardDTO> getRecentEnter() {
		return idao.getRecentEnter();
	}

	//수강과목(학생)
	public List<TakingClassDTO> takingClass(String id, Date tocharDate) {
		return idao.takingClass(id,tocharDate);
	}
	
	//강의과목(교수)
	public List<TakingClassDTO> takingClass(String id, String semester, Date tocharDate) {
		return idao.takingClass(id,semester,tocharDate);
	}

	//강의시간표(학생)
	public List<TakingClassDTO> classSche(String id, Date tocharDate) {
		return idao.classSche(id,tocharDate);
	}

	//강의시간표(교수)
	public List<TakingClassDTO> classSche(String id, String semester, Date tocharDate) {
		return idao.classSche(id,semester,tocharDate);
	}

	//학사일정
	public List<ColScheduleDTO> getColSchedule(Date tocharDate) {
		return idao.getColSchedule(tocharDate);
	}

	//로그인 창 학사일정 4개 보여지는
	public List<ColScheduleDTO> get4ColSchedule(Date mainLogin4_date) {
		return idao.get4ColSchedule(mainLogin4_date);
	}

	//메인페이지, 달에 맞는 학사일정 리스트로
	public List<ColScheduleDTO> getMainSchedule(Date mainDate) {
		return idao.getMainSchedule(mainDate);
	}
	
	public String findIDPW(String find, String userType, String userID, String userName, String pn ) {
		Map<String, String> parm = new HashMap<>();
		parm.put("find", find);
		parm.put("userType", userType);
		parm.put("userID", userID);
		parm.put("userName", userName);
		parm.put("pn", pn);
		return idao.findIDPW(parm);
	}
	
	public int changePW(String id, String pw ) {
		Map<String, String> parm = new HashMap<>();
		parm.put("id", id);
		parm.put("pw", pw);
		return idao.changePW(parm);
	}
	
	public int getUnreadMailNum(String id) {
		return idao.getUnreadMailNum(id);
	}

}
