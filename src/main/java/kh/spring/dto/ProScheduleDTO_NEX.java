package kh.spring.dto;


public class ProScheduleDTO_NEX {
	private int sche_seq;
	private String sche_proId;
	private String sche_proName;
	private String sche_contents;
	private String sche_date;
	private String sche_title;
	private String sche_type;
	private String check = "0";
	public ProScheduleDTO_NEX(int sche_seq, String sche_proId, String sche_proName, String sche_contents,
			String sche_date, String sche_title, String sche_type, String check) {
		super();
		this.sche_seq = sche_seq;
		this.sche_proId = sche_proId;
		this.sche_proName = sche_proName;
		this.sche_contents = sche_contents;
		this.sche_date = sche_date;
		this.sche_title = sche_title;
		this.sche_type = sche_type;
		this.check = check;
	}
	public int getSche_seq() {
		return sche_seq;
	}
	public void setSche_seq(int sche_seq) {
		this.sche_seq = sche_seq;
	}
	public String getSche_proId() {
		return sche_proId;
	}
	public void setSche_proId(String sche_proId) {
		this.sche_proId = sche_proId;
	}
	public String getSche_proName() {
		return sche_proName;
	}
	public void setSche_proName(String sche_proName) {
		this.sche_proName = sche_proName;
	}
	public String getSche_contents() {
		return sche_contents;
	}
	public void setSche_contents(String sche_contents) {
		this.sche_contents = sche_contents;
	}
	public String getSche_date() {
		return sche_date;
	}
	public void setSche_date(String sche_date) {
		this.sche_date = sche_date;
	}
	public String getSche_title() {
		return sche_title;
	}
	public void setSche_title(String sche_title) {
		this.sche_title = sche_title;
	}
	public String getSche_type() {
		return sche_type;
	}
	public void setSche_type(String sche_type) {
		this.sche_type = sche_type;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public ProScheduleDTO_NEX() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
