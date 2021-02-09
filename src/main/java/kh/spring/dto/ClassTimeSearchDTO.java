package kh.spring.dto;

public class ClassTimeSearchDTO {
	private String oc_code;
	private String oc_name;
	private String isu;
	private String pro_name;
	private int oc_max;
	private int oc_part;
	private String oc_targetlevel;
	private String oc_schedule;
	private int reco_score;
	private String oc_year;
	private String oc_semester;
	private String dept_title;
	private String col_title;
	public ClassTimeSearchDTO() {}
	public ClassTimeSearchDTO(String oc_code, String oc_name, String isu, String pro_name, int oc_max, int oc_part,
			String oc_targetlevel, String oc_schedule, int reco_score, String oc_year, String oc_semester,
			String dept_title, String col_title) {
		super();
		this.oc_code = oc_code;
		this.oc_name = oc_name;
		this.isu = isu;
		this.pro_name = pro_name;
		this.oc_max = oc_max;
		this.oc_part = oc_part;
		this.oc_targetlevel = oc_targetlevel;
		this.oc_schedule = oc_schedule;
		this.reco_score = reco_score;
		this.oc_year = oc_year;
		this.oc_semester = oc_semester;
		this.dept_title = dept_title;
		this.col_title = col_title;
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
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getOc_max() {
		return oc_max;
	}
	public void setOc_max(int oc_max) {
		this.oc_max = oc_max;
	}
	public int getOc_part() {
		return oc_part;
	}
	public void setOc_part(int oc_part) {
		this.oc_part = oc_part;
	}
	public String getOc_targetlevel() {
		return oc_targetlevel;
	}
	public void setOc_targetlevel(String oc_targetlevel) {
		this.oc_targetlevel = oc_targetlevel;
	}
	public String getOc_schedule() {
		return oc_schedule;
	}
	public void setOc_schedule(String oc_schedule) {
		this.oc_schedule = oc_schedule;
	}
	public int getReco_score() {
		return reco_score;
	}
	public void setReco_score(int reco_score) {
		this.reco_score = reco_score;
	}
	public String getOc_year() {
		return oc_year;
	}
	public void setOc_year(String oc_year) {
		this.oc_year = oc_year;
	}
	public String getOc_semester() {
		return oc_semester;
	}
	public void setOc_semester(String oc_semester) {
		this.oc_semester = oc_semester;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getCol_title() {
		return col_title;
	}
	public void setCol_title(String col_title) {
		this.col_title = col_title;
	}
	
	
	
}
