package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDAO {
	
	@Autowired
	private SqlSession db;

	public int login(String id, String pw) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("pw",pw);
		return db.selectOne("Info.login", param);
	}

	public String getName(String id, String pw) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("pw",pw);
		return db.selectOne("Info.getName", param);
	}

	public String getMajor(String id, String pw) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("pw",pw);
		return db.selectOne("Info.getMajor", param);
	}

}
