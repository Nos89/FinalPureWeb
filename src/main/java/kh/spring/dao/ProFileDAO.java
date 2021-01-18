package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ProFileDTO;

@Repository
public class ProFileDAO {

	
	@Autowired
	private SqlSession db;
	
	
	public ProFileDTO checkImg(String id) {
		return db.selectOne("ProFile.checkImg", id);
	}
	
	public int updateImg(ProFileDTO dto) {
		return db.update("ProFile.updateImg",dto);
	}
	public int uploadImg(ProFileDTO dto) {
		return db.insert("ProFile.insertImg", dto);
	}
	
}
