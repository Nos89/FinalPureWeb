package kh.spring.dto;

public class Lecture {
	private String lec_code;
	private String lec_title;
	private String pro_id;
	private String lec_divideclass;
	private int lec_totalnum;
	private int lec_approval;
	private int lec_close;
	private String lec_devideway;
	private String pro_name;
	private String pro_deptcode;
	private String pro_office;
	private String pro_phone;
	private String lec_year;
	private int lec_semester;
	private String lec_targetLevel;
	private String lec_classroom;
	private String lec_time;
	private String build_code;
	private String lec_day;
	private int lec_credit;
	private String lec_isucode;
	private String lec_summary;
	private String lec_way;
	private String lec_book;
	private String lec_eval;
	
	
	public Lecture(String lec_code, String lec_title, String pro_id, String lec_divideclass, int lec_totalnum,
			int lec_approval, int lec_close, String lec_devideway, String pro_name, String pro_deptcode,
			String pro_office, String pro_phone, String lec_year, int lec_semester, String lec_targetLevel,
			String lec_classroom, String lec_time, String build_code, String lec_day, int lec_credit,
			String lec_isucode, String lec_summary, String lec_way, String lec_book, String lec_eval) {
		super();
		this.lec_code = lec_code;
		this.lec_title = lec_title;
		this.pro_id = pro_id;
		this.lec_divideclass = lec_divideclass;
		this.lec_totalnum = lec_totalnum;
		this.lec_approval = lec_approval;
		this.lec_close = lec_close;
		this.lec_devideway = lec_devideway;
		this.pro_name = pro_name;
		this.pro_deptcode = pro_deptcode;
		this.pro_office = pro_office;
		this.pro_phone = pro_phone;
		this.lec_year = lec_year;
		this.lec_semester = lec_semester;
		this.lec_targetLevel = lec_targetLevel;
		this.lec_classroom = lec_classroom;
		this.lec_time = lec_time;
		this.build_code = build_code;
		this.lec_day = lec_day;
		this.lec_credit = lec_credit;
		this.lec_isucode = lec_isucode;
		this.lec_summary = lec_summary;
		this.lec_way = lec_way;
		this.lec_book = lec_book;
		this.lec_eval = lec_eval;
	}
	public Lecture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getLec_divideclass() {
		return lec_divideclass;
	}
	public void setLec_divideclass(String lec_divideclass) {
		this.lec_divideclass = lec_divideclass;
	}
	public int getLec_totalnum() {
		return lec_totalnum;
	}
	public void setLec_totalnum(int lec_totalnum) {
		this.lec_totalnum = lec_totalnum;
	}
	public int getLec_approval() {
		return lec_approval;
	}
	public void setLec_approval(int lec_approval) {
		this.lec_approval = lec_approval;
	}
	public int getLec_close() {
		return lec_close;
	}
	public void setLec_close(int lec_close) {
		this.lec_close = lec_close;
	}
	public String getLec_devideway() {
		return lec_devideway;
	}
	public void setLec_devideway(String lec_devideway) {
		this.lec_devideway = lec_devideway;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_deptcode() {
		return pro_deptcode;
	}
	public void setPro_deptcode(String pro_deptcode) {
		this.pro_deptcode = pro_deptcode;
	}
	public String getPro_office() {
		return pro_office;
	}
	public void setPro_office(String pro_office) {
		this.pro_office = pro_office;
	}
	public String getPro_phone() {
		return pro_phone;
	}
	public void setPro_phone(String pro_phone) {
		this.pro_phone = pro_phone;
	}
	public String getLec_year() {
		return lec_year;
	}
	public void setLec_year(String lec_year) {
		this.lec_year = lec_year;
	}
	public int getLec_semester() {
		return lec_semester;
	}
	public void setLec_semester(int lec_semester) {
		this.lec_semester = lec_semester;
	}
	public String getLec_targetLevel() {
		return lec_targetLevel;
	}
	public void setLec_targetLevel(String lec_targetLevel) {
		this.lec_targetLevel = lec_targetLevel;
	}
	public String getLec_classroom() {
		return lec_classroom;
	}
	public void setLec_classroom(String lec_classroom) {
		this.lec_classroom = lec_classroom;
	}
	public String getLec_time() {
		return lec_time;
	}
	public void setLec_time(String lec_time) {
		this.lec_time = lec_time;
	}
	public String getBuild_code() {
		return build_code;
	}
	public void setBuild_code(String build_code) {
		this.build_code = build_code;
	}
	public String getLec_day() {
		return lec_day;
	}
	public void setLec_day(String lec_day) {
		this.lec_day = lec_day;
	}
	public int getLec_credit() {
		return lec_credit;
	}
	public void setLec_credit(int lec_credit) {
		this.lec_credit = lec_credit;
	}
	public String getLec_isucode() {
		return lec_isucode;
	}
	public void setLec_isucode(String lec_isucode) {
		this.lec_isucode = lec_isucode;
	}
	public String getLec_summary() {
		return lec_summary;
	}
	public void setLec_summary(String lec_summary) {
		this.lec_summary = lec_summary;
	}
	public String getLec_way() {
		return lec_way;
	}
	public void setLec_way(String lec_way) {
		this.lec_way = lec_way;
	}
	public String getLec_book() {
		return lec_book;
	}
	public void setLec_book(String lec_book) {
		this.lec_book = lec_book;
	}
	public String getLec_eval() {
		return lec_eval;
	}
	public void setLec_eval(String lec_eval) {
		this.lec_eval = lec_eval;
	}
	
	

}
