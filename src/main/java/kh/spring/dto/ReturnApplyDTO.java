package kh.spring.dto;

import java.sql.Date;

public class ReturnApplyDTO {
	private int seq;
	private String id;
	private String reason;
	private int return_year;
	private String return_semester;
	private Date apply_date;
	private String apply_approve;
	
	
	public ReturnApplyDTO() {
		super();
	}

	public ReturnApplyDTO(int seq, String id, String reason, int return_year, String return_semester, Date apply_date, String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.reason = reason;
		this.return_year = return_year;
		this.return_semester = return_semester;
		this.apply_date = apply_date;
		this.apply_approve = apply_approve;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getReturn_year() {
		return return_year;
	}

	public void setReturn_year(int return_year) {
		this.return_year = return_year;
	}

	public String getReturn_semester() {
		return return_semester;
	}

	public void setReturn_semester(String return_semester) {
		this.return_semester = return_semester;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public String getApply_approve() {
		return apply_approve;
	}

	public void setApply_approve(String apply_approve) {
		this.apply_approve = apply_approve;
	}
	
}
