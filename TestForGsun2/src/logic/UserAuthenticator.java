package logic;

import dbms.UsersDbHandler;
import objects.*;

public class UserAuthenticator {
	
	/**
	 * authenticate an admin user
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public boolean authenticate(Administrator admin) throws Exception{
		boolean isValid=false;
		
		
		
		return isValid;
	}
	
	/**
	 * authenticate an android phone user
	 * @param androidUser
	 * @return
	 * @throws Exception
	 */
	public boolean authenticate(AndroidUser androidUser) throws Exception{
		boolean isValid=false;
		
		UsersDbHandler userDbh=new UsersDbHandler();
		
		if(userDbh.getAndroidUser(androidUser)!=null) isValid=true;
		
		return isValid;
	}

}
