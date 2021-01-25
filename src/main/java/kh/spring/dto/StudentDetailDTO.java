package kh.spring.dto;

public class StudentDetailDTO {
	private String id;
	private String std_status;
	private int std_year;
	
	
	public StudentDetailDTO() {}
	
	public StudentDetailDTO(String id, String std_status, int std_year) {
		super();
		this.id = id;
		this.std_status = std_status;
		this.std_year = std_year;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStd_status() {
		return std_status;
	}
	public void setStd_status(String std_status) {
		this.std_status = std_status;
	}
	public int getStd_year() {
		return std_year;
	}
	public void setStd_year(int std_year) {
		this.std_year = std_year;
	}
	
	
}
