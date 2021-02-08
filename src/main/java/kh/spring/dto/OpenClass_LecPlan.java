package kh.spring.dto;

import java.sql.Date;

public class OpenClass_LecPlan {
	private String oc_code;
	private Date oc_year;
	private String oc_semester;
	private String oc_schedule;
	private int oc_max;
	private int oc_part;
	private String oc_is_close;
	private String oc_close_reason;
	private String oc_pro_code;
	private String oc_class_room;
	private String oc_targetlevel;
	private String name;
	private int reco_score;
	private String isu;
	private String dept_code;
	private String col_code;
	public OpenClass_LecPlan(String oc_code, Date oc_year, String oc_semester, String oc_schedule, int oc_max,
			int oc_part, String oc_is_close, String oc_close_reason, String oc_pro_code, String oc_class_room,
			String oc_targetlevel, String name, int reco_score, String isu, String dept_code, String col_code) {
		super();
		this.oc_code = oc_code;
		this.oc_year = oc_year;
		this.oc_semester = oc_semester;
		this.oc_schedule = oc_schedule;
		this.oc_max = oc_max;
		this.oc_part = oc_part;
		this.oc_is_close = oc_is_close;
		this.oc_close_reason = oc_close_reason;
		this.oc_pro_code = oc_pro_code;
		this.oc_class_room = oc_class_room;
		this.oc_targetlevel = oc_targetlevel;
		this.name = name;
		this.reco_score = reco_score;
		this.isu = isu;
		this.dept_code = dept_code;
		this.col_code = col_code;
	}
	public OpenClass_LecPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOc_code() {
		return oc_code;
	}
	public void setOc_code(String oc_code) {
		this.oc_code = oc_code;
	}
	public Date getOc_year() {
		return oc_year;
	}
	public void setOc_year(Date oc_year) {
		this.oc_year = oc_year;
	}
	public String getOc_semester() {
		return oc_semester;
	}
	public void setOc_semester(String oc_semester) {
		this.oc_semester = oc_semester;
	}
	public String getOc_schedule() {
		return oc_schedule;
	}
	public void setOc_schedule(String oc_schedule) {
		this.oc_schedule = oc_schedule;
	}
	public int getOc_max() {
		return oc_max;
	}
	public void setOc_max(int oc_max) {
		this.oc_max = oc_max;
	}
	public int getOc_part() {
		return oc_part;
	}
	public void setOc_part(int oc_part) {
		this.oc_part = oc_part;
	}
	public String getOc_is_close() {
		return oc_is_close;
	}
	public void setOc_is_close(String oc_is_close) {
		this.oc_is_close = oc_is_close;
	}
	public String getOc_close_reason() {
		return oc_close_reason;
	}
	public void setOc_close_reason(String oc_close_reason) {
		this.oc_close_reason = oc_close_reason;
	}
	public String getOc_pro_code() {
		return oc_pro_code;
	}
	public void setOc_pro_code(String oc_pro_code) {
		this.oc_pro_code = oc_pro_code;
	}
	public String getOc_class_room() {
		return oc_class_room;
	}
	public void setOc_class_room(String oc_class_room) {
		this.oc_class_room = oc_class_room;
	}
	public String getOc_targetlevel() {
		return oc_targetlevel;
	}
	public void setOc_targetlevel(String oc_targetlevel) {
		this.oc_targetlevel = oc_targetlevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReco_score() {
		return reco_score;
	}
	public void setReco_score(int reco_score) {
		this.reco_score = reco_score;
	}
	public String getIsu() {
		return isu;
	}
	public void setIsu(String isu) {
		this.isu = isu;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getCol_code() {
		return col_code;
	}
	public void setCol_code(String col_code) {
		this.col_code = col_code;
	}
	
	
	
	
}
