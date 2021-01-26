package kh.spring.dto;

import java.sql.Date;

public class FilesDTO {
	private int seq;
	private int parent_code;
	private String oriName;
	private String savedName;
	private Date reg_date;
	public FilesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilesDTO(int seq, int parent_code, String oriName, String savedName, Date reg_date) {
		super();
		this.seq = seq;
		this.parent_code = parent_code;
		this.oriName = oriName;
		this.savedName = savedName;
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
