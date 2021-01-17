package kh.spring.dto;

import java.util.Date;

public class MilitaryDTO_NEX {
	private String std_code;
	private Date mil_inDate;
	private Date mil_outDate;
	private String mil_title;  // 코드로 가져온 육군, 해군, 공군
	private String mil_rank;
	private String mil_code; // 군번
	public MilitaryDTO_NEX(String std_code, Date mil_inDate, Date mil_outDate, String mil_title, String mil_rank,
			String mil_code) {
		super();
		this.std_code = std_code;
		this.mil_inDate = mil_inDate;
		this.mil_outDate = mil_outDate;
		this.mil_title = mil_title;
		this.mil_rank = mil_rank;
		this.mil_code = mil_code;
	}
	public MilitaryDTO_NEX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStd_code() {
		return std_code;
	}
	public void setStd_code(String std_code) {
		this.std_code = std_code;
	}
	public Date getMil_inDate() {
		return mil_inDate;
	}
	public void setMil_inDate(Date mil_inDate) {
		this.mil_inDate = mil_inDate;
	}
	public Date getMil_outDate() {
		return mil_outDate;
	}
	public void setMil_outDate(Date mil_outDate) {
		this.mil_outDate = mil_outDate;
	}
	public String getMil_title() {
		return mil_title;
	}
	public void setMil_title(String mil_title) {
		this.mil_title = mil_title;
	}
	public String getMil_rank() {
		return mil_rank;
	}
	public void setMil_rank(String mil_rank) {
		this.mil_rank = mil_rank;
	}
	public String getMil_code() {
		return mil_code;
	}
	public void setMil_code(String mil_code) {
		this.mil_code = mil_code;
	}

	
	
	
}
