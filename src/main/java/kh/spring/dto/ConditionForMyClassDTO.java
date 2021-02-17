package kh.spring.dto;

public class ConditionForMyClassDTO {
	private int year;
	private int semester;
	public ConditionForMyClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConditionForMyClassDTO(int year, int semester) {
		super();
		this.year = year;
		this.semester = semester;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
