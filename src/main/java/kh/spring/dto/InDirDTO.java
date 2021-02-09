package kh.spring.dto;

import java.sql.Date;

public class InDirDTO {
	private String name;
	private String isFolder;
	private long size;
	private Date date;
	public InDirDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InDirDTO(String name, String isFolder, long size, Date date) {
		super();
		this.name = name;
		this.isFolder = isFolder;
		this.size = size;
		this.date = date;
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
	
}
