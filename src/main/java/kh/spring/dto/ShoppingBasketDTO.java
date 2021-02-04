package kh.spring.dto;

public class ShoppingBasketDTO {
	private int shop_seq;
	private String id;
	private String lec_code;
	public ShoppingBasketDTO(int shop_seq, String id, String lec_code) {
		super();
		this.shop_seq = shop_seq;
		this.id = id;
		this.lec_code = lec_code;
	}
	public ShoppingBasketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getShop_seq() {
		return shop_seq;
	}
	public void setShop_seq(int shop_seq) {
		this.shop_seq = shop_seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	
	
	

}
