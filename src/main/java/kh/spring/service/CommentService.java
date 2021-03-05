package kh.spring.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CommentDAO;
import kh.spring.dto.CommentsDTO;
import kh.spring.statics.PagingConfigurator;

@Service
public class CommentService {

	@Autowired
	CommentDAO cdao;
	
	// 댓글 보기
	public Map<String, Object> getComments( int seq, int commentsPage ){
		int recordTotalCount = this.commentsCount(seq);
		Map<String, Object> navi = this.getNavigator(recordTotalCount, commentsPage);
		Map<String, Object> param = new HashMap<>();
		param.put("seq", seq);
		param.put("startNumByPage", navi.get("startNumByPage"));
		param.put("endNumByPage", navi.get("endNumByPage"));
		List<CommentsDTO> list =  cdao.getComments(param);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for( CommentsDTO cdto : list ) {
			cdto.setFormatDate(sdf.format(cdto.getReg_date()));
		}
		Map<String, Object> result = new HashMap<>();
		result.put("navi", navi);
		result.put("list", list);
		return result;
	}
	
	// 댓글 개수 가져오기
	private int commentsCount( int seq ) {
		return cdao.getCommentCount(seq);
	}
	
	// 댓글 입력하기
	public int insertComment( int parent_code, String writer, String contents) {
		Map<String, Object> param = new HashMap<>();
		param.put("parent_code", parent_code);
		param.put("writer", writer);
		param.put("contents", contents);
		return cdao.insertComment(param);
	}
	
	// 댓글 삭제
	public int deleteComment( int seq ) {
		return cdao.deleteComment(seq);
	}
	
	// paging
		private Map<String, Object> getNavigator(int recordTotalCount, int currentPage) {
			int totalPageCount = (recordTotalCount / PagingConfigurator.recordCountPerPage);
			if (recordTotalCount % PagingConfigurator.recordCountPerPage > 0) {
				totalPageCount += 1;
			}
			if (currentPage < 1) {
				currentPage = 1;
			} else if (currentPage > totalPageCount) {
				currentPage = totalPageCount;
			}
			int startNavi = (currentPage - 1) / PagingConfigurator.recordCountPerPage * PagingConfigurator.recordCountPerPage + 1;
			int endNavi = startNavi + PagingConfigurator.naviCountPerPage - 1;
			if (endNavi > totalPageCount) {
				endNavi = totalPageCount;
			}
			int startNumByPage = (currentPage - 1) * PagingConfigurator.recordCountPerPage + 1;
			int endNumByPage = startNumByPage + PagingConfigurator.recordCountPerPage - 1;

			boolean needPrev = false;
			boolean needNext = false;
			if (currentPage >= 1 && currentPage < totalPageCount) {
				needNext = true;
			}
			if (currentPage <= totalPageCount && currentPage > 1) {
				needPrev = true;
			}

			Map<String, Object> naviMap = new HashMap<>();
			naviMap.put("recordTotalCount", recordTotalCount);
			naviMap.put("totalPageCount", totalPageCount);
			naviMap.put("startNumByPage", startNumByPage);
			naviMap.put("endNumByPage", endNumByPage);
			naviMap.put("startNavi", startNavi);
			naviMap.put("endNavi", endNavi);
			naviMap.put("currentPage", currentPage);
			naviMap.put("needNext", needNext);
			naviMap.put("needPrev", needPrev);

			return naviMap;
		}
}
