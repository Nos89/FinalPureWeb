package kh.spring.dto;

public class ClassRegistrationDetailDTO {
	private String lec_code;
	private String title;
	private String id;
	private String dept_title;
	private String name;
	private int std_year;
	private String check;
	public ClassRegistrationDetailDTO(String lec_code, String title, String id, String dept_title, String name,
			int std_year, String check) {
		super();
		this.lec_code = lec_code;
		this.title = title;
		this.id = id;
		this.dept_title = dept_title;
		this.name = name;
		this.std_year = std_year;
		this.check = check;
	}
	public ClassRegistrationDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStd_year() {
		return std_year;
	}
	public void setStd_year(int std_year) {
		this.std_year = std_year;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
	
	

}
