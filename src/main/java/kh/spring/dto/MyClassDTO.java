package kh.spring.dto;

public class MyClassDTO {
	private String oc_code;
	private String oc_name;
	private String isu;
	private String pro_name;
	private String pro_number;
	private String oc_schedule;
	private int reco_score;
	public MyClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyClassDTO(String oc_code, String oc_name, String isu, String pro_name, String pro_number,
			String oc_schedule, int reco_score) {
		super();
		this.oc_code = oc_code;
		this.oc_name = oc_name;
		this.isu = isu;
		this.pro_name = pro_name;
		this.pro_number = pro_number;
		this.oc_schedule = oc_schedule;
		this.reco_score = reco_score;
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
	public String getPro_number() {
		return pro_number;
	}
	public void setPro_number(String pro_number) {
		this.pro_number = pro_number;
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
	
}
