package kh.spring.dto;

public class CloudStorageDTO {
	private String id;
	private String name;
	private int maxStorage;
	
	
	public CloudStorageDTO() {
		super();
	}

	public CloudStorageDTO(String id, String name, int maxStorage) {
		super();
		this.id = id;
		this.name = name;
		this.maxStorage = maxStorage;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxStorage() {
		return maxStorage;
	}
	public void setMaxStorage(int maxStorage) {
		this.maxStorage = maxStorage;
	}
}
