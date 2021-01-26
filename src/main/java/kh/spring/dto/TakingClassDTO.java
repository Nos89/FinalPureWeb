package kh.spring.dto;

public class TakingClassDTO {
	private String lec_isu; //교선, 교필..
	private String lec_title; //강의명
	private int lec_score; //학점 1,2,3,4,5
	private String lec_schedule; //월(3,4)/수(5)
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
	public TakingClassDTO(String lec_isu, String lec_title, int lec_score, String lec_schedule) {
		super();
		this.lec_isu = lec_isu;
		this.lec_title = lec_title;
		this.lec_score = lec_score;
		this.lec_schedule = lec_schedule;
	}
	public TakingClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
