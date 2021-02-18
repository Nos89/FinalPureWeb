package kh.spring.dto;

public class MyClassTimeDTO {
	private String oc_schedule;
	private String s_name;
	private String p_name;
	private String oc_class_room;
	public MyClassTimeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyClassTimeDTO(String oc_schedule, String s_name, String p_name, String oc_class_room) {
		super();
		this.oc_schedule = oc_schedule;
		this.s_name = s_name;
		this.p_name = p_name;
		this.oc_class_room = oc_class_room;
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
	public String getOc_class_room() {
		return oc_class_room;
	}
	public void setOc_class_room(String oc_class_room) {
		this.oc_class_room = oc_class_room;
	}
	
}
