package kh.spring.dto;

import java.sql.Date;

public class CreditRenounceDTO {
	private int seq;
	private String id;
	private String renounceSubject;
	private Date apply_date;
	private String apply_approve;
	
	public CreditRenounceDTO() {
		super();
	}

	public CreditRenounceDTO(int seq, String id, String renounceSubject, Date apply_date, String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.renounceSubject = renounceSubject;
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

	public String getRenounceSubject() {
		return renounceSubject;
	}

	public void setRenounceSubject(String renounceSubject) {
		this.renounceSubject = renounceSubject;
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
