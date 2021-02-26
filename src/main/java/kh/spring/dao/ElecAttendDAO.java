package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ElecSelectClassDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.TakingClassDTO;

@Repository
public class ElecAttendDAO {
	
	@Autowired
	private SqlSession db;

	public List<ElecSelectClassDTO> getClassList(String id, String regDate) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("regDate",regDate);
		System.out.println("elecDAO ID : "+ id);
		System.out.println("elecDAO regDate : "+ regDate);
		return db.selectList("Elec.getClassList", param);
	}

	public List<TakingClassDTO> getClassInfo(String id, String regDate, String className) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("regDate",regDate);
		param.put("className",className);
		return db.selectList("Elec.getClassInfo", param);
	}

	public List<ProAttendMngDTO> lecAttList(String id, String lecCode) {
		Map<String, String> param = new HashMap<>();
		param.put("id",id);
		param.put("lecCode",lecCode);
		return db.selectList("Elec.lecAttList", param);
	}

}
