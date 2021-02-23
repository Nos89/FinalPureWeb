package kh.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.statics.PagingConfigurator;

@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;

	// 게시글 작성
	public int writeArticle(BoardDTO bdto) {
		int result = bdao.writeArticle(bdto);
		return result;
	}

	// 게시글 작성 넥사크로
	public int writeArticle_NEX(BoardDTO_NEX bdto) {
		BoardDTO dto = new BoardDTO(0, 0, 0, bdto.getTitle(), bdto.getContents(), bdto.getWriter(), null, bdto.getBoardType());
		int result = bdao.writeArticle(convertType(dto));
		return result;
	}

	// 파일 업로드 로직
	public void uploadFile(Map<String, Object> map) {
		bdao.insertFile(map);
	}

	// 전체 게시글 수
	private int getArticleCount(String type, String category) {
		Map<String, String> temp = new HashMap<>();
		temp.put("type", type);
		if( type.contentEquals("notice") ) {
			temp.put("category", category);
		}
		return bdao.getArticleCount(temp);
	}

	private int getSearchCount(String type, String searchType, String[] searchText) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		return bdao.getSearchCount(map);
	}

	// 페이징 적용된 게시글
	public Map<String, Object> getArticles(String type, String category, int currentPage) {
		int recordTotalCount = this.getArticleCount(type, category);
		
		Map<String, Object> navi = this.getNavigator(recordTotalCount, currentPage);
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("startNumByPage", navi.get("startNumByPage"));
		map.put("endNumByPage", navi.get("endNumByPage"));
		
		Map<String, Object> temp = new HashMap<>();
		temp.put("navi", navi);
		if( type.contentEquals("notice") ) {
			map.put("category", category);
			List<NoticeDTO> list = bdao.getNoticesByPage(map);
			List<BoardDTO> clist = new ArrayList<>();
			for( NoticeDTO n : list ) {
				clist.add(this.convertNoti(n));
			}
			temp.put("list", clist);
		} else {
			List<BoardDTO> list = bdao.getArticleByPage(map);
			System.out.println(list.size());
			temp.put("list", list);
		}
		return temp;
	}
	
	// 게시글 보기
	public BoardDTO viewArticle(String type, int seq) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("seq", seq);
		
		if( type.contentEquals("notice") ) {
			return this.convertNoti(bdao.getNotice(map));
		} else {
			return bdao.getArticle(map);
		}
	}

	// 게시글 첨부파일
	public List<FilesDTO> getFiles(int parent_code) {
		return bdao.getFiles(parent_code);
	}

	// 게시글 첨부파일 삭제
	public int delSpecFile(int seq) {
		return bdao.delSpecFile(seq);
	}

	// 특정 첨부파일 가져오기
	public List<FilesDTO> getSpecFile(List<Integer> seq) {
		return bdao.getSpecFile(seq);
	}

	// 게시물 수정
	public int modifyArticle(BoardDTO bdto, String type) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("bdto", bdto);
		return bdao.modifyArticle(map);
	}

	// 게시글 삭제
	public int deleteArticle(String type, int seq) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		map.put("seq", seq);
		return bdao.deleteArticle(map);
	}

	// 게시판 검색
	public Map<String, Object> boardSearch(String type, String search, int page) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardType", type);
		String searchType = search.split("-")[0];
		String[] searchText = (search.split("-")[1]).split(" ");
		map.put("searchType", searchType);
		map.put("searchText", searchText);
		Map<String, Object> navi = this.getNavigator(this.getSearchCount(type, searchType, searchText), page);
		System.out.println(navi.get("startNumByPage") + " : " + navi.get("endNumByPage"));
		map.put("startNumByPage", navi.get("startNumByPage"));
		map.put("endNumByPage", navi.get("endNumByPage"));

		List<BoardDTO> list = bdao.boardSearch(map);

		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("navi", navi);
		return result;
	}

	// 게시판 타입 변경

	private BoardDTO convertType(BoardDTO bdto) {
		if (bdto.getBoardType().contentEquals("notice")) {
			bdto.setBoardType("board_notice");
		} else {
			// bdto.setBoardType(bdto.getBoardType().substring(0, bdto.getBoardType().indexOf("Board")));
		}
		return bdto;
	}

	private String convertType(String type) {
		if (type.contentEquals("notice")) {
			type = "board_notice";
		} else { // type = type.substring(0, type.indexOf("Board"));
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

	// NoticeDTO -> BoardDTO
	private BoardDTO convertNoti( NoticeDTO ndto ) {
		BoardDTO bdto = new BoardDTO();
		bdto.setSeq(ndto.getNoti_seq());
		bdto.setTitle(ndto.getNoti_title());
		bdto.setContents(ndto.getNoti_contents());
		bdto.setWriteDate(ndto.getNoti_writeDate());
		bdto.setWriter("관리자");
		bdto.setCategory(ndto.getCategory());
		return bdto;
	}
	
	
	// 메인 홈페이지 홍보 게시글 10개
	public List<BoardDTO> getPromote() {
		return bdao.getPromote();
	}

	// 메인 홈페이지 공지 게시글 10개
	public List<NoticeDTO> getNotice(String noticeType) {
		return bdao.getNotice(noticeType);
	}

}
