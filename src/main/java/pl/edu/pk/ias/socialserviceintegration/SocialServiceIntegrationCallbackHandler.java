
/**
 * SocialServiceIntegrationCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package pl.edu.pk.ias.socialserviceintegration;

    /**
     *  SocialServiceIntegrationCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SocialServiceIntegrationCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SocialServiceIntegrationCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SocialServiceIntegrationCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for logout method
            * override this method for handling normal response from logout operation
            */
           public void receiveResultlogout(
                    pl.edu.pk.ias.types.LogoutResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logout operation
           */
            public void receiveErrorlogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItemsPreviews method
            * override this method for handling normal response from getItemsPreviews operation
            */
           public void receiveResultgetItemsPreviews(
                    pl.edu.pk.ias.types.GetItemsPreviewsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItemsPreviews operation
           */
            public void receiveErrorgetItemsPreviews(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for accounts method
            * override this method for handling normal response from accounts operation
            */
           public void receiveResultaccounts(
                    pl.edu.pk.ias.types.AccountsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from accounts operation
           */
            public void receiveErroraccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    pl.edu.pk.ias.types.LoginResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for publish method
            * override this method for handling normal response from publish operation
            */
           public void receiveResultpublish(
                    pl.edu.pk.ias.types.PublishResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from publish operation
           */
            public void receiveErrorpublish(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for remove method
            * override this method for handling normal response from remove operation
            */
           public void receiveResultremove(
                    pl.edu.pk.ias.types.RemoveResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from remove operation
           */
            public void receiveErrorremove(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItems method
            * override this method for handling normal response from getItems operation
            */
           public void receiveResultgetItems(
                    pl.edu.pk.ias.types.GetItemsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItems operation
           */
            public void receiveErrorgetItems(java.lang.Exception e) {
            }
                


    }
    