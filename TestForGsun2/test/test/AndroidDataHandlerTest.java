

/**
 * AndroidDataHandlerTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package test;

    /*
     *  AndroidDataHandlerTest Junit test case
    */

    public class AndroidDataHandlerTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testauthenticate() throws java.lang.Exception{

        test.AndroidDataHandlerStub stub =
                    new test.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test.AndroidDataHandlerStub.Authenticate authenticate16=
                                                        (test.AndroidDataHandlerStub.Authenticate)getTestObject(test.AndroidDataHandlerStub.Authenticate.class);
                    // TODO : Fill in the authenticate16 here
                
                        assertNotNull(stub.authenticate(
                        authenticate16));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartauthenticate() throws java.lang.Exception{
            test.AndroidDataHandlerStub stub = new test.AndroidDataHandlerStub();
             test.AndroidDataHandlerStub.Authenticate authenticate16=
                                                        (test.AndroidDataHandlerStub.Authenticate)getTestObject(test.AndroidDataHandlerStub.Authenticate.class);
                    // TODO : Fill in the authenticate16 here
                

                stub.startauthenticate(
                         authenticate16,
                    new tempCallbackN65548()
                );
              


        }

        private class tempCallbackN65548  extends test.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65548(){ super(null);}

            public void receiveResultauthenticate(
                         test.AndroidDataHandlerStub.AuthenticateResponse result
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

        test.AndroidDataHandlerStub stub =
                    new test.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                        (test.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test.AndroidDataHandlerStub.GiveSuggestionList.class);
                    // TODO : Fill in the giveSuggestionList18 here
                
                        assertNotNull(stub.giveSuggestionList(
                        giveSuggestionList18));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveSuggestionList() throws java.lang.Exception{
            test.AndroidDataHandlerStub stub = new test.AndroidDataHandlerStub();
             test.AndroidDataHandlerStub.GiveSuggestionList giveSuggestionList18=
                                                        (test.AndroidDataHandlerStub.GiveSuggestionList)getTestObject(test.AndroidDataHandlerStub.GiveSuggestionList.class);
                    // TODO : Fill in the giveSuggestionList18 here
                

                stub.startgiveSuggestionList(
                         giveSuggestionList18,
                    new tempCallbackN65604()
                );
              


        }

        private class tempCallbackN65604  extends test.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65604(){ super(null);}

            public void receiveResultgiveSuggestionList(
                         test.AndroidDataHandlerStub.GiveSuggestionListResponse result
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

        test.AndroidDataHandlerStub stub =
                    new test.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                        (test.AndroidDataHandlerStub.GiveResultList)getTestObject(test.AndroidDataHandlerStub.GiveResultList.class);
                    // TODO : Fill in the giveResultList20 here
                
                        assertNotNull(stub.giveResultList(
                        giveResultList20));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveResultList() throws java.lang.Exception{
            test.AndroidDataHandlerStub stub = new test.AndroidDataHandlerStub();
             test.AndroidDataHandlerStub.GiveResultList giveResultList20=
                                                        (test.AndroidDataHandlerStub.GiveResultList)getTestObject(test.AndroidDataHandlerStub.GiveResultList.class);
                    // TODO : Fill in the giveResultList20 here
                

                stub.startgiveResultList(
                         giveResultList20,
                    new tempCallbackN65660()
                );
              


        }

        private class tempCallbackN65660  extends test.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65660(){ super(null);}

            public void receiveResultgiveResultList(
                         test.AndroidDataHandlerStub.GiveResultListResponse result
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

        test.AndroidDataHandlerStub stub =
                    new test.AndroidDataHandlerStub();//the default implementation should point to the right endpoint

           test.AndroidDataHandlerStub.GiveAllNeeds giveAllNeeds22=
                                                        (test.AndroidDataHandlerStub.GiveAllNeeds)getTestObject(test.AndroidDataHandlerStub.GiveAllNeeds.class);
                    // TODO : Fill in the giveAllNeeds22 here
                
                        assertNotNull(stub.giveAllNeeds(
                        giveAllNeeds22));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgiveAllNeeds() throws java.lang.Exception{
            test.AndroidDataHandlerStub stub = new test.AndroidDataHandlerStub();
             test.AndroidDataHandlerStub.GiveAllNeeds giveAllNeeds22=
                                                        (test.AndroidDataHandlerStub.GiveAllNeeds)getTestObject(test.AndroidDataHandlerStub.GiveAllNeeds.class);
                    // TODO : Fill in the giveAllNeeds22 here
                

                stub.startgiveAllNeeds(
                         giveAllNeeds22,
                    new tempCallbackN65716()
                );
              


        }

        private class tempCallbackN65716  extends test.AndroidDataHandlerCallbackHandler{
            public tempCallbackN65716(){ super(null);}

            public void receiveResultgiveAllNeeds(
                         test.AndroidDataHandlerStub.GiveAllNeedsResponse result
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
    