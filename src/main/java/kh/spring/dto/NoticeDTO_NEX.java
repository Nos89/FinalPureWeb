package kh.spring.dto;

public class NoticeDTO_NEX {
	private int chk=0;
	private int rank;
	private int noti_seq;
	private String noti_title;
	private String noti_contents;
	private String noti_writeDate;
	private String category;
	
	public NoticeDTO_NEX() {
		super();
	}
	public NoticeDTO_NEX(int chk, int rank, int noti_seq, String noti_title, String noti_contents,
			String noti_writeDate, String category) {
		super();
		this.chk = chk;
		this.rank = rank;
		this.noti_seq = noti_seq;
		this.noti_title = noti_title;
		this.noti_contents = noti_contents;
		this.noti_writeDate = noti_writeDate;
		this.category = category;
	}
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getNoti_seq() {
		return noti_seq;
	}
	public void setNoti_seq(int noti_seq) {
		this.noti_seq = noti_seq;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getNoti_contents() {
		return noti_contents;
	}
	public void setNoti_contents(String noti_contents) {
		this.noti_contents = noti_contents;
	}
	public String getNoti_writeDate() {
		return noti_writeDate;
	}
	public void setNoti_writeDate(String noti_writeDate) {
		this.noti_writeDate = noti_writeDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
