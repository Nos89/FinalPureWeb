package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MailDAO;
import kh.spring.dto.MailDTO;
import kh.spring.dto.MailDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.utils.ConvertDate;

@Service
public class MailService {

	@Autowired
	MailDAO maildao;
	
	// 메일 작성
	public int sendMail(MailDTO dto) {
		return maildao.sendMail(dto);
	}
	
	// 수신인 목록
	public List<StudentDTO> getReceiverList(){
		return maildao.getReceiverList();
	}
	
	// 수신인 이름
	public List<StudentDTO> getReceiverName(){
		return maildao.getReceiverName();
	}
	
	// 발신메일함
	public List<MailDTO> getOutBox(){
		return maildao.getOutBox();
	}
	
	// 수신메일함
	public List<MailDTO> getInBox(String id) {
		return maildao.getInBox(id);
	}
	
	// 읽음 표시
	public int updateReadStatus(MailDTO_NEX dto) throws Exception {
		MailDTO dto2 = new MailDTO(dto.getMail_seq(),dto.getReceiver(),dto.getTitle(),dto.getContents(),
									ConvertDate.stringToDate(dto.getReceived_date()),dto.getRead());
		return maildao.updateReadStatus(dto2);
	}
}
