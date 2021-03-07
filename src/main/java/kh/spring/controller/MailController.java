package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.MailDTO;
import kh.spring.dto.MailDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.service.AdminService;
import kh.spring.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	MailService mailService;
	@Autowired
	AdminService admService;
	@Autowired
	HttpSession session;
	
	// 메일 작성
	@RequestMapping("sendMail.nex")
	public NexacroResult sendMail(@ParamDataSet(name="in_mail")MailDTO dto) {
		mailService.sendMail(dto);
		return new NexacroResult();
	}
	
	// 수신인 목록 가져오기
	@RequestMapping("getReceiverList.nex")
	public NexacroResult getReceiverList() {
		NexacroResult nr = new NexacroResult();
		List<StudentDTO> list = mailService.getReceiverList();
		List<CollegeDTO> list2 = admService.getCollege();
		List<DepartmentDTO> list3 = admService.getDepartment();
		nr.addDataSet("out_users",list);
		nr.addDataSet("out_college",list2);
		nr.addDataSet("out_department",list3);
		return nr;
	}
	
	// 발신메일 목록
	@RequestMapping("getOutBox.nex")
	public NexacroResult getOutBox() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		List<MailDTO> list = mailService.getOutBox(id);
		List<StudentDTO> list2 = mailService.getMailName();
		nr.addDataSet("out_mail",list);
		nr.addDataSet("out_name",list2);
		nr.addVariable("fv_loginID",id);
		return nr;
	}
	
	// 수신메일 목록
	@RequestMapping("getInBox.nex")
	public NexacroResult getMailBox() {
		String id = (String)session.getAttribute("loginID");
		NexacroResult nr = new NexacroResult();
		List<MailDTO> list = mailService.getInBox(id);
		List<StudentDTO> list2 = mailService.getMailName();
		nr.addDataSet("out_mail",list);
		nr.addDataSet("out_name",list2);
		return nr;
	}
	
	// 읽음 표시
	@RequestMapping("updateReadStatus.nex")
	public NexacroResult updateReadStatus(@ParamDataSet(name="in_mail")MailDTO_NEX dto) throws Exception {
		mailService.updateReadStatus(dto);
		return new NexacroResult();
	}
}
