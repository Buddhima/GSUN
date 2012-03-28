package networkIf;

import com.google.gson.Gson;

import logic.EntryHandler;
import logic.ExternalRequestHandler;

import objects.AndroidUser;

import objects.Entry;

public class AndroidDataHandler {
	
	/**
	 * return a list of shops that exactly matches user needs
	 * @param entry
	 * @param range
	 * @return
	 * 
	 */
	/*public List<Shop> giveResultList(Entry entry, int range) throws Exception{
		EntryHandler eh=new EntryHandler();
		return eh.prepareResultList(entry, range);
	}*/
	
	public String giveResultList(String entryString, int range) {
		String resultString=null;
		try{
		EntryHandler eh=new EntryHandler();
		Entry entry=new Gson().fromJson(entryString, Entry.class);
		resultString=new Gson().toJson(eh.prepareResultList(entry, range));
		}catch(Exception e){
			
		}
		return resultString;
	}

	/**
	 * return a list of shops that could be suggested from user need
	 * @param entry
	 * @param range
	 * @return
	 * 
	 */
	/*public List<Shop> giveSuggestionList(Entry entry, int range) throws Exception{
		EntryHandler eh=new EntryHandler();
		return eh.prepareSuggestionList(entry, range);
	}*/
     
	public String giveSuggestionList(String entryString, int range) {
		
		String suggestionString=null;
		try{
		EntryHandler eh=new EntryHandler();
		Entry entry=new Gson().fromJson(entryString, Entry.class);
		suggestionString=new Gson().toJson(eh.prepareSuggestionList(entry, range));
		}catch(Exception e){}
		
		
		return suggestionString;
	}
	
	
	/**
	 * This method gives a list of needs that are available in dictionary table for Android app list
	 * @return String
	 */
	public String giveAllNeeds(){
		
		ExternalRequestHandler exthdl=new ExternalRequestHandler();
		
		String needListString=new Gson().toJson(exthdl.getAllNeeds());
		
		System.out.println(needListString);
		
		return needListString;
	}
        
       /**
	 * this method authenticate an Android user in the system
	 * @param androidUser
	 */
        /*public boolean authenticate(AndroidUser androidUser) {
        Authenticator auth=new Authenticator();
        return auth.authenticate(androidUser);
        }*/
        
        public boolean authenticate(String androidUserString) {
            Authenticator auth=new Authenticator();
            AndroidUser androidUser=new Gson().fromJson(androidUserString, AndroidUser.class);
            return auth.authenticate(androidUser);
            }
	
}
