package kh.spring.dto;

public class CollegeDTO {
	private String col_code;
	private String col_title;
	public CollegeDTO(String col_code, String col_title) {
		super();
		this.col_code = col_code;
		this.col_title = col_title;
	}
	public CollegeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCol_code() {
		return col_code;
	}
	public void setCol_code(String col_code) {
		this.col_code = col_code;
	}
	public String getCol_title() {
		return col_title;
	}
	public void setCol_title(String col_title) {
		this.col_title = col_title;
	}
	
	
}
