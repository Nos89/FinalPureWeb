package kh.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ElecAttendDAO;
import kh.spring.dto.ElecSelectClassDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.TakingClassDTO;


@Service
public class ElecAttendService {

	@Autowired
	ElecAttendDAO edao;

	public List<ElecSelectClassDTO> getClassList(String id, Date date_registration) {
		return edao.getClassList(id,date_registration);
	}

	public List<TakingClassDTO> getClassInfo(String id, Date date_registration, String className) {
		return edao.getClassInfo(id,date_registration,className);
	}


	public List<ProAttendMngDTO> lecAttList(String id, String lecCode) {
		return edao.lecAttList(id,lecCode);
	}
}
