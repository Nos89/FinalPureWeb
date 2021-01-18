package kh.spring.dto;

import java.sql.Date;

public class ProFileDTO {
	private int seq;
	private String id;
	private String oriName;
	private String savedName;
	private Date reg_date;
	public ProFileDTO(int seq, String id, String oriName, String savedName, Date reg_date) {
		super();
		this.seq = seq;
		this.id = id;
		this.oriName = oriName;
		this.savedName = savedName;
		this.reg_date = reg_date;
	}
	public ProFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
