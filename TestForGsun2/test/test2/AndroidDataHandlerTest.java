

/**
 * AndroidDataHandlerTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package test2;

import com.google.gson.Gson;


    /*
     *  AndroidDataHandlerTest Junit test case
    */

    public class AndroidDataHandlerTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testauthenticate() throws java.lang.Exception{

        test3.AndroidDataHandlerStub stub =
                    new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test3.AndroidDataHandlerStub.Authenticate authenticate16=
                                                        (test3.AndroidDataHandlerStub.Authenticate)getTestObject(test3.AndroidDataHandlerStub.Authenticate.class);
                    // TODO : Fill in the authenticate16 here
                
           
                        assertNotNull(stub.authenticate(
                        authenticate16));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartauthenticate() throws java.lang.Exception{
            test3.AndroidDataHandlerStub stub = new test3.AndroidDataHandlerStub();
             test3.AndroidDataHandlerStub.Authenticate authenticate16=
                                                        (test3.AndroidDataHandlerStub.Authenticate)getTestObject(test3.AndroidDataHandlerStub.Authenticate.class);
                    // TODO : Fill in the authenticate16 here
                

                stub.startauthenticate(
                         authenticate16,
                    new tempCallbackN65548()
                );
              


        }

        private class tempCallbackN65548  extends test3.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65548(){ super(null);}

            public void receiveResultauthenticate(
                         test3.AndroidDataHandlerStub.AuthenticateResponse result
                            ) {
                
            }

            public void receiveErrorauthenticate(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testgiveSuggestionList() throws java.lang.Exception{

        test3.AndroidDataHandlerStub stub =
                    new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test3.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                        (test3.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test3.AndroidDataHandlerStub.GiveSuggestionList.class);
                    // TODO : Fill in the giveSuggestionList18 here
           Entry searchEntry=new Entry("Apple", "", "80", "6");
                giveSuggestionList18.setEntryString(new Gson().toJson(searchEntry));
                giveSuggestionList18.setRange(5);
                        assertNotNull(stub.giveSuggestionList(
                        giveSuggestionList18));
        
        }
        
        public  void testgiveSuggestionList2() throws java.lang.Exception{

            test3.AndroidDataHandlerStub stub =
                        new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

               test3.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                            (test3.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test3.AndroidDataHandlerStub.GiveSuggestionList.class);
                        // TODO : Fill in the giveSuggestionList18 here
               Entry searchEntry=new Entry("Paper", "", "80", "6");
                    giveSuggestionList18.setEntryString(new Gson().toJson(searchEntry));
                    giveSuggestionList18.setRange(5);
                            assertNotNull(stub.giveSuggestionList(
                            giveSuggestionList18));
            
            }
        
        public  void testgiveSuggestionList3() throws java.lang.Exception{

            test3.AndroidDataHandlerStub stub =
                        new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

               test3.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                            (test3.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test3.AndroidDataHandlerStub.GiveSuggestionList.class);
                        // TODO : Fill in the giveSuggestionList18 here
               Entry searchEntry=new Entry("Bread", "", "80", "6");
                    giveSuggestionList18.setEntryString(new Gson().toJson(searchEntry));
                    giveSuggestionList18.setRange(5);
                            assertNotNull(stub.giveSuggestionList(
                            giveSuggestionList18));
            
            }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveSuggestionList() throws java.lang.Exception{
            test3.AndroidDataHandlerStub stub = new test3.AndroidDataHandlerStub();
             test3.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                        (test3.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test3.AndroidDataHandlerStub.GiveSuggestionList.class);
                    // TODO : Fill in the giveSuggestionList18 here
                

                stub.startgiveSuggestionList(
                         giveSuggestionList18,
                    new tempCallbackN65589()
                );
              


        }

        private class tempCallbackN65589  extends test3.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65589(){ super(null);}

            public void receiveResultgiveSuggestionList(
                         test3.AndroidDataHandlerStub.GiveSuggestionListResponse result
                            ) {
                
            }

            public void receiveErrorgiveSuggestionList(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testgiveResultList() throws java.lang.Exception{

        test3.AndroidDataHandlerStub stub =
                    new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test3.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                        (test3.AndroidDataHandlerStub.GiveResultList)getTestObject(test3.AndroidDataHandlerStub.GiveResultList.class);
                    // TODO : Fill in the giveResultList20 here
           Entry searchEntry=new Entry("Drug", "", "80", "6");
           giveResultList20.setEntryString(new Gson().toJson(searchEntry));
           giveResultList20.setRange(10);
                        assertNotNull(stub.giveResultList(
                        giveResultList20));
         
        }
        
        public  void testgiveResultList2() throws java.lang.Exception{

            test3.AndroidDataHandlerStub stub =
                        new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

               test3.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                            (test3.AndroidDataHandlerStub.GiveResultList)getTestObject(test3.AndroidDataHandlerStub.GiveResultList.class);
                        // TODO : Fill in the giveResultList20 here
               Entry searchEntry=new Entry("Bun", "", "80", "6");
               giveResultList20.setEntryString(new Gson().toJson(searchEntry));
               giveResultList20.setRange(10);
                            assertNotNull(stub.giveResultList(
                            giveResultList20));
             
            }
        
        public  void testgiveResultList3() throws java.lang.Exception{

            test3.AndroidDataHandlerStub stub =
                        new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

               test3.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                            (test3.AndroidDataHandlerStub.GiveResultList)getTestObject(test3.AndroidDataHandlerStub.GiveResultList.class);
                        // TODO : Fill in the giveResultList20 here
               Entry searchEntry=new Entry("Pen", "", "80", "6");
               giveResultList20.setEntryString(new Gson().toJson(searchEntry));
               giveResultList20.setRange(10);
                            assertNotNull(stub.giveResultList(
                            giveResultList20));
             
            }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveResultList() throws java.lang.Exception{
            test3.AndroidDataHandlerStub stub = new test3.AndroidDataHandlerStub();
             test3.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                        (test3.AndroidDataHandlerStub.GiveResultList)getTestObject(test3.AndroidDataHandlerStub.GiveResultList.class);
                    // TODO : Fill in the giveResultList20 here
                

                stub.startgiveResultList(
                         giveResultList20,
                    new tempCallbackN65630()
                );
              


        }

        private class tempCallbackN65630  extends test3.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65630(){ super(null);}

            public void receiveResultgiveResultList(
                         test3.AndroidDataHandlerStub.GiveResultListResponse result
                            ) {
                
            }

            public void receiveErrorgiveResultList(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testgiveAllNeeds() throws java.lang.Exception{

        test3.AndroidDataHandlerStub stub =
                    new test3.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test3.AndroidDataHandlerStub.GiveAllNeeds giveAllNeeds22=
                                                        (test3.AndroidDataHandlerStub.GiveAllNeeds)getTestObject(test3.AndroidDataHandlerStub.GiveAllNeeds.class);
                    // TODO : Fill in the giveAllNeeds22 here
                  
                  
           assertNotNull(stub.giveAllNeeds(
                        giveAllNeeds22));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveAllNeeds() throws java.lang.Exception{
            test3.AndroidDataHandlerStub stub = new test3.AndroidDataHandlerStub();
             test3.AndroidDataHandlerStub.GiveAllNeeds giveAllNeeds22=
                                                        (test3.AndroidDataHandlerStub.GiveAllNeeds)getTestObject(test3.AndroidDataHandlerStub.GiveAllNeeds.class);
                    // TODO : Fill in the giveAllNeeds22 here
                

                stub.startgiveAllNeeds(
                         giveAllNeeds22,
                    new tempCallbackN65671()
                );
              


        }

        private class tempCallbackN65671  extends test3.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65671(){ super(null);}

            public void receiveResultgiveAllNeeds(
                         test3.AndroidDataHandlerStub.GiveAllNeedsResponse result
                            ) {
                
            }

            public void receiveErrorgiveAllNeeds(java.lang.Exception e) {
                fail();
            }

        }
      
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

    }
    