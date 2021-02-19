package kh.spring.dto;

import java.sql.Date;

public class TakeOffApplyDTO {
	private int seq;
	private String id;
	private String name;
	private String reason;
	private int takeOffYear;
	private String takeOffSemester;
	private int expectedReturnYear;
	private Date apply_date;
	private String apply_approve;
	
	public TakeOffApplyDTO() {}
	public TakeOffApplyDTO(String id, String reason, int takeOffYear, String takeOffSemester, int expectedReturnYear) {
		super();
		this.id = id;
		this.reason = reason;
		this.takeOffYear = takeOffYear;
		this.takeOffSemester = takeOffSemester;
		this.expectedReturnYear = expectedReturnYear;
	}
	
	// 신청 수리용
	public TakeOffApplyDTO(int seq, String id, String name, String reason, int takeOffYear, String takeOffSemester,
			int expectedReturnYear, Date apply_date, String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.reason = reason;
		this.takeOffYear = takeOffYear;
		this.takeOffSemester = takeOffSemester;
		this.expectedReturnYear = expectedReturnYear;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getTakeOffYear() {
		return takeOffYear;
	}
	public void setTakeOffYear(int takeOffYear) {
		this.takeOffYear = takeOffYear;
	}
	public String getTakeOffSemester() {
		return takeOffSemester;
	}
	public void setTakeOffSemester(String takeOffSemester) {
		this.takeOffSemester = takeOffSemester;
	}
	public int getExpectedReturnYear() {
		return expectedReturnYear;
	}
	public void setExpectedReturnYear(int expectedReturnYear) {
		this.expectedReturnYear = expectedReturnYear;
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
