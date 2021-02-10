package kh.spring.dto;

public class ClassroomDTO {
	
	private String build_code;
	private String room_num;
	private int room_max;
	private String room_use;
	
	public ClassroomDTO() {
		super();
	}
	public ClassroomDTO(String build_code, String room_num, int room_max, String room_use) {
		super();
		this.build_code = build_code;
		this.room_num = room_num;
		this.room_max = room_max;
		this.room_use = room_use;
	}
	
	public String getBuild_code() {
		return build_code;
	}
	public void setBuild_code(String build_code) {
		this.build_code = build_code;
	}
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	public int getRoom_max() {
		return room_max;
	}
	public void setRoom_max(int room_max) {
		this.room_max = room_max;
	}
	public String getRoom_use() {
		return room_use;
	}
	public void setRoom_use(String room_use) {
		this.room_use = room_use;
	}
}
