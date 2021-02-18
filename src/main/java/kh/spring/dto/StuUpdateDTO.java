package kh.spring.dto;

public class StuUpdateDTO {
	private String bank;
	private String accountnum;
	private String phone;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String email;
	public StuUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StuUpdateDTO(String bank, String accountnum, String phone, String zipcode, String addr1, String addr2,
			String email) {
		super();
		this.bank = bank;
		this.accountnum = accountnum;
		this.phone = phone;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	
}
