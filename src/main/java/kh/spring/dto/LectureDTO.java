package kh.spring.dto;

public class LectureDTO {
	private String lec_code;
	private String lec_title;
	private int lec_approval;
	private String lec_deny_reason;
	private String pro_name;
	private int lec_semester;
	private String lec_targetLevel;
	private String lec_classroom;
	private String lec_schedule;
	private int lec_score;
	private String lec_isu;
	private String lec_summary;
	private String lec_way;
	private String lec_book;
	private String lec_eval;
	public LectureDTO(String lec_code, String lec_title, int lec_approval, String lec_deny_reason, String pro_name,
			int lec_semester, String lec_targetLevel, String lec_classroom, String lec_schedule, int lec_score,
			String lec_isu, String lec_summary, String lec_way, String lec_book, String lec_eval) {
		super();
		this.lec_code = lec_code;
		this.lec_title = lec_title;
		this.lec_approval = lec_approval;
		this.lec_deny_reason = lec_deny_reason;
		this.pro_name = pro_name;
		this.lec_semester = lec_semester;
		this.lec_targetLevel = lec_targetLevel;
		this.lec_classroom = lec_classroom;
		this.lec_schedule = lec_schedule;
		this.lec_score = lec_score;
		this.lec_isu = lec_isu;
		this.lec_summary = lec_summary;
		this.lec_way = lec_way;
		this.lec_book = lec_book;
		this.lec_eval = lec_eval;
	}
	public LectureDTO() {
		super();
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public int getLec_approval() {
		return lec_approval;
	}
	public void setLec_approval(int lec_approval) {
		this.lec_approval = lec_approval;
	}
	public String getLec_deny_reason() {
		return lec_deny_reason;
	}
	public void setLec_deny_reason(String lec_deny_reason) {
		this.lec_deny_reason = lec_deny_reason;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getLec_semester() {
		return lec_semester;
	}
	public void setLec_semester(int lec_semester) {
		this.lec_semester = lec_semester;
	}
	public String getLec_targetLevel() {
		return lec_targetLevel;
	}
	public void setLec_targetLevel(String lec_targetLevel) {
		this.lec_targetLevel = lec_targetLevel;
	}
	public String getLec_classroom() {
		return lec_classroom;
	}
	public void setLec_classroom(String lec_classroom) {
		this.lec_classroom = lec_classroom;
	}
	public String getLec_schedule() {
		return lec_schedule;
	}
	public void setLec_schedule(String lec_schedule) {
		this.lec_schedule = lec_schedule;
	}
	public int getLec_score() {
		return lec_score;
	}
	public void setLec_score(int lec_score) {
		this.lec_score = lec_score;
	}
	public String getLec_isu() {
		return lec_isu;
	}
	public void setLec_isu(String lec_isu) {
		this.lec_isu = lec_isu;
	}
	public String getLec_summary() {
		return lec_summary;
	}
	public void setLec_summary(String lec_summary) {
		this.lec_summary = lec_summary;
	}
	public String getLec_way() {
		return lec_way;
	}
	public void setLec_way(String lec_way) {
		this.lec_way = lec_way;
	}
	public String getLec_book() {
		return lec_book;
	}
	public void setLec_book(String lec_book) {
		this.lec_book = lec_book;
	}
	public String getLec_eval() {
		return lec_eval;
	}
	public void setLec_eval(String lec_eval) {
		this.lec_eval = lec_eval;
	}
	
	
	
	
}
