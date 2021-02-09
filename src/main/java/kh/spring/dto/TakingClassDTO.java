package kh.spring.dto;

public class TakingClassDTO {
	private String lec_isu; //교선, 교필..
	private String lec_title; //강의명
	private int lec_score; //학점 1,2,3,4,5
	private String lec_schedule; //월(3,4)/수(5)
	private String lec_classroom; //강의실 07-406
	private String pro_name;
	private String lec_code;
	public String getLec_isu() {
		return lec_isu;
	}
	public void setLec_isu(String lec_isu) {
		this.lec_isu = lec_isu;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public int getLec_score() {
		return lec_score;
	}
	public void setLec_score(int lec_score) {
		this.lec_score = lec_score;
	}
	public String getLec_schedule() {
		return lec_schedule;
	}
	public void setLec_schedule(String lec_schedule) {
		this.lec_schedule = lec_schedule;
	}
	public String getLec_classroom() {
		return lec_classroom;
	}
	public void setLec_classroom(String lec_classroom) {
		this.lec_classroom = lec_classroom;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public TakingClassDTO(String lec_isu, String lec_title, int lec_score, String lec_schedule, String lec_classroom,
			String pro_name, String lec_code) {
		super();
		this.lec_isu = lec_isu;
		this.lec_title = lec_title;
		this.lec_score = lec_score;
		this.lec_schedule = lec_schedule;
		this.lec_classroom = lec_classroom;
		this.pro_name = pro_name;
		this.lec_code = lec_code;
	}
	public TakingClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
