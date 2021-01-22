package kh.spring.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.statics.PagingConfigurator;

@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;
	
	// 게시글 작성
	public int writeArticle(BoardDTO bdto) {
		return bdao.writeArticle(convertType(bdto));
	}
	
	// 전체 게시글 수
	private int getArticleCount( String type ) {
		return bdao.getArticleCount(type);
	}
	
	// 페이징 적용된 게시글
	public Map<String, Object> getArticles( String type, int currentPage ){
		type = this.convertType(type);
		Map<String, Object> temp = new HashMap<>();
		int recordTotalCount = this.getArticleCount(type);
		Map<String, Object> navi = this.getNavigator(recordTotalCount, currentPage);
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("startNumByPage", navi.get("startNumByPage"));
		map.put("endNumByPage", navi.get("endNumByPage"));
		List<BoardDTO> list = bdao.getArticleByPage(map);
		temp.put("navi", navi);
		temp.put("list", list);
		return temp;
	}
	
	// 게시글 보기
	public BoardDTO viewArticle( String type, int seq ) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", this.convertType(type));
		map.put("seq", seq);
		return bdao.getArticle(map);
	}
	
	// 게시물 수정
	public int modifyArticle( BoardDTO bdto, String type ) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", this.convertType(type));
		map.put("bdto", bdto);
		return bdao.modifyArticle(map);
	}
	
	// 게시글 삭제
	public int deleteArticle( String type, int seq ) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", this.convertType(type));
		map.put("seq", seq);
		return bdao.deleteArticle(map);
	}
	
	// 게시판 타입 변경
	private BoardDTO convertType( BoardDTO bdto ) {
		if( bdto.getBoardType().contentEquals("notice") ) {
			bdto.setBoardType("board_notice");
		} else {
			bdto.setBoardType(bdto.getBoardType().substring(0, bdto.getBoardType().indexOf("Board")));
			System.out.println(bdto.getBoardType());
		}
		return bdto;
	}
	
	private String convertType( String type ) {
		if( type.contentEquals("notice") ) {
			type = "board_notice";
		} else {
			System.out.println(type);
			type = type.substring(0, type.indexOf("Board"));
			System.out.println(type);
		}
		return type;
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
