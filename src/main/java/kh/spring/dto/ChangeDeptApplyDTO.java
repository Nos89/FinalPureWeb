package kh.spring.dto;

public class ChangeDeptApplyDTO {
	private String id;
	private int changeYear;
	private String changeSemester;
	private String reason;
	private String changeCollege;
	private String changeDept;
	
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
	
	
}
