package test2;

import java.io.Serializable;

public class Entry implements Serializable{
	
	private final String need;
	private final String type;
	private final String longitude;
	private final String latitude;
	private  String shop_id="";
	/**
	 * @param need
	 * @param type
	 * @param longitude
	 * @param latitude
	 */
	public Entry(String need, String type, String longitude, String latitude) {
		
		this.need = need;
		this.type = type;
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
	 * @param shop_id the shop_id to set
	 */
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	/**
	 * @return the need
	 */
	public String getNeed() {
		return need;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
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
	
	

}
