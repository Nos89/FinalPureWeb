package kh.spring.dto;

import java.sql.Date;

public class BoardDTO {
	private int chk=0;
	private int rank;
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private Date writeDate;
	private String boardType;
	private String category;
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int seq, String title, String contents, String writer, Date writeDate, String boardType, String category) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
		this.boardType = boardType;
		this.category = category;
	}
	public BoardDTO(int chk, int rank, int seq, String title, String contents, String writer, Date writeDate, String boardType) {
		super();
		this.chk = chk;
		this.rank = rank;
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
		this.boardType = boardType;
	}
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
