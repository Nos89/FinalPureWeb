package kh.spring.dto;

public class RoomInfoDTO {
	private String build_name;
	private String room_num;
	private String room_use;
	private int room_max;
	public RoomInfoDTO() {}
	public RoomInfoDTO(String build_name, String room_num, String room_use, int room_max) {
		super();
		this.build_name = build_name;
		this.room_num = room_num;
		this.room_use = room_use;
		this.room_max = room_max;
	}
	public String getBuild_name() {
		return build_name;
	}
	public void setBuild_name(String build_name) {
		this.build_name = build_name;
	}
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	public String getRoom_use() {
		return room_use;
	}
	public void setRoom_use(String room_use) {
		this.room_use = room_use;
	}
	public int getRoom_max() {
		return room_max;
	}
	public void setRoom_max(int room_max) {
		this.room_max = room_max;
	}
	
	
}
