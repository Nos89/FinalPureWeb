package kh.spring.dto;

public class ConditionForRoomInfoDTO {
	private int year;
	private int semester;
	private String classroom;
	public ConditionForRoomInfoDTO() {}
	public ConditionForRoomInfoDTO(int year, int semester, String classroom) {
		super();
		this.year = year;
		this.semester = semester;
		this.classroom = classroom;
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
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	
}
