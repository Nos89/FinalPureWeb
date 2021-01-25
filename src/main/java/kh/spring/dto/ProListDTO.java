package kh.spring.dto;

import java.sql.Date;

public class ProListDTO {
	private String id;
	private String name;
	private Date birth;
	private String gender;
	private String country;
	private String email;
	private String phone;
	private String pro_office;
	public ProListDTO(String id, String name, Date birth, String gender, String country, String email, String phone,
			String pro_office) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.pro_office = pro_office;
	}
	public ProListDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPro_office() {
		return pro_office;
	}
	public void setPro_office(String pro_office) {
		this.pro_office = pro_office;
	}
	
	
	
}
