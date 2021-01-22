package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	// 게시물 쓰기
	public int writeArticle(BoardDTO bdto ) {
		return session.insert("Board.insert", bdto);
	}
	
	// 전체 게시물 수
	public int getArticleCount(String type) {
		return session.selectOne("Board.articleCount", type);
	}
	
	// 네비 페이지당 게시물
	public List<BoardDTO> getArticleByPage( Map map ){
		return session.selectList("Board.getArticles", map);
	}
	
	// 게시물 보기
	public BoardDTO getArticle( Map map ) {
		return session.selectOne("Board.getArticle", map);
	}
	
	// 게시물 수정
	public int modifyArticle( Map map ) {
		return session.update("Board.modifyArticle", map);
	}
	
	// 게시글 삭제
	public int deleteArticle( Map map ) {
		return session.delete("Board.deleteArticle", map);
	}
}
