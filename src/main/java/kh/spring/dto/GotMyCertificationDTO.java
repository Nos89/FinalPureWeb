package kh.spring.dto;

import java.sql.Date;

public class GotMyCertificationDTO {
	private String cer_seq;
	private String cer_name;
	private String cer_date;
	public GotMyCertificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GotMyCertificationDTO(String cer_seq, String cer_name, String cer_date) {
		super();
		this.cer_seq = cer_seq;
		this.cer_name = cer_name;
		this.cer_date = cer_date;
	}
	public String getCer_seq() {
		return cer_seq;
	}
	public void setCer_seq(String cer_seq) {
		this.cer_seq = cer_seq;
	}
	public String getCer_name() {
		return cer_name;
	}
	public void setCer_name(String cer_name) {
		this.cer_name = cer_name;
	}
	public String getCer_date() {
		return cer_date;
	}
	public void setCer_date(String cer_date) {
		this.cer_date = cer_date;
	}
	
	
}
