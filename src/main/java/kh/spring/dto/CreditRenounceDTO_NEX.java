package kh.spring.dto;

import java.sql.Date;

public class CreditRenounceDTO_NEX {
	private int seq;
	private String id;
	private String name;
	private String col_title;
	private String dept_title;
	private String renounceSubject;
	private String lec_title;
	private String grade_code;
	private String reco_score;
	private String apply_date;
	private String apply_approve;
	
	public CreditRenounceDTO_NEX() {
		super();
	}
	
	public CreditRenounceDTO_NEX(int seq, String id, String name, String col_title, String dept_title,
							String lec_title,String grade_code, String reco_score, String apply_date, String apply_approve) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.col_title = col_title;
		this.dept_title = dept_title;
		this.lec_title = lec_title;
		this.grade_code = grade_code;
		this.reco_score = reco_score;
		this.apply_date = apply_date;
		this.apply_approve = apply_approve;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCol_title() {
		return col_title;
	}
	public void setCol_title(String col_title) {
		this.col_title = col_title;
	}
	public String getDept_title() {
		return dept_title;
	}
	public void setDept_title(String dept_title) {
		this.dept_title = dept_title;
	}
	public String getRenounceSubject() {
		return renounceSubject;
	}
	public void setRenounceSubject(String renounceSubject) {
		this.renounceSubject = renounceSubject;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public String getGrade_code() {
		return grade_code;
	}
	public void setGrade_code(String grade_code) {
		this.grade_code = grade_code;
	}
	public String getReco_score() {
		return reco_score;
	}
	public void setReco_score(String reco_score) {
		this.reco_score = reco_score;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	public String getApply_approve() {
		return apply_approve;
	}
	public void setApply_approve(String apply_approve) {
		this.apply_approve = apply_approve;
	}
	
}
