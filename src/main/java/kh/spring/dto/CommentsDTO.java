package kh.spring.dto;

import java.sql.Date;

public class CommentsDTO {
	private int seq;
	private int parent_code;
	private String writer;
	private String contents;
	private Date reg_date;
	public CommentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentsDTO(int seq, int parent_code, String writer, String contents, Date reg_date) {
		super();
		this.seq = seq;
		this.parent_code = parent_code;
		this.writer = writer;
		this.contents = contents;
		this.reg_date = reg_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getParent_code() {
		return parent_code;
	}
	public void setParent_code(int parent_code) {
		this.parent_code = parent_code;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}
