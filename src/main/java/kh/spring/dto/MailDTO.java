package kh.spring.dto;

import java.sql.Date;

public class MailDTO {
	private int mail_seq;
	private String receiver;
	private String title;
	private String contents;
	private Date received_date;
	private int read;
	private String sender;
	
	public MailDTO() {
		super();
	}

	public MailDTO(int mail_seq, String receiver, String title, String contents, Date received_date, int read, String sender) {
		super();
		this.mail_seq = mail_seq;
		this.receiver = receiver;
		this.title = title;
		this.contents = contents;
		this.received_date = received_date;
		this.read = read;
		this.sender = sender;
	}

	public int getMail_seq() {
		return mail_seq;
	}

	public void setMail_seq(int mail_seq) {
		this.mail_seq = mail_seq;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public Date getReceived_date() {
		return received_date;
	}

	public void setReceived_date(Date received_date) {
		this.received_date = received_date;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
}
