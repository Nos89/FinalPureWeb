package kh.spring.dao;

import java.util.Date;
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

	public List<ElecSelectClassDTO> getClassList(String id, Date date_registration) {
		Map<String, Object> param = new HashMap<>();
		param.put("id",id);
		param.put("regDate",date_registration);
		return db.selectList("Elec.getClassList", param);
	}

	public List<TakingClassDTO> getClassInfo(String id, Date date_registration, String className) {
		Map<String, Object> param = new HashMap<>();
		param.put("id",id);
		param.put("regDate",date_registration);
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
