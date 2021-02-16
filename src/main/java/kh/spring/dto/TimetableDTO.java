package kh.spring.dto;

public class TimetableDTO {
	
	
	private String title;
	private String time;
	private String classroom;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public TimetableDTO(String title, String time, String classroom) {
		super();
		this.title = title;
		this.time = time;
		this.classroom = classroom;
	}
	public TimetableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
