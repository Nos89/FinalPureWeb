package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.LectureDAO;
import kh.spring.dto.ClassRegistrationDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.OpenClass_LecPlan;

@Service
public class LectureService {
	@Autowired
	private LectureDAO ldao;
	
	
	
	public List<OpenClass_LecPlan> selectOpenClass_lecPlan(String id){
		return ldao.selectOpenClass_lecPlan(id);
	}

	public List<LectureDTO> selectLecture(String id){
		return ldao.selectLecture(id);
		
	}
	public int updateLecturePlan(LectureDTO dto) {
		return ldao.updateLecturePlan(dto);
	}
	public int insertLecturePlan(LectureDTO dto) {
		return ldao.insertLecturePlan(dto);
	}
}
