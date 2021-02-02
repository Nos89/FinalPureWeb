package kh.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.InfoDAO;
import kh.spring.dto.InfoBoardDTO;
import kh.spring.dto.TakingClassDTO;
import kh.spring.utils.EncryptUtils;

@Service
public class InfoService {
	
	@Autowired
	private InfoDAO idao;

	public int login(String id, String pw) throws Exception {
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
	public List<TakingClassDTO> takingClass(String id, String classRegDate) {
		return idao.takingClass(id,classRegDate);
	}
	
	//강의과목(교수)
	public List<TakingClassDTO> takingClass(String id, String semester, String classOpenDate) {
		return idao.takingClass(id,semester,classOpenDate);
	}

	//강의시간표(학생)
	public List<TakingClassDTO> classSche(String id, String classRegDate) {
		return idao.classSche(id,classRegDate);
	}

	//강의시간표(교수)
	public List<TakingClassDTO> classSche(String id, String semester, String classOpenDate) {
		return idao.classSche(id,semester,classOpenDate);
	}


	
	

}
