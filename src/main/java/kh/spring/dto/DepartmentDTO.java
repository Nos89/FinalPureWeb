package kh.spring.dto;

public class DepartmentDTO {
	private String dept_code;
	private String dept_title;
	private String col_code;
	private String build_code;
	private String ofi_code;
	public DepartmentDTO(String dept_code, String dept_title, String col_code, String build_code, String ofi_code) {
		super();
		this.dept_code = dept_code;
		this.dept_title = dept_title;
		this.col_code = col_code;
		this.build_code = build_code;
		this.ofi_code = ofi_code;
	}
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getCol_code() {
		return col_code;
	}
	public void setCol_code(String col_code) {
		this.col_code = col_code;
	}
	public String getBuild_code() {
		return build_code;
	}
	public void setBuild_code(String build_code) {
		this.build_code = build_code;
	}
	public String getOfi_code() {
		return ofi_code;
	}
	public void setOfi_code(String ofi_code) {
		this.ofi_code = ofi_code;
	}
	
	
}
