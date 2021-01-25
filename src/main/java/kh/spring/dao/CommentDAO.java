package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CommentsDTO;

@Repository
public class CommentDAO {
	
	@Autowired
	SqlSession session;
	
	// 댓글 개수 가져오기
	public int getCommentCount( int seq ) {
		return session.selectOne("Comments.countAll", seq);
	}
	
	// 댓글 가져오기
	public List<CommentsDTO> getComments( Map temp ){
		return session.selectList("Comments.getComments", temp);
	}
	
	// 댓글 입력
	public int insertComment( Map temp ) {
		return session.insert("Comments.insertComments", temp);
	}
	
	// 댓글 삭제
	public int deleteComment( int seq ) {
		return session.delete("Comments.deleteComments", seq);
	}
}
