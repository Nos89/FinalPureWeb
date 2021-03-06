package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.ClassRegistrationDAO;
import kh.spring.dao.LectureDAO;
import kh.spring.dto.ClassRegistrationDTO;
import kh.spring.dto.OpenClass_LecPlan;
import kh.spring.dto.ShoppingBasketDTO;

@Service
public class ClassRegistrationService {
		@Autowired
		private LectureDAO ldao;
		
		@Autowired
		private ClassRegistrationDAO crdao;
	
		public List<OpenClass_LecPlan> selectAllOpenClass(){
			return ldao.selectAllOpenClass();
		}
		public List<ClassRegistrationDTO> selectCRList(String id){
			return crdao.selectCRList(id);
			
		}
		public int addClass(ClassRegistrationDTO dto) {
			return crdao.addClass(dto);
		}
		public int partPlus(ClassRegistrationDTO dto) {
			return ldao.partPlus(dto);
		}
		public int deleteCRList(ClassRegistrationDTO dto) {
			return crdao.deleteCRList(dto);
		}
		public int partMinus(ClassRegistrationDTO dto) {
			return ldao.partMinus(dto);
		}
		public List<ShoppingBasketDTO> selectBasketList(String id){
			return crdao.selectBasketList(id);
		}
		@Transactional
		public int insertBasketToCrList(List<ClassRegistrationDTO> list) {
			int result = 0;
			for(int i=0; i<list.size(); i++) {
				int check = ldao.partPlus(list.get(i));
				if(check >=1) {
					crdao.addClass(list.get(i));
					result++;
				}
				
			}
			return result;
		}
		public int deleteBasket(ShoppingBasketDTO dto) {
			return crdao.deleteBasketList(dto);
		}
		public int addClassBasket(ShoppingBasketDTO dto) {
			return crdao.addClassBasket(dto);
		
		}
}
