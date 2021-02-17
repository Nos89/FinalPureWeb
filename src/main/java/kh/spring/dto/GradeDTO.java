package kh.spring.dto;

public class GradeDTO {
	private int grade_seq;
	private String std_id;
	private String lec_code;
	private String grade_code;
	private int grade_attend;
	private int grade_repo;
	private int grade_mid;
	private int grade_pre;
	private int grade_final;
	private int grade_atti;
	private int grade_quiz;
	private int grade_etc;
	private int grade_total;
	public GradeDTO(int grade_seq, String std_id, String lec_code, String grade_code, int grade_attend, int grade_repo,
			int grade_mid, int grade_pre, int grade_final, int grade_atti, int grade_quiz, int grade_etc,
			int grade_total) {
		super();
		this.grade_seq = grade_seq;
		this.std_id = std_id;
		this.lec_code = lec_code;
		this.grade_code = grade_code;
		this.grade_attend = grade_attend;
		this.grade_repo = grade_repo;
		this.grade_mid = grade_mid;
		this.grade_pre = grade_pre;
		this.grade_final = grade_final;
		this.grade_atti = grade_atti;
		this.grade_quiz = grade_quiz;
		this.grade_etc = grade_etc;
		this.grade_total = grade_total;
	}
	public GradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGrade_seq() {
		return grade_seq;
	}
	public void setGrade_seq(int grade_seq) {
		this.grade_seq = grade_seq;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public int getGrade_attend() {
		return grade_attend;
	}
	public void setGrade_attend(int grade_attend) {
		this.grade_attend = grade_attend;
	}
	public int getGrade_repo() {
		return grade_repo;
	}
	public void setGrade_repo(int grade_repo) {
		this.grade_repo = grade_repo;
	}
	public int getGrade_mid() {
		return grade_mid;
	}
	public void setGrade_mid(int grade_mid) {
		this.grade_mid = grade_mid;
	}
	public int getGrade_pre() {
		return grade_pre;
	}
	public void setGrade_pre(int grade_pre) {
		this.grade_pre = grade_pre;
	}
	public int getGrade_final() {
		return grade_final;
	}
	public void setGrade_final(int grade_final) {
		this.grade_final = grade_final;
	}
	public int getGrade_atti() {
		return grade_atti;
	}
	public void setGrade_atti(int grade_atti) {
		this.grade_atti = grade_atti;
	}
	public int getGrade_quiz() {
		return grade_quiz;
	}
	public void setGrade_quiz(int grade_quiz) {
		this.grade_quiz = grade_quiz;
	}
	public int getGrade_etc() {
		return grade_etc;
	}
	public void setGrade_etc(int grade_etc) {
		this.grade_etc = grade_etc;
	}
	public int getGrade_total() {
		return grade_total;
	}
	public void setGrade_total(int grade_total) {
		this.grade_total = grade_total;
	}
	
	
	
	
}
