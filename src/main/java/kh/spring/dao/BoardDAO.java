package kh.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;

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
	public int insertFile(Map<String, Object> map) {
		return session.insert("Board.insertFile", map);
	}

	//파일 첨부 넥사크로
	public int insertFile(FilesDTO dto) {
		return session.insert("Board.insertFile",dto);
	}
	// 전체 게시물 수
	public int getArticleCount(String type) {
		return session.selectOne("Board.articleCount", type);
	}

	public int getArticleCount(Map map) {
		return session.selectOne("Board.articleSearchCount", map);
	}

	// 네비 페이지당 게시물
	public List<BoardDTO> getArticleByPage(Map map) {
		return session.selectList("Board.getArticles", map);
	}

	// 게시물 보기
	public BoardDTO getArticle(Map map) {
		return session.selectOne("Board.getArticle", map);
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
	public int modifyArticle(Map map) {
		return session.update("Board.modifyArticle", map);
	}

	// 게시글 삭제
	public int deleteArticle(Map map) {
		return session.delete("Board.deleteArticle", map);
	}

	// 게시글 검색
	public List<BoardDTO> boardSearch(Map map) {
		return session.selectList("Board.boardSearch", map);
	}
}
