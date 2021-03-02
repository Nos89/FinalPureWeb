package kh.spring.dto;

public class ConditionForRoomInfoDTO {
	private String year;
	private String semester;
	private String classroom;
	public ConditionForRoomInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConditionForRoomInfoDTO(String year, String semester, String classroom) {
		super();
		this.year = year;
		this.semester = semester;
		this.classroom = classroom;
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
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	
}
