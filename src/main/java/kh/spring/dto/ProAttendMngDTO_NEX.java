package kh.spring.dto;

import java.util.Date;

public class ProAttendMngDTO_NEX {
	private int att_seq;
	private String att_lecCode;
	private String att_year;
	private String att_targetLevel;
	private	String att_semester;
	private String att_lecTitle;
	private String att_date;
	private String att_attend;
	private String att_stdId;
	private String att_deptName;
	private String att_stdName;
	private String att_stdLevel;
	private int att_week;
	public ProAttendMngDTO_NEX(int att_seq, String att_lecCode, String att_year, String att_targetLevel,
			String att_semester, String att_lecTitle, String att_date, String att_attend, String att_stdId,
			String att_deptName, String att_stdName, String att_stdLevel, int att_week) {
		super();
		this.att_seq = att_seq;
		this.att_lecCode = att_lecCode;
		this.att_year = att_year;
		this.att_targetLevel = att_targetLevel;
		this.att_semester = att_semester;
		this.att_lecTitle = att_lecTitle;
		this.att_date = att_date;
		this.att_attend = att_attend;
		this.att_stdId = att_stdId;
		this.att_deptName = att_deptName;
		this.att_stdName = att_stdName;
		this.att_stdLevel = att_stdLevel;
		this.att_week = att_week;
	}
	public ProAttendMngDTO_NEX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAtt_seq() {
		return att_seq;
	}
	public void setAtt_seq(int att_seq) {
		this.att_seq = att_seq;
	}
	public String getAtt_lecCode() {
		return att_lecCode;
	}
	public void setAtt_lecCode(String att_lecCode) {
		this.att_lecCode = att_lecCode;
	}
	public String getAtt_year() {
		return att_year;
	}
	public void setAtt_year(String att_year) {
		this.att_year = att_year;
	}
	public String getAtt_targetLevel() {
		return att_targetLevel;
	}
	public void setAtt_targetLevel(String att_targetLevel) {
		this.att_targetLevel = att_targetLevel;
	}
	public String getAtt_semester() {
		return att_semester;
	}
	public void setAtt_semester(String att_semester) {
		this.att_semester = att_semester;
	}
	public String getAtt_lecTitle() {
		return att_lecTitle;
	}
	public void setAtt_lecTitle(String att_lecTitle) {
		this.att_lecTitle = att_lecTitle;
	}
	public String getAtt_date() {
		return att_date;
	}
	public void setAtt_date(String att_date) {
		this.att_date = att_date;
	}
	public String getAtt_attend() {
		return att_attend;
	}
	public void setAtt_attend(String att_attend) {
		this.att_attend = att_attend;
	}
	public String getAtt_stdId() {
		return att_stdId;
	}
	public void setAtt_stdId(String att_stdId) {
		this.att_stdId = att_stdId;
	}
	public String getAtt_deptName() {
		return att_deptName;
	}
	public void setAtt_deptName(String att_deptName) {
		this.att_deptName = att_deptName;
	}
	public String getAtt_stdName() {
		return att_stdName;
	}
	public void setAtt_stdName(String att_stdName) {
		this.att_stdName = att_stdName;
	}
	public String getAtt_stdLevel() {
		return att_stdLevel;
	}
	public void setAtt_stdLevel(String att_stdLevel) {
		this.att_stdLevel = att_stdLevel;
	}
	public int getAtt_week() {
		return att_week;
	}
	public void setAtt_week(int att_week) {
		this.att_week = att_week;
	}
	
	

}
