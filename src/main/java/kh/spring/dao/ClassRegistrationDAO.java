package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ClassRegistrationDTO;
import kh.spring.dto.ShoppingBasketDTO;

@Repository
public class ClassRegistrationDAO {
	@Autowired
	private SqlSession db;
	
	public List<ClassRegistrationDTO> selectCRList(String id){
		return db.selectList("CR.selectMyList", id);
	}

	public int addClass(ClassRegistrationDTO dto) {
		return db.insert("CR.addClass",dto);
	}
	public int deleteCRList(ClassRegistrationDTO dto) {
		return db.delete("CR.deleteCRList", dto);
	}
	public List<ShoppingBasketDTO> selectBasketList(String id){
		return db.selectList("CR.selectMyBasket", id);
		
	}
	public int deleteBasketList(ShoppingBasketDTO dto) {
		return db.delete("CR.deleteBasketList",dto);
	}
	public int addClassBasket(ShoppingBasketDTO dto) {
		return db.insert("CR.addClassBasket", dto);
	}
}
