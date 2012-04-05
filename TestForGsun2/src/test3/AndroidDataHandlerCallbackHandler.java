
/**
 * AndroidDataHandlerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */

    package test3;

    /**
     *  AndroidDataHandlerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AndroidDataHandlerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AndroidDataHandlerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AndroidDataHandlerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for authenticate method
            * override this method for handling normal response from authenticate operation
            */
           public void receiveResultauthenticate(
                    test3.AndroidDataHandlerStub.AuthenticateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authenticate operation
           */
            public void receiveErrorauthenticate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for giveSuggestionList method
            * override this method for handling normal response from giveSuggestionList operation
            */
           public void receiveResultgiveSuggestionList(
                    test3.AndroidDataHandlerStub.GiveSuggestionListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from giveSuggestionList operation
           */
            public void receiveErrorgiveSuggestionList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for giveResultList method
            * override this method for handling normal response from giveResultList operation
            */
           public void receiveResultgiveResultList(
                    test3.AndroidDataHandlerStub.GiveResultListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from giveResultList operation
           */
            public void receiveErrorgiveResultList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for giveAllNeeds method
            * override this method for handling normal response from giveAllNeeds operation
            */
           public void receiveResultgiveAllNeeds(
                    test3.AndroidDataHandlerStub.GiveAllNeedsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from giveAllNeeds operation
           */
            public void receiveErrorgiveAllNeeds(java.lang.Exception e) {
            }
                


    }
    