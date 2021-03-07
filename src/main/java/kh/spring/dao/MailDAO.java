package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MailDTO;
import kh.spring.dto.StudentDTO;

@Repository
public class MailDAO {
	
	@Autowired
	private SqlSession db;
	
	// 메일 작성
	public int sendMail(MailDTO dto) {
		return db.insert("Mail.sendMail",dto);
	}
	
	// 수신인 목록
	public List<StudentDTO> getReceiverList(){
		return db.selectList("Mail.getReceiverList");
	}
	
	// 수신인 이름
	public List<StudentDTO> getMailName(){
		return db.selectList("Mail.getMailName");
	}
	
	// 발신메일함 목록
	public List<MailDTO> getOutBox(String id){
		return db.selectList("Mail.getOutBox",id);
	}
	
	// 수신메일함 목록
	public List<MailDTO> getInBox(String id){
		return db.selectList("Mail.getInBox",id);
	}
	
	// 읽음 표시
	public int updateReadStatus(MailDTO dto) {
		return db.update("Mail.updateReadStatus", dto);
	}
}
