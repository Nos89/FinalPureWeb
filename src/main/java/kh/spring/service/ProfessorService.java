package kh.spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ProFileDAO;
import kh.spring.dao.ProfessorDAO;
import kh.spring.dto.AttendanceStatusDTO;
import kh.spring.dto.ClassRegistrationDetailDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.GradeDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.ProAttendMngDTO_NEX;
import kh.spring.dto.ProBusinessLog;
import kh.spring.dto.ProBusinessLog_NEX;
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProScheduleDTO;
import kh.spring.dto.ProScheduleDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.utils.ConvertDate;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorDAO pdao;
	
	@Autowired
	private ProFileDAO fdao;
	
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
	
	public ProFileDTO checkImg(String id) {
		return fdao.checkImg(id);
	}
	
	public List<ProListDTO> selectProList(String id){
		return pdao.selectProList(id);
	}

	public DepartmentDTO selectDepartment(String id) {
		return pdao.selectDepartment(id);
	}
	
	public DepartmentOfficeDTO selectDepartmentOffice(String id) {
		return pdao.selectDepartmentOffice(id);
	}
	public List<ProAttendMngDTO> proAttendMngOnload(String id){	
		return pdao.selectProAttendMngOnload(id);
	}
	public List<ProScheduleDTO> proScheduleOnload(String id){
		return pdao.selectProSchedule(id);
	}
	public int delProSchedule(List<ProScheduleDTO_NEX> list) throws Exception {
		List<ProScheduleDTO> plist = new ArrayList<>();
		for(ProScheduleDTO_NEX i : list) {
			ProScheduleDTO dto = new ProScheduleDTO();
			dto.setCheck(i.getCheck());
			dto.setSche_contents(i.getSche_contents());
			dto.setSche_date(ConvertDate.stringToDate(i.getSche_date()));
			dto.setSche_proId(i.getSche_proId());
			dto.setSche_proName(i.getSche_proName());
			dto.setSche_seq(i.getSche_seq());
			dto.setSche_title(i.getSche_title());
			dto.setSche_type(i.getSche_type());
			plist.add(dto);
		}
		return pdao.delProSchedule(plist);
	}
	public int updateProSchedule(ProScheduleDTO_NEX dto, String id) throws Exception {
		ProScheduleDTO sDto = new ProScheduleDTO(dto.getSche_seq(),dto.getSche_proId(),dto.getSche_proName(),dto.getSche_contents(),
				ConvertDate.stringToDate(dto.getSche_date()),dto.getSche_title(),dto.getSche_type(),dto.getCheck());
		int result = 0;
		if(id.contentEquals("insert")) {
			result = pdao.insertProSchedule(sDto);
		}else if(id.contentEquals("update")) {
			result = pdao.updateProSchedule(sDto);
		}
		return result;
	}
	
	public List<ProAttendMngDTO_NEX>selectAttendMng(String id){
		List<ProAttendMngDTO> list = pdao.selectProAttendMngOnload(id);
		List<ProAttendMngDTO_NEX> nList = new ArrayList<>();
		for(ProAttendMngDTO i : list) {
			ProAttendMngDTO_NEX dto;
			if(i.getAtt_date()==null) {
				dto = new ProAttendMngDTO_NEX(i.getAtt_seq(), i.getAtt_lecCode(), i.getAtt_year(), i.getAtt_targetLevel(),
						i.getAtt_semester(), i.getAtt_lecTitle(), null,null,i.getAtt_stdId(),
						i.getAtt_deptName(),i.getAtt_stdName(), i.getAtt_stdLevel(),i.getAtt_week());
				
			}else {
			
				dto = new ProAttendMngDTO_NEX(i.getAtt_seq(), i.getAtt_lecCode(), i.getAtt_year(), i.getAtt_targetLevel(),
					i.getAtt_semester(), i.getAtt_lecTitle(), ConvertDate.dateToString(i.getAtt_date()),i.getAtt_attend(),i.getAtt_stdId(),
					i.getAtt_deptName(),i.getAtt_stdName(), i.getAtt_stdLevel(),i.getAtt_week());
			}
			nList.add(dto);
		}
		return nList;
	}
	
	public List<ClassRegistrationDetailDTO> selectCRDetail(String id){
		return pdao.selectCRDetail(id);
		
	}
	
	public int insertAttend(ProAttendMngDTO_NEX dto) {
		ProAttendMngDTO ndto = new ProAttendMngDTO(dto.getAtt_seq(), dto.getAtt_lecCode(),dto.getAtt_year().substring(0, 7), dto.getAtt_targetLevel(),
				dto.getAtt_semester(), dto.getAtt_lecTitle(),null, dto.getAtt_attend(), dto.getAtt_stdId(),
				dto.getAtt_deptName(), dto.getAtt_stdName(), dto.getAtt_stdLevel(), dto.getAtt_week());
		return pdao.insertAttend(ndto);
		
	}
	
	public int saveAttend(List<ProAttendMngDTO_NEX> list) throws Exception {
		List<ProAttendMngDTO> nList = new ArrayList<>();
		for(ProAttendMngDTO_NEX i : list) {
			ProAttendMngDTO dto = new ProAttendMngDTO(i.getAtt_seq(), i.getAtt_lecCode(), i.getAtt_year(), i.getAtt_targetLevel(),
					i.getAtt_semester(),i.getAtt_lecTitle(), ConvertDate.stringToDate(i.getAtt_date()), i.getAtt_attend(), i.getAtt_stdId(),
					i.getAtt_deptName(), i.getAtt_stdName(), i.getAtt_stdLevel(), i.getAtt_week());
			nList.add(dto);
			}
		
		return pdao.saveAttend(nList);
		}
		
	public List<AttendanceStatusDTO> attendCheckAll(String code){
		return pdao.attendCheckAll(code);
		
	}
	
	public List<GradeDTO>selectGrade(String id){
		return pdao.selectGrade(id);
	}
	
	public int addGrade(GradeDTO dto) {
		return pdao.addGrade(dto);
	}
	public int deleteGrade(GradeDTO dto) {
		return pdao.deleteGrade(dto);
	}
	public int updateGrade(List<GradeDTO> list) {
		if(list.size()==0) {
			
			return 1;
		}
		
		return pdao.updateGrade(list);
	}
	public List<ProBusinessLog> getMyDiary(String id){
		return pdao.getMyDiary(id);
	}
	public int updateDiary(ProBusinessLog_NEX dto, String id) throws Exception {
		ProBusinessLog sDto = new ProBusinessLog(dto.getCheck(), dto.getBusi_seq(), dto.getBusi_proId(),
				dto.getBusi_proName(), dto.getBusi_contents(),ConvertDate.stringToDate(dto.getBusi_date()));
		int result = 0;
		if(id.contentEquals("insert")) {
			result = pdao.insertDiary(sDto);
		}else if(id.contentEquals("update")) {
			result = pdao.updateDiary(sDto);
		}
		return result;
		
	}
	public int delProDiary(List<ProBusinessLog_NEX> list) throws Exception {
		List<ProBusinessLog> plist = new ArrayList<>();
		for(ProBusinessLog_NEX i : list) {
			ProBusinessLog dto = new ProBusinessLog();
			dto.setCheck(i.getCheck());
			dto.setBusi_seq(i.getBusi_seq());
			dto.setBusi_proId(i.getBusi_proId());
			dto.setBusi_proName(i.getBusi_proName());
			dto.setBusi_contents(i.getBusi_contents());
			dto.setBusi_date(ConvertDate.stringToDate(i.getBusi_date()));
			plist.add(dto);
		}
		return pdao.deleteDiary(plist);
		
	}
	
}
