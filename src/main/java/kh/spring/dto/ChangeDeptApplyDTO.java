package kh.spring.dto;

import java.sql.Date;

public class ChangeDeptApplyDTO {
	private int seq;
	private String id;
	private String name;
	private String colTitle;
	private String deptTitle;
	private int changeYear;
	private String changeSemester;
	private String reason;
	private String changeCollege;
	private String changeDept;
	private Date apply_date;
	private String apply_approve;
	
	public ChangeDeptApplyDTO() {}

	public ChangeDeptApplyDTO(String id, int changeYear, String changeSemester, String reason, String changeCollege,
			String changeDept) {
		super();
		this.id = id;
		this.changeYear = changeYear;
		this.changeSemester = changeSemester;
		this.reason = reason;
		this.changeCollege = changeCollege;
		this.changeDept = changeDept;
	}
	
	// 신청수리
	public ChangeDeptApplyDTO(int seq, String id, String name, int changeYear, String changeSemester, String reason,
			String changeCollege, String changeDept, Date apply_date, String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.changeYear = changeYear;
		this.changeSemester = changeSemester;
		this.reason = reason;
		this.changeCollege = changeCollege;
		this.changeDept = changeDept;
		this.apply_date = apply_date;
		this.apply_approve = apply_approve;
	}

	// 신청조회
	public ChangeDeptApplyDTO(int seq, String id, String name, String colTitle, String deptTitle, int changeYear,
			String changeSemester, String reason, String changeCollege, String changeDept, Date apply_date,
			String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.colTitle = colTitle;
		this.deptTitle = deptTitle;
		this.changeYear = changeYear;
		this.changeSemester = changeSemester;
		this.reason = reason;
		this.changeCollege = changeCollege;
		this.changeDept = changeDept;
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
	
	public String getColTitle() {
		return colTitle;
	}

	public void setColTitle(String colTitle) {
		this.colTitle = colTitle;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public int getChangeYear() {
		return changeYear;
	}

	public void setChangeYear(int changeYear) {
		this.changeYear = changeYear;
	}

	public String getChangeSemester() {
		return changeSemester;
	}

	public void setChangeSemester(String changeSemester) {
		this.changeSemester = changeSemester;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getChangeCollege() {
		return changeCollege;
	}

	public void setChangeCollege(String changeCollege) {
		this.changeCollege = changeCollege;
	}

	public String getChangeDept() {
		return changeDept;
	}

	public void setChangeDept(String changeDept) {
		this.changeDept = changeDept;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
