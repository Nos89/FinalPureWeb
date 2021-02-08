package kh.spring.dto;

public class SubjectDTO {
	private String code;
	private String name;
	private String dept_code;
	private String isu;
	private String reco_score;
	private String dst_date;
	public SubjectDTO(String code, String name, String dept_code, String isu, String reco_score, String dst_date) {
		super();
		this.code = code;
		this.name = name;
		this.dept_code = dept_code;
		this.isu = isu;
		this.reco_score = reco_score;
		this.dst_date = dst_date;
	}
	public SubjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
	}
	public String getReco_score() {
		return reco_score;
	}
	public void setReco_score(String reco_score) {
		this.reco_score = reco_score;
	}
	public String getDst_date() {
		return dst_date;
	}
	public void setDst_date(String dst_date) {
		this.dst_date = dst_date;
	}
	
	

}
