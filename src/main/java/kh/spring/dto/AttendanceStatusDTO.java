package kh.spring.dto;

public class AttendanceStatusDTO {
	private String att_lecCode;
	private String att_deptName;
	private String att_stdId;
	private String att_stdLevel;
	private String att_stdName;
	private int attend;
	private int late;
	private int absent;
	public AttendanceStatusDTO(String att_lecCode, String att_deptName, String att_stdLevel, String att_stdId,
			String att_stdName, int attend, int late, int absent) {
		super();
		this.att_lecCode = att_lecCode;
		this.att_deptName = att_deptName;
		this.att_stdLevel = att_stdLevel;
		this.att_stdId = att_stdId;
		this.att_stdName = att_stdName;
		this.attend = attend;
		this.late = late;
		this.absent = absent;
	}
	public AttendanceStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAtt_lecCode() {
		return att_lecCode;
	}
	public void setAtt_lecCode(String att_lecCode) {
		this.att_lecCode = att_lecCode;
	}
	public String getAtt_deptName() {
		return att_deptName;
	}
	public void setAtt_deptName(String att_deptName) {
		this.att_deptName = att_deptName;
	}
	public String getAtt_stdLevel() {
		return att_stdLevel;
	}
	public void setAtt_stdLevel(String att_stdLevel) {
		this.att_stdLevel = att_stdLevel;
	}
	public String getAtt_stdId() {
		return att_stdId;
	}
	public void setAtt_stdId(String att_stdId) {
		this.att_stdId = att_stdId;
	}
	public String getAtt_stdName() {
		return att_stdName;
	}
	public void setAtt_stdName(String att_stdName) {
		this.att_stdName = att_stdName;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	
	
	
	
}
