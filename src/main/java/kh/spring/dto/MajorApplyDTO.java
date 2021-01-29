package kh.spring.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MajorApplyDTO {
	private String id;
	private String lec_code;
	private String cr_divide;
	private String cr_completeDiv;
	
	public MajorApplyDTO() {}
	public MajorApplyDTO(String id, String lec_code, String cr_divide, String cr_completeDiv) {
		super();
		this.id = id;
		this.lec_code = lec_code;
		this.cr_divide = cr_divide;
		this.cr_completeDiv = cr_completeDiv;
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
	public String getCr_completeDiv() {
		return cr_completeDiv;
	}
	public void setCr_completeDiv(String cr_completeDiv) {
		this.cr_completeDiv = cr_completeDiv;
	}

	
}
