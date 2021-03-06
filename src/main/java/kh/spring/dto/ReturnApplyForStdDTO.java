package kh.spring.dto;

public class ReturnApplyForStdDTO {
	private String id;
	private String reason;
	private int returnYear;
	private String returnSemester;
	public ReturnApplyForStdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnApplyForStdDTO(String id, String reason, int returnYear, String returnSemester) {
		super();
		this.id = id;
		this.reason = reason;
		this.returnYear = returnYear;
		this.returnSemester = returnSemester;
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
	public int getReturnYear() {
		return returnYear;
	}
	public void setReturnYear(int returnYear) {
		this.returnYear = returnYear;
	}
	public String getReturnSemester() {
		return returnSemester;
	}
	public void setReturnSemester(String returnSemester) {
		this.returnSemester = returnSemester;
	}
	
	
}
