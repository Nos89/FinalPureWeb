package kh.spring.dto;

public class MyClassListDTO {
	private String cr_completeDiv;
	private String isu;
	private String oc_code;
	private String oc_name;
	private String oc_targetlevel;
	private String pro_name;
	private String oc_schedule;
	private int reco_score;
	private int oc_part;
	public MyClassListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyClassListDTO(String cr_completeDiv, String isu, String oc_code, String oc_name, String oc_targetlevel,
			String pro_name, String oc_schedule, int reco_score, int oc_part) {
		super();
		this.cr_completeDiv = cr_completeDiv;
		this.isu = isu;
		this.oc_code = oc_code;
		this.oc_name = oc_name;
		this.oc_targetlevel = oc_targetlevel;
		this.pro_name = pro_name;
		this.oc_schedule = oc_schedule;
		this.reco_score = reco_score;
		this.oc_part = oc_part;
	}
	public String getCr_completeDiv() {
		return cr_completeDiv;
	}
	public void setCr_completeDiv(String cr_completeDiv) {
		this.cr_completeDiv = cr_completeDiv;
	}
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
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
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
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
	public int getOc_part() {
		return oc_part;
	}
	public void setOc_part(int oc_part) {
		this.oc_part = oc_part;
	}
	
	
}
