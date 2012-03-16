package com.gsun.objects;

public class AndroidUser extends User {
	


	private final String longitude;
	private final String latitude;

	public AndroidUser(String user_id,String username, String password, String email,
			String discription,String longitude,String latitude) {
		super(user_id,username, password, email, discription);
		// TODO Auto-generated constructor stub
		this.latitude=latitude;
		this.longitude=longitude;
		
	}

	/* (non-Javadoc)
	 * @see objects.User#getDiscription()
	 */
	@Override
	public String getDiscription() {
		// TODO Auto-generated method stub
		return super.getDiscription();
	}

	/* (non-Javadoc)
	 * @see objects.User#getEmail()
	 */
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	/* (non-Javadoc)
	 * @see objects.User#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	/* (non-Javadoc)
	 * @see objects.User#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
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
