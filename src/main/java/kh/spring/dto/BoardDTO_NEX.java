package kh.spring.dto;


public class BoardDTO_NEX {
	private int chk=0;
	private int rank;
	private int seq;
	private String title;
	private String contents;
	private String writer;
	private String writeDate;
	private String boardType;
	
	public BoardDTO_NEX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDTO_NEX(int chk, int rank, int seq, String title, String contents, String writer, String writeDate,
			String boardType) {
		super();
		this.chk = chk;
		this.rank = rank;
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
		this.boardType = boardType;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	
}
