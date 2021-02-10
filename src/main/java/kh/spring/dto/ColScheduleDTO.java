package kh.spring.dto;

import java.sql.Date;

public class ColScheduleDTO {
	private int seq;
	private String title;
	private String contents;
	private Date sche_startDate;
	private Date sche_endDate;
	
	public ColScheduleDTO() {
		super();
	}

	public ColScheduleDTO(int seq, String title, String contents, Date sche_startDate, Date sche_endDate) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.sche_startDate = sche_startDate;
		this.sche_endDate = sche_endDate;
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

	public Date getSche_startDate() {
		return sche_startDate;
	}

	public void setSche_startDate(Date sche_startDate) {
		this.sche_startDate = sche_startDate;
	}

	public Date getSche_endDate() {
		return sche_endDate;
	}

	public void setSche_endDate(Date sche_endDate) {
		this.sche_endDate = sche_endDate;
	}
	
}
