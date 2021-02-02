package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ClassRegistrationDAO;
import kh.spring.dao.LectureDAO;
import kh.spring.dto.ClassRegistrationDTO;
import kh.spring.dto.OpenClass_LecPlan;

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
}
