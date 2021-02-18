package kh.spring.dto;

public class GradeListDTO {
	private String oc_code;
	private String oc_name;
	private String oc_targetlevel;
	private String isu;
	private int reco_score;
	private String grade_code;
	public GradeListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeListDTO(String oc_code, String oc_name, String oc_targetlevel, String isu, int reco_score,
			String grade_code) {
		super();
		this.oc_code = oc_code;
		this.oc_name = oc_name;
		this.oc_targetlevel = oc_targetlevel;
		this.isu = isu;
		this.reco_score = reco_score;
		this.grade_code = grade_code;
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
	public String getOc_targetlevel() {
		return oc_targetlevel;
	}
	public void setOc_targetlevel(String oc_targetlevel) {
		this.oc_targetlevel = oc_targetlevel;
	}
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
	}
	public int getReco_score() {
		return reco_score;
	}
	public void setReco_score(int reco_score) {
		this.reco_score = reco_score;
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	
	
}
