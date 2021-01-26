package kh.spring.dto;

public class DepartmentOfficeDTO {
	private String ofi_code;
	private String ofi_name;
	private String ofi_contact;
	private String ofi_location;
	public DepartmentOfficeDTO(String ofi_code, String ofi_name, String ofi_contact, String ofi_location) {
		super();
		this.ofi_code = ofi_code;
		this.ofi_name = ofi_name;
		this.ofi_contact = ofi_contact;
		this.ofi_location = ofi_location;
	}
	public DepartmentOfficeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOfi_code() {
		return ofi_code;
	}
	public void setOfi_code(String ofi_code) {
		this.ofi_code = ofi_code;
	}
	public String getOfi_name() {
		return ofi_name;
	}
	public void setOfi_name(String ofi_name) {
		this.ofi_name = ofi_name;
	}
	public String getOfi_contact() {
		return ofi_contact;
	}
	public void setOfi_contact(String ofi_contact) {
		this.ofi_contact = ofi_contact;
	}
	public String getOfi_location() {
		return ofi_location;
	}
	public void setOfi_location(String ofi_location) {
		this.ofi_location = ofi_location;
	}
	
}
