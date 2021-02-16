package kh.spring.dto;

public class ClassTimeDTO {
	private String oc_schedule;
	private String s_name;
	private String p_name;
	public ClassTimeDTO() {}
	public ClassTimeDTO(String oc_schedule, String s_name, String p_name) {
		super();
		this.oc_schedule = oc_schedule;
		this.s_name = s_name;
		this.p_name = p_name;
	}
	public String getOc_schedule() {
		return oc_schedule;
	}
	public void setOc_schedule(String oc_schedule) {
		this.oc_schedule = oc_schedule;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
}
