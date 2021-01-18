package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.InfoDAO;
import kh.spring.utils.EncryptUtils;

@Service
public class InfoService {
	
	@Autowired
	private InfoDAO idao;

	public int login(String id, String pw) throws Exception {
		return idao.login(id,pw);
	}

	public String getName(String id, String pw) {
		return idao.getName(id,pw);
	}

	public String getMajor(String id, String pw) {
		return idao.getMajor(id,pw);
	}

}
