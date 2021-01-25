package kh.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.utils.ConvertDate;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO admdao;
	private ConvertDate con;
	
	
	// 공지사항 가져오기
	public List<NoticeDTO> getNotice() throws Exception {
		return admdao.getNotice();
	}
	
	// 교수 목록 가져오기
	public List<ProfessorDTO> getProfessor() throws Exception {
		return admdao.getProfessor();
	}
	
	// 교수 명단 등록
	public int addProfessor(List<ProfessorDTO_NEX> list) throws Exception {
		List<ProfessorDTO> list2 = new ArrayList<>();
		ProfessorDTO dto = new ProfessorDTO();
		for(int i=0; i<list.size(); i++) {
			dto.setId(list.get(i).getId());
			dto.setPw(list.get(i).getPw());
			dto.setName(list.get(i).getName());
			dto.setBirth(con.utilToSql(list.get(i).getBirth()));
			dto.setGender(list.get(i).getGender());
			dto.setCountry(list.get(i).getCountry());
			dto.setInDate(con.utilToSql(list.get(i).getInDate()));
			dto.setOutDate(con.utilToSql(list.get(i).getOutDate()));
			dto.setColcode(list.get(i).getColcode());
			dto.setDeptcode(list.get(i).getDeptcode());
			dto.setCol_title(list.get(i).getCol_title());
			dto.setDept_title(list.get(i).getDept_title());
			dto.setZipcode(list.get(i).getZipcode());
			dto.setAddr1(list.get(i).getAddr1());
			dto.setAddr2(list.get(i).getAddr2());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setBank(list.get(i).getBank());
			dto.setAccountnum(list.get(i).getAccountnum());
			dto.setPro_office(list.get(i).getPro_office());
			dto.setPro_status(list.get(i).getPro_status());
			list2.add(dto);
		}
		return admdao.addProfessor(list2);
	}
	
	// 학생 목록 가져오기
	public List<StudentDTO> getStudentOnLoad() throws Exception {
		return admdao.getStudentOnLoad();
	}
	
	// 학생 명단 등록
	public int addStudent(List<StudentDTO> list) throws Exception {
		return admdao.addStudent(list);
	}
}
