package test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.AndroidUser;
import networkIf.*;
import objects.Entry;
import objects.Shop;

public class TestServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
            // TODO Auto-generated method stub

            
            // authenticating user test
            Authenticator auth=new Authenticator();
            
            AndroidDataHandler result=new AndroidDataHandler();
            
            AndroidUser anUser=new AndroidUser("", "asd", "asd", "asd", "asd", "asd", "asd");
            
            System.out.println("Validate android user:"+auth.authenticate(anUser));
            
            
            // input from android phone
            
            Entry entry=new Entry("paper", "", "87", "456");
                         
            List<Shop> resultsList= result.giveResultList(entry, 1000);
            
            System.out.println("Matching for needs:\n");
            for(Shop sh:resultsList){
                System.out.println(sh.getShop_name()+" "+sh.getLatitude()+" "+sh.getLongitude());
            }
            
            // test - data from web site
            WebDataHandler webdh=new WebDataHandler();
            
            Shop shop1=new Shop("", "XBC Shop", "23.23", "45.76", "324,FDS road, colombo", "+4350243", "wer@fds.sdf", "Distributing food products");
            shop1.setNeed_type("paper,stationary:pen,stationary:ink,stationary");
            
            webdh.addShopTemp(shop1);
            //webdh.addShopTemp(shop1);
           // webdh.addShopTemp(shop1);
           // webdh.addShopPlace(shop1);
            
            
            // Display tempory shop list
            List<Shop> resultsList2= webdh.getTempShopList();
            
            System.out.println("Show temp list: \n");
            for(Shop sh:resultsList2){
                System.out.println(sh.getShop_name()+" "+sh.getLatitude()+" "+sh.getLongitude());
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(TestServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(" not showing list"+ ex.toString());
        }
		
	}

}
