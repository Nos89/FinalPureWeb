package kh.spring.dto;

public class ElecSelectClassDTO {
	private String lec_code;
	private String lec_title;
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
	public ElecSelectClassDTO(String lec_code, String lec_title) {
		super();
		this.lec_code = lec_code;
		this.lec_title = lec_title;
	}
	public ElecSelectClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
