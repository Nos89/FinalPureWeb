package kh.spring.dto;

import java.sql.Date;

public class InfoBoardDTO {
	private int noti_seq;
	private String noti_title;
	private String noti_contents;
	private Date noti_writedate;
	private String category;
	public int getNoti_seq() {
		return noti_seq;
	}
	public void setNoti_seq(int noti_seq) {
		this.noti_seq = noti_seq;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getNoti_contents() {
		return noti_contents;
	}
	public void setNoti_contents(String noti_contents) {
		this.noti_contents = noti_contents;
	}
	public Date getNoti_writedate() {
		return noti_writedate;
	}
	public void setNoti_writedate(Date noti_writedate) {
		this.noti_writedate = noti_writedate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public InfoBoardDTO(int noti_seq, String noti_title, String noti_contents, Date noti_writedate, String category) {
		super();
		this.noti_seq = noti_seq;
		this.noti_title = noti_title;
		this.noti_contents = noti_contents;
		this.noti_writedate = noti_writedate;
		this.category = category;
	}
	public InfoBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
