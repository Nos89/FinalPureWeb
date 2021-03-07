package kh.spring.dto;

public class BuildInfoDTO {
	private String build_code;
	private String build_name;
	public BuildInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuildInfoDTO(String build_code, String build_name) {
		super();
		this.build_code = build_code;
		this.build_name = build_name;
	}
	public String getBuild_code() {
		return build_code;
	}
	public void setBuild_code(String build_code) {
		this.build_code = build_code;
	}
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	
}
