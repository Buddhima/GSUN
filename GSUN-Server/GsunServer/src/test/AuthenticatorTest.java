package test;

import static org.junit.Assert.*;

import networkIf.AndroidDataHandler;
import networkIf.Authenticator;

import objects.AndroidUser;

import org.junit.Test;

public class AuthenticatorTest {

	/**
	 * Test case for testing Android users
	 * 
	 */
	@Test
	public void testAuthenticateAndroidUser() {
		 Authenticator auth=new Authenticator();
         
      
         
         AndroidUser anUser=new AndroidUser("", "asd", "asd", "asd", "asd", "asd", "asd");
         
         assertTrue(auth.authenticate(anUser));
         
       
	}

}
