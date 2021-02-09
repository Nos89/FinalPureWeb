package kh.spring.dto;

public class BuildDTO {
	private String build_code;
	private String build_name;
	
	public BuildDTO() {
		super();
	}
	public BuildDTO(String build_code, String build_name) {
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

