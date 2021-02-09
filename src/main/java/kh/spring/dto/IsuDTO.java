package kh.spring.dto;

public class IsuDTO {
	private String isu_code;
	private String isu_name;
	public IsuDTO(String isu_code, String isu_name) {
		super();
		this.isu_code = isu_code;
		this.isu_name = isu_name;
	}
	public IsuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIsu_code() {
		return isu_code;
	}
	public void setIsu_code(String isu_code) {
		this.isu_code = isu_code;
	}
	public String getIsu_name() {
		return isu_name;
	}
	public void setIsu_name(String isu_name) {
		this.isu_name = isu_name;
	}
	
	
}
