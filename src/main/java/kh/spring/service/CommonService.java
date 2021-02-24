package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CommonDAO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.GradeCardDTO;
import kh.spring.dto.IsuDTO;
import kh.spring.dto.SubjectDTO;

@Service
public class CommonService {

	@Autowired
	private CommonDAO comdao;
		
	public List<SubjectDTO> getSubject(){
		return comdao.getSubject();
	}
	public List<DepartmentDTO> getDepartment(){
		return comdao.getDepartment();
	}
	
	public List<IsuDTO> getIsu(){
		return comdao.getIsu();
	}
	public List<CollegeDTO> getCollege(){
		return comdao.getCollege();
	}
	public List<GradeCardDTO> getGradeCard(){
		return comdao.getGradeCard();
	}
	
	public List<ColScheduleDTO> getColSchedule(){
		return comdao.getColSchedule();
	}
}
