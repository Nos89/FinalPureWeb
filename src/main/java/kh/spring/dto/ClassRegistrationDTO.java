package kh.spring.dto;

import java.sql.Date;

public class ClassRegistrationDTO {
	private String cr_seq;
	private String id;
	private String lec_code;
	private String cr_divide;
	private String cr_completediv;
	private Date cr_date;
	public ClassRegistrationDTO(String cr_seq, String id, String lec_code, String cr_divide, String cr_completediv,
			Date cr_date) {
		super();
		this.cr_seq = cr_seq;
		this.id = id;
		this.lec_code = lec_code;
		this.cr_divide = cr_divide;
		this.cr_completediv = cr_completediv;
		this.cr_date = cr_date;
	}
	public ClassRegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCr_seq() {
		return cr_seq;
	}
	public void setCr_seq(String cr_seq) {
		this.cr_seq = cr_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getCr_divide() {
		return cr_divide;
	}
	public void setCr_divide(String cr_divide) {
		this.cr_divide = cr_divide;
	}
	public String getCr_completediv() {
		return cr_completediv;
	}
	public void setCr_completediv(String cr_completediv) {
		this.cr_completediv = cr_completediv;
	}
	public Date getCr_date() {
		return cr_date;
	}
	public void setCr_date(Date cr_date) {
		this.cr_date = cr_date;
	}
	
	
}
