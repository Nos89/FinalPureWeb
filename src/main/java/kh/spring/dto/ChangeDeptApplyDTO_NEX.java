package kh.spring.dto;


public class ChangeDeptApplyDTO_NEX {
	private int seq;
	private String id;
	private String name;
	private int changeYear;
	private String changeSemester;
	private String reason;
	private String changeCollege;
	private String changeDept;
	private String apply_date;
	private String apply_approve;

	public ChangeDeptApplyDTO_NEX() {}

	// 신청 수리용
	public ChangeDeptApplyDTO_NEX(int seq, String id, String name, int changeYear, String changeSemester, String reason,
			String changeCollege, String changeDept, String apply_date, String apply_approve) {
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

	public String getApply_date() {
		return apply_date;
	}

	public void setApply_date(String apply_date) {
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
