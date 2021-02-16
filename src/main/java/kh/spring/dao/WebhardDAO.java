package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CloudDTO;
import kh.spring.dto.DirectoryDTO;

@Repository
public class WebhardDAO {

	@Autowired
	SqlSession session;

	// Directory List
	public List<DirectoryDTO> getList(String userID) {
		return session.selectList("Webhard.directories", userID);
	}

	// 폴더 생성
	public int createFolder(Map<String, Object> map) {
		return session.insert("Webhard.createFolder", map);
	}

	// 파일 정보 저장
	public int saveFile(Map<String, Object> map) {
		return session.insert("Webhard.saveFile", map);
	}

	// 폴더 파일 가져오기
	public List<CloudDTO> getFiles(Map<String, Object> map){
		return session.selectList("Webhard.getFiles", map);
	}
	
	// 하위 폴더 가져오기
	public List<DirectoryDTO> getFolder(Map<String, Object> map){
		return session.selectList("Webhard.getFolder", map);
	}
	
	// 파일 삭제
	public int delFile(Map<String, Object> map ) {
		return session.delete("Webhard.delFile", map);
	}
}
