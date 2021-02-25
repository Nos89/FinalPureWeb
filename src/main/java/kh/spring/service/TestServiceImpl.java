package kh.spring.service;

import java.util.List; 
import java.util.Map; 
import org.mybatis.spring.SqlSessionTemplate; 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Repository;

import com.nexacro.uiadapter17.spring.core.data.DataSetRowTypeAccessor; 

import com.nexacro17.xapi.data.DataSet;

import kh.spring.dto.StudentDTO; 


/** 
 * Test를 위한 ServiceImpl Sample Class 
 * 
 * @author Park SeongMin 
 * @since 08.12.2015 
 * @version 1.0 
 * @see 
 */ 

@Repository 
public class TestServiceImpl implements TestService {

	@Override
	public List<StudentDTO> selectDataListVO(StudentDTO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectDataListMap(Map<String, String> search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDataListVO(List<StudentDTO> dataList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDataListMap(List<Map<String, Object>> dataList) {
		// TODO Auto-generated method stub
		
	}
//
//
//	@Autowired 
//	private SqlSessionTemplate sqlSession; 
//
//	@Override 
//	public List<StudentDTO> selectDataListVO(StudentDTO searchVO) { 
//		UiadapterSampleMapper mapper = sqlSession.getMapper(UiadapterSampleMapper.class); 
//		return mapper.selectDataListVO(searchVO); 
//	} 
//
//	@Override 
//	public List<Map<String,Object>> selectDataListMap(Map<String,String> search) { 
//		UiadapterSampleMapper mapper = sqlSession.getMapper(UiadapterSampleMapper.class); 
//		return mapper.selectDataListMap(search); 
//	} 
//
//	@Override 
//	public void updateDataListVO(List<StudentDTO> dataList) { 
//		//UiadapterSampleMapper mapper = sqlSession.getMapper(UiadapterSampleMapper.class); 
//
//		int size = dataList.size(); 
//		for (int i=0; i<size; i++) { 
//			StudentDTO dto = dataList.get(i); 
//			if (dto instanceof DataSetRowTypeAccessor){ 
//				DataSetRowTypeAccessor accessor = (DataSetRowTypeAccessor) dto; 
//
//				if (accessor.getRowType() == DataSet.ROW_TYPE_INSERTED){ 
//					//mapper.insertSampleVO(dto); 
//				}else if (accessor.getRowType() == DataSet.ROW_TYPE_UPDATED){ 
//					//mapper.updateSampleVO(dto); 
//				}else if (accessor.getRowType() == DataSet.ROW_TYPE_DELETED){ 
//					//mapper.deleteSampleVO(dto); 
//				}
//			}
//		}
//
//
//		@Override 
//		public void updateDataListMap(List<Map<String,Object>> dataList) { 
//			//UiadapterSampleMapper mapper = sqlSession.getMapper(UiadapterSampleMapper.class); 
//			int size = dataList.size(); 
//			for (int i=0; i<size; i++) { 
//				Map<String,Object> sample = dataList.get(i); 
//
//				int rowType = Integer.parseInt(String.valueOf(sample.get(DataSetRowTypeAccessor.NAME))); 
//				if (rowType == DataSet.ROW_TYPE_INSERTED){ 
//					mapper.insertSampleMap(sample); 
//				}else if (rowType == DataSet.ROW_TYPE_UPDATED){ 
//					mapper.updateSampleMap(sample); 
//				}else if (rowType == DataSet.ROW_TYPE_DELETED){ 
//					mapper.deleteSampleMap(sample); 
//				} 
//			} 
//		} 
//	}
}
