package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.NoticeDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession session;

	// 게시물 쓰기
	public int writeArticle(BoardDTO bdto) {
		session.insert("Board.insert", bdto);
		return bdto.getSeq();
	}

	// 파일 첨부
	public int insertFile(Map<String, Object> param) {
		return session.insert("Board.insertFile", param);
	}

	//파일 첨부 넥사크로
	public int insertFile(FilesDTO dto) {
		return session.insert("Board.insertFile",dto);
	}
	
	// 전체 게시물 수
	public int getArticleCount(Map<String, String> temp) {
		return session.selectOne("Board.articleCount", temp);
	}

	public int getSearchCount(Map param) {
		return session.selectOne("Board.articleSearchCount", param);
	}

	// 네비 페이지당 게시물
	public List<BoardDTO> getArticleByPage(Map param) {
		return session.selectList("Board.getArticles", param);
	}
	
	public List<NoticeDTO> getNoticesByPage(Map param){
		return session.selectList("Board.getNotices", param);
	}

	// 게시물 보기
	public BoardDTO getArticle(Map param) {
		return session.selectOne("Board.getArticle", param);
	}
	
	public NoticeDTO getNotice(Map param) {
		return session.selectOne("Board.getNotice", param);
	}

	// 게시물 첨부파일
	public List<FilesDTO> getFiles(int parent_code) {
		return session.selectList("Board.getFiles", parent_code);
	}

	// 게시글 첨부파일 삭제
	public int delSpecFile(int seq) {
		return session.delete("Board.delSpecFile", seq);
	}

	// 특정 첨부파일 가져오기
	public List<FilesDTO> getSpecFile(List<Integer> seq) {
		return session.selectList("Board.getSpecFile", seq);
	}

	// 게시물 수정
	public int modifyArticle(Map param) {
		return session.update("Board.modifyArticle", param);
	}

	// 게시글 삭제
	public int deleteArticle(Map param) {
		return session.delete("Board.deleteArticle", param);
	}

	// 게시글 검색
	public List<BoardDTO> boardSearch(Map param) {
		return session.selectList("Board.boardSearch", param);
	}
	
	public List<NoticeDTO> noticeSearch(Map param){
		return session.selectList("Board.noticeSearch", param);
	}
	
	// 메인 홈페이지 홍보 게시글 10개
	public List<BoardDTO> getPromote(){
		return session.selectList("Board.mainPromote");
	}
	
	// 메인 홈페이지 공지 게시글 10개
	public List<NoticeDTO> getNotice(String noticeType){
		return session.selectList("Board.mainNotice", noticeType);
	}
	
}
