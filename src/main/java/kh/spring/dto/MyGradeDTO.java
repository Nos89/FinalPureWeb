package kh.spring.dto;

public class MyGradeDTO {
	private String oc_code; 
	private String oc_name;
	private int reco_score;
	private String isu;
	private int grade_avg;
	private String grade_code;
	private String pro_name;
	private String pro_number;
	public MyGradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyGradeDTO(String oc_code, String oc_name, int reco_score, String isu, int grade_avg, String grade_code,
			String pro_name, String pro_number) {
		super();
		this.oc_code = oc_code;
		this.oc_name = oc_name;
		this.reco_score = reco_score;
		this.isu = isu;
		this.grade_avg = grade_avg;
		this.grade_code = grade_code;
		this.pro_name = pro_name;
		this.pro_number = pro_number;
	}
	public String getOc_code() {
		return oc_code;
	}
	public void setOc_code(String oc_code) {
		this.oc_code = oc_code;
	}
	public String getOc_name() {
		return oc_name;
	}
	public void setOc_name(String oc_name) {
		this.oc_name = oc_name;
	}
	public int getReco_score() {
		return reco_score;
	}
	public void setReco_score(int reco_score) {
		this.reco_score = reco_score;
	}
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
	}
	public int getGrade_avg() {
		return grade_avg;
	}
	public void setGrade_avg(int grade_avg) {
		this.grade_avg = grade_avg;
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_number() {
		return pro_number;
	}
	public void setPro_number(String pro_number) {
		this.pro_number = pro_number;
	}
	
}
