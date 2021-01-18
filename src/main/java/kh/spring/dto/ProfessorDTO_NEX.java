package kh.spring.dto;

import java.util.Date;

public class ProfessorDTO_NEX  {
	private String id;
	private String pw;
	private String name;
	private Date birth;
	private String gender;
	private String country;
	private Date inDate;
	private Date outDate;
	private String col_title; //코드로 가져온 대학이름
	private String dept_title; //코드로 가져온 과 이름
	private String zipcode;
	private String addr1;
	private String addr2;
	private String email;
	private String phone;
	private String bank;
	private String accountnum;
	public ProfessorDTO_NEX(String id, String pw, String name, java.util.Date birth, String gender, String country,
			java.util.Date inDate, java.util.Date outDate, String col_title, String dept_title, String zipcode,
			String addr1, String addr2, String email, String phone, String bank, String accountnum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.country = country;
		this.inDate = inDate;
		this.outDate = outDate;
		this.col_title = col_title;
		this.dept_title = dept_title;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.email = email;
		this.phone = phone;
		this.bank = bank;
		this.accountnum = accountnum;
	}
	public ProfessorDTO_NEX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public java.util.Date getInDate() {
		return inDate;
	}
	public void setInDate(java.util.Date inDate) {
		this.inDate = inDate;
	}
	public java.util.Date getOutDate() {
		return outDate;
	}
	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	
	public void setUtilDate(java.sql.Date date) {
		this.birth = new java.util.Date(date.getTime());
	}
	
}
