package kh.spring.dto;

public class MyMenuDTO {
	private String menu_cd;
	private String up_menu_cd;
	private String menu_nm;
	private String menu_lvl;
	private String pgm_path;
	private String pgm_id;
	public MyMenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyMenuDTO(String menu_cd, String up_menu_cd, String menu_nm, String menu_lvl, String pgm_path,
			String pgm_id) {
		super();
		this.menu_cd = menu_cd;
		this.up_menu_cd = up_menu_cd;
		this.menu_nm = menu_nm;
		this.menu_lvl = menu_lvl;
		this.pgm_path = pgm_path;
		this.pgm_id = pgm_id;
	}
	public String getMenu_cd() {
		return menu_cd;
	}
	public void setMenu_cd(String menu_cd) {
		this.menu_cd = menu_cd;
	}
	public String getUp_menu_cd() {
		return up_menu_cd;
	}
	public void setUp_menu_cd(String up_menu_cd) {
		this.up_menu_cd = up_menu_cd;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getMenu_lvl() {
		return menu_lvl;
	}
	public void setMenu_lvl(String menu_lvl) {
		this.menu_lvl = menu_lvl;
	}
	public String getPgm_path() {
		return pgm_path;
	}
	public void setPgm_path(String pgm_path) {
		this.pgm_path = pgm_path;
	}
	public String getPgm_id() {
		return pgm_id;
	}
	public void setPgm_id(String pgm_id) {
		this.pgm_id = pgm_id;
	}
	
	
}
