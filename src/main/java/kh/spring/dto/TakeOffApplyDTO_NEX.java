package kh.spring.dto;


public class TakeOffApplyDTO_NEX {
	private int seq;
	private String id;
	private String name;
	private String col_title;
	private String dept_title;
	private String reason;
	private int takeOff_Year;
	private String takeOff_Semester;
	private int expectedReturnYear;
	private String apply_date;
	private String apply_approve;
	
	public TakeOffApplyDTO_NEX() {
		super();
	}
	public TakeOffApplyDTO_NEX(int seq, String id, String name, String col_title, String dept_title, String reason,
			int takeOff_Year, String takeOff_Semester, int expectedReturnYear, String apply_date,
			String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.col_title = col_title;
		this.dept_title = dept_title;
		this.reason = reason;
		this.takeOff_Year = takeOff_Year;
		this.takeOff_Semester = takeOff_Semester;
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
	public String getCol_title() {
		return col_title;
	}
	public void setCol_title(String col_title) {
		this.col_title = col_title;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
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

}
