package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.NoticeDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService admService;
	
	// 공지사항 목록 온로드
	@RequestMapping("NoticeOnLoad.nex")
	public NexacroResult noticeOnLoad() throws Exception{
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.getNotice();
		nr.addDataSet("out_notice", list);
		return nr;
	}
	
	// 교수 목록 온로드
	@RequestMapping("ProfessorOnLoad.nex")
	public NexacroResult professorOnLoad() throws Exception {
		NexacroResult nr = new NexacroResult();
		List<ProfessorDTO> list = admService.getProfessor();
		nr.addDataSet("out_pro", list);
		return nr;
	}
	
	// 교수 등록
	@RequestMapping("ProfessorSave.nex")
	public NexacroResult addProfessor(@ParamDataSet(name="in_pro")List<ProfessorDTO_NEX> list) throws Exception {
		admService.addProfessor(list);
		return new NexacroResult();
	}
	
	// 학생 목록 온로드
	@RequestMapping("StudentOnLoad.nex")
	public NexacroResult getStudentOnLoad() throws Exception {
		NexacroResult nr = new NexacroResult();
		List<StudentDTO> list = admService.getStudentOnLoad();
		nr.addDataSet("out_std",list);
		return nr;		
	}
	
	// 학생 등록
	@RequestMapping("StudentSave.nex")
	public NexacroResult addStudent(@ParamDataSet(name="in_std")List<StudentDTO> list) throws Exception {
		admService.addStudent(list);
		return new NexacroResult();
	}
}
