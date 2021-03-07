package kh.spring.dto;

import java.sql.Date;

public class ProfessorDTO {
	private int chk=0;
	private String id;
	private String pw;
	private String name;
	private Date birth;
	private String gender;
	private String country;
	private Date inDate;
	private Date outDate;
	private String colcode;
	private String deptcode;
	private String col_title; //코드로 가져온 대학이름
	private String dept_title; //코드로 가져온 과 이름
	private String zipcode;
	private String addr1;
	private String addr2;
	private String email;
	private String phone;
	private String bank;
	private String accountnum;
	private String pro_office;
	private String pro_status;
	public ProfessorDTO(int chk, String id, String pw, String name, Date birth, String gender, String country,
			Date inDate, Date outDate, String colcode, String deptcode, String col_title, String dept_title,
			String zipcode, String addr1, String addr2, String email, String phone, String bank, String accountnum,
			String pro_office, String pro_status) {
		super();
		this.chk = chk;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.country = country;
		this.inDate = inDate;
		this.outDate = outDate;
		this.colcode = colcode;
		this.deptcode = deptcode;
		this.col_title = col_title;
		this.dept_title = dept_title;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.email = email;
		this.phone = phone;
		this.bank = bank;
		this.accountnum = accountnum;
		this.pro_office = pro_office;
		this.pro_status = pro_status;
	}
	public ProfessorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
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
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getColcode() {
		return colcode;
	}
	public void setColcode(String colcode) {
		this.colcode = colcode;
	}
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
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
	public String getPro_office() {
		return pro_office;
	}
	public void setPro_office(String pro_office) {
		this.pro_office = pro_office;
	}
	public String getPro_status() {
		return pro_status;
	}
	public void setPro_status(String pro_status) {
		this.pro_status = pro_status;
	}
	
	
}
