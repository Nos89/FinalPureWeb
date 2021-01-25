package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.LectureDTO;
import kh.spring.dto.OpenClass_LecPlan;

@Repository
public class LectureDAO {
	@Autowired
	private SqlSession db;

	
	public List<OpenClass_LecPlan> selectOpenClass_lecPlan(String id){
		return db.selectList("Lecture.openClass_lecPlan", id);
	}
	
	public List<LectureDTO> selectLecture(String id){
		return db.selectList("Lecture.selectLecture", id);
	}
	
	public int updateLecturePlan(LectureDTO dto) {
		return db.update("Lecture.updateLecturePlan", dto);
	}
	public int insertLecturePlan(LectureDTO dto) {
		System.out.println("신혼신호");
		System.out.println(dto.getLec_code()+dto.getLec_classroom());
		return db.insert("Lecture.insertLecturePlan",dto);
	}
}
