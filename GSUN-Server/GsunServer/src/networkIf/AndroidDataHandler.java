package networkIf;

import java.util.List;

import logic.EntryHandler;
import objects.AndroidUser;

import objects.Entry;
import objects.Shop;

public class AndroidDataHandler {
	
	/**
	 * return a list of shops that exactly matches user needs
	 * @param entry
	 * @param range
	 * @return
	 * @throws Exception
	 */
	public List<Shop> giveResultList(Entry entry, int range) throws Exception{
		EntryHandler eh=new EntryHandler();
		return eh.prepareResultList(entry, range);
	}

	/**
	 * return a list of shops that could be suggested from user need
	 * @param entry
	 * @param range
	 * @return
	 * @throws Exception
	 */
	public List<Shop> giveSuggestionList(Entry entry, int range) throws Exception{
		EntryHandler eh=new EntryHandler();
		return eh.prepareSuggestionList(entry, range);
	}
        
        
       /**
	 * this method authenticate an Android user in the system
	 * @param androidUser
	 */
        public boolean authenticate(AndroidUser androidUser) {
        Authenticator auth=new Authenticator();
        
        return auth.authenticate(androidUser);
        
        }
	
}
