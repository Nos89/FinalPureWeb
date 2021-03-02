package kh.spring.dto;

public class ConditionForMyClassDTO {
	private String year;
	private String semester;
	public ConditionForMyClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConditionForMyClassDTO(String year, String semester) {
		super();
		this.year = year;
		this.semester = semester;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
