
/**
 * SocialServiceIntegrationSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package pl.edu.pk.ias.socialserviceintegration;
    /**
     *  SocialServiceIntegrationSkeletonInterface java skeleton interface for the axisService
     */
    public interface SocialServiceIntegrationSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * Wylogowanie z aplikacji
                                    * @param logoutRequest
         */

        
                public pl.edu.pk.ias.types.LogoutResponseE logout
                (
                  pl.edu.pk.ias.types.LogoutRequestE logoutRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * Pobranie listy dostępnych elementów ( ID + Name). Element jest bytem różniącym się dla każdego serwisu społecznościowego
                                    * @param getItemsPreviewsRequest
             * @throws TokenExpiredFault : 
         */

        
                public pl.edu.pk.ias.types.GetItemsPreviewsResponseE getItemsPreviews
                (
                  pl.edu.pk.ias.types.GetItemsPreviewsRequestE getItemsPreviewsRequest
                 )
            throws TokenExpiredFault;
        
         
        /**
         * Auto generated method signature
         * Pobranie list kont serwisów społecznościowych, dla zalogowanego użytkownika
                                    * @param accountsRequest
             * @throws TokenExpiredFault : 
         */

        
                public pl.edu.pk.ias.types.AccountsResponseE accounts
                (
                  pl.edu.pk.ias.types.AccountsRequestE accountsRequest
                 )
            throws TokenExpiredFault;
        
         
        /**
         * Auto generated method signature
         * Logowanie do aplikacji
                                    * @param loginRequest
             * @throws UserNotExistFault : 
             * @throws IncorrectPasswordFault : 
         */

        
                public pl.edu.pk.ias.types.LoginResponseE login
                (
                  pl.edu.pk.ias.types.LoginRequestE loginRequest
                 )
            throws UserNotExistFault,IncorrectPasswordFault;
        
         
        /**
         * Auto generated method signature
         * Publikacja treści w serwisie społecznościowym
                                    * @param publishRequest
             * @throws TokenExpiredFault : 
         */

        
                public pl.edu.pk.ias.types.PublishResponseE publish
                (
                  pl.edu.pk.ias.types.PublishRequestE publishRequest
                 )
            throws TokenExpiredFault;
        
         
        /**
         * Auto generated method signature
         * Usunięcie wybranych elementów
                                    * @param removeRequest
             * @throws TokenExpiredFault : 
         */

        
                public pl.edu.pk.ias.types.RemoveResponseE remove
                (
                  pl.edu.pk.ias.types.RemoveRequestE removeRequest
                 )
            throws TokenExpiredFault;
        
         
        /**
         * Auto generated method signature
         * Pobranie kompletnych elementów. Element jest bytem różniącym się dla każdego serwisu społecznościowego
                                    * @param getItemsRequest
             * @throws TokenExpiredFault : 
         */

        
                public pl.edu.pk.ias.types.GetItemsResponseE getItems
                (
                  pl.edu.pk.ias.types.GetItemsRequestE getItemsRequest
                 )
            throws TokenExpiredFault;
        
         }
    