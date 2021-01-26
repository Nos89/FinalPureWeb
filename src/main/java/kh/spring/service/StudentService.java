package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.StudentDAO;
import kh.spring.dto.MajorApplyDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO sdao;
	
	public List<StudentInfoDTO> selectAllInfo(String id){		
		return sdao.selectStuInfo(id);
	}
	
	public List<MilitaryDTO> selectArmy(String id){
		return sdao.selectArmy(id);		
	}
	
	public List<StudentDetailDTO> selectStuDetail(String id){
		return sdao.selectStuDetail(id);		
	}
	
	public int updateStuInfo(StudentInfoDTO dto) {
		return sdao.updateStuInfo(dto);
	}
	
	public List<MajorApplyDTO> majorApply(MajorApplyDTO dto){
		return sdao.majorApply(dto);
	}
}
