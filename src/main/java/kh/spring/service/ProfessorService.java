package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ProfessorDAO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.utils.ConvertDate;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorDAO pdao;
	
	private ConvertDate con;
	
	
	public List<ProfessorDTO> selectInfo(String id){		
		return pdao.selectProInfo(id);
	}
	
	public List<MilitaryDTO> selectMil(String id){
		return pdao.selectMil(id);		
	}
	
	public int updateProInfo(ProfessorDTO_NEX dto) {
		ProfessorDTO pdto = new ProfessorDTO(dto.getId(),dto.getPw(),dto.getName(),con.utilToSql(dto.getBirth()),
				dto.getGender(),dto.getCountry(),con.utilToSql(dto.getInDate()),con.utilToSql(dto.getOutDate()),
				dto.getCol_title(),dto.getDept_title(),dto.getZipcode(),dto.getAddr1(),dto.getAddr2(),dto.getEmail(),
				dto.getPhone(),dto.getBank(),dto.getAccountnum());
		return pdao.updateProInfo(pdto);
	}
	

}
