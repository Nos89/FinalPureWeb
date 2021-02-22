package kh.spring.dto;

public class MyMenuDTO2 {
	private String MENU_CD;
	private String UP_MENU_CD;
	private String MENU_NM;
	private String MENU_LVL;
	private String PGM_PATH;
	private String PGM_ID;
	public MyMenuDTO2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyMenuDTO2(String mENU_CD, String uP_MENU_CD, String mENU_NM, String mENU_LVL, String pGM_PATH,
			String pGM_ID) {
		super();
		MENU_CD = mENU_CD;
		UP_MENU_CD = uP_MENU_CD;
		MENU_NM = mENU_NM;
		MENU_LVL = mENU_LVL;
		PGM_PATH = pGM_PATH;
		PGM_ID = pGM_ID;
	}
	public String getMENU_CD() {
		return MENU_CD;
	}
	public void setMENU_CD(String mENU_CD) {
		MENU_CD = mENU_CD;
	}
	public String getUP_MENU_CD() {
		return UP_MENU_CD;
	}
	public void setUP_MENU_CD(String uP_MENU_CD) {
		UP_MENU_CD = uP_MENU_CD;
	}
	public String getMENU_NM() {
		return MENU_NM;
	}
	public void setMENU_NM(String mENU_NM) {
		MENU_NM = mENU_NM;
	}
	public String getMENU_LVL() {
		return MENU_LVL;
	}
	public void setMENU_LVL(String mENU_LVL) {
		MENU_LVL = mENU_LVL;
	}
	public String getPGM_PATH() {
		return PGM_PATH;
	}
	public void setPGM_PATH(String pGM_PATH) {
		PGM_PATH = pGM_PATH;
	}
	public String getPGM_ID() {
		return PGM_ID;
	}
	public void setPGM_ID(String pGM_ID) {
		PGM_ID = pGM_ID;
	}
	
}
