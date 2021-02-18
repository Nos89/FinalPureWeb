package kh.spring.dto;

import java.sql.Date;

public class InDirDTO {
	private int chk;
	private String name;
	private String isFolder;
	private long size;
	private Date date;
	private String savedName;
	public InDirDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InDirDTO(int chk, String name, String isFolder, long size, Date date, String savedName) {
		super();
		this.chk = chk;
		this.name = name;
		this.isFolder = isFolder;
		this.size = size;
		this.date = date;
		this.savedName = savedName;
	}
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsFolder() {
		return isFolder;
	}
	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	
}
