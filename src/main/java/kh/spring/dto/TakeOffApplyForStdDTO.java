package kh.spring.dto;

public class TakeOffApplyForStdDTO {
	private String id;
	private String reason;
	private int takeOff_Year;
	private String takeOff_Semester;
	private int expectedReturnYear;
	public TakeOffApplyForStdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TakeOffApplyForStdDTO(String id, String reason, int takeOff_Year, String takeOff_Semester,
			int expectedReturnYear) {
		super();
		this.id = id;
		this.reason = reason;
		this.takeOff_Year = takeOff_Year;
		this.takeOff_Semester = takeOff_Semester;
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
	public int getTakeOff_Year() {
		return takeOff_Year;
	}
	public void setTakeOff_Year(int takeOff_Year) {
		this.takeOff_Year = takeOff_Year;
	}
	public String getTakeOff_Semester() {
		return takeOff_Semester;
	}
	public void setTakeOff_Semester(String takeOff_Semester) {
		this.takeOff_Semester = takeOff_Semester;
	}
	public int getExpectedReturnYear() {
		return expectedReturnYear;
	}
	public void setExpectedReturnYear(int expectedReturnYear) {
		this.expectedReturnYear = expectedReturnYear;
	}
	
	
}
