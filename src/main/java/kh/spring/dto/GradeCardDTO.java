package kh.spring.dto;

public class GradeCardDTO {
	private String grade_code;
	private int grade_number;
	public GradeCardDTO(String grade_code, int grade_number) {
		super();
		this.grade_code = grade_code;
		this.grade_number = grade_number;
	}
	public GradeCardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public int getGrade_number() {
		return grade_number;
	}
	public void setGrade_number(int grade_number) {
		this.grade_number = grade_number;
	}
	
	
}
