package kh.spring.dto;

import java.sql.Date;

public class CloudDTO {
	private String cloud_id;
	private int file_location;
	private String file_oriName;
	private String file_savedName;
	private Date file_date;
	private long file_size;
	public CloudDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CloudDTO(String cloud_id, int file_location, String file_oriName, String file_savedName, Date file_date,
			long file_size) {
		super();
		this.cloud_id = cloud_id;
		this.file_location = file_location;
		this.file_oriName = file_oriName;
		this.file_savedName = file_savedName;
		this.file_date = file_date;
		this.file_size = file_size;
	}
	public String getCloud_id() {
		return cloud_id;
	}
	public void setCloud_id(String cloud_id) {
		this.cloud_id = cloud_id;
	}
	public int getFile_location() {
		return file_location;
	}
	public void setFile_location(int file_location) {
		this.file_location = file_location;
	}
	public String getFile_oriName() {
		return file_oriName;
	}
	public void setFile_oriName(String file_oriName) {
		this.file_oriName = file_oriName;
	}
	public String getFile_savedName() {
		return file_savedName;
	}
	public void setFile_savedName(String file_savedName) {
		this.file_savedName = file_savedName;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
}
