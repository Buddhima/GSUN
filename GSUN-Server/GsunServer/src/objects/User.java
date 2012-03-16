package objects;

import java.io.Serializable;

public abstract class User implements Serializable{

	final String user_id;
	final String username;
	final String password;
	final String email;
	final String discription;

	public User(String user_id,String username, String password, String email,
			String discription) {

		this.user_id=user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.discription = discription;
	}
	
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @return the discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

}
