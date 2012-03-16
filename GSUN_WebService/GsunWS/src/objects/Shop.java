package objects;

import java.io.Serializable;

public class Shop implements Serializable{

	private final String shop_id;
	private final String shop_name;
	
	private final String address;
	private final String telephone_no;
	private final String email;
	private final String discription;
	
	private final String longitude;
	private final String latitude;
	
	private String need_type;
	
	public Shop(String shop_id, String shop_name,
			String longitude, String latitude, String address,
			String telephone_no, String email, String discription) {
		
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.address = address;
		this.telephone_no = telephone_no;
		this.email = email;
		this.discription = discription;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * @return the shop_id
	 */
	public String getShop_id() {
		return shop_id;
	}

	/**
	 * @return the shop_name
	 */
	public String getShop_name() {
		return shop_name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the telephone_no
	 */
	public String getTelephone_no() {
		return telephone_no;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @return the need_type
	 */
	public String getNeed_type() {
		return need_type;
	}

	/**
	 * @param need_type the need_type to set
	 */
	public void setNeed_type(String need_type) {
		this.need_type = need_type;
	}
	
	
	
	
}
