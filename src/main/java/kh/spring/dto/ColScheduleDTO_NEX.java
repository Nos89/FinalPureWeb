package kh.spring.dto;

public class ColScheduleDTO_NEX {
	private int seq;
	private String title;
	private String contents;
	private String sche_startDate;
	private String sche_endDate;
	private String type;
	
	public ColScheduleDTO_NEX() {
		super();
	}

	public ColScheduleDTO_NEX(int seq, String title, String contents, String sche_startDate, String sche_endDate,
			String type) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.sche_startDate = sche_startDate;
		this.sche_endDate = sche_endDate;
		this.type = type;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSche_startDate() {
		return sche_startDate;
	}

	public void setSche_startDate(String sche_startDate) {
		this.sche_startDate = sche_startDate;
	}

	public String getSche_endDate() {
		return sche_endDate;
	}

	public void setSche_endDate(String sche_endDate) {
		this.sche_endDate = sche_endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
