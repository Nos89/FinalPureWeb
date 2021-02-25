package kh.spring.service;
import java.util.List; 
import java.util.Map;

import kh.spring.dto.StudentDTO; 

/** 
 * <pre> 
 * @title    
 * @desc    아래의 예제는 샘플용으로 작성된 코드로 참고용으로만 
 *          사용하시기 바랍니다. 
 * -         
 * @package com.nexacro.uiadapter17_spring_sample.service 
 * <pre> 
 *  
 * @author  TOBESOFT 
 * @since   2017. 11. 20. 
 * @version 1.0 
 * @see 
 * =================== 변경 내역 ================== 
 * 날짜 변경자 내용 
 * ------------------------------------------------ 
 * 2017. 11. 20. TOBESOFT 최초작성 
 */ 

	public interface TestService { 

		List<StudentDTO>           selectDataListVO(StudentDTO searchVO); 
		List<Map<String,Object>> selectDataListMap(Map<String,String> search); 
		void updateDataListVO(List<StudentDTO> dataList); 
		void updateDataListMap(List<Map<String,Object>> dataList); 
	}