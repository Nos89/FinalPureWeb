package kh.spring.dto;

public class TakeOffApplyDTO {
	private String id;
	private String reason;
	private int takeOffYear;
	private String takeOffSemester;
	private int expectedReturnYear;
	public TakeOffApplyDTO() {}
	public TakeOffApplyDTO(String id, String reason, int takeOffYear, String takeOffSemester, int expectedReturnYear) {
		super();
		this.id = id;
		this.reason = reason;
		this.takeOffYear = takeOffYear;
		this.takeOffSemester = takeOffSemester;
		this.expectedReturnYear = expectedReturnYear;
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
	
}
