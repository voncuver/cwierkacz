
/**
 * SocialServiceIntegrationSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package pl.edu.pk.ias.socialserviceintegration;
    /**
     *  SocialServiceIntegrationSkeleton java skeleton for the axisService
     */
    public class SocialServiceIntegrationSkeleton implements SocialServiceIntegrationSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * Wylogowanie z aplikacji
                                     * @param logoutRequest0 
             * @return logoutResponse1 
         */
        
                 public pl.edu.pk.ias.types.LogoutResponseE logout
                  (
                  pl.edu.pk.ias.types.LogoutRequestE logoutRequest0
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#logout");
        }
     
         
        /**
         * Auto generated method signature
         * Pobranie listy dostępnych elementów ( ID + Name). Element jest bytem różniącym się dla każdego serwisu społecznościowego
                                     * @param getItemsPreviewsRequest2 
             * @return getItemsPreviewsResponse3 
             * @throws TokenExpiredFault 
         */
        
                 public pl.edu.pk.ias.types.GetItemsPreviewsResponseE getItemsPreviews
                  (
                  pl.edu.pk.ias.types.GetItemsPreviewsRequestE getItemsPreviewsRequest2
                  )
            throws TokenExpiredFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getItemsPreviews");
        }
     
         
        /**
         * Auto generated method signature
         * Pobranie list kont serwisów społecznościowych, dla zalogowanego użytkownika
                                     * @param accountsRequest4 
             * @return accountsResponse5 
             * @throws TokenExpiredFault 
         */
        
                 public pl.edu.pk.ias.types.AccountsResponseE accounts
                  (
                  pl.edu.pk.ias.types.AccountsRequestE accountsRequest4
                  )
            throws TokenExpiredFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#accounts");
        }
     
         
        /**
         * Auto generated method signature
         * Logowanie do aplikacji
                                     * @param loginRequest6 
             * @return loginResponse7 
             * @throws UserNotExistFault 
             * @throws IncorrectPasswordFault 
         */
        
                 public pl.edu.pk.ias.types.LoginResponseE login
                  (
                  pl.edu.pk.ias.types.LoginRequestE loginRequest6
                  )
            throws UserNotExistFault,IncorrectPasswordFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#login");
        }
     
         
        /**
         * Auto generated method signature
         * Publikacja treści w serwisie społecznościowym
                                     * @param publishRequest8 
             * @return publishResponse9 
             * @throws TokenExpiredFault 
         */
        
                 public pl.edu.pk.ias.types.PublishResponseE publish
                  (
                  pl.edu.pk.ias.types.PublishRequestE publishRequest8
                  )
            throws TokenExpiredFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#publish");
        }
     
         
        /**
         * Auto generated method signature
         * Usunięcie wybranych elementów
                                     * @param removeRequest10 
             * @return removeResponse11 
             * @throws TokenExpiredFault 
         */
        
                 public pl.edu.pk.ias.types.RemoveResponseE remove
                  (
                  pl.edu.pk.ias.types.RemoveRequestE removeRequest10
                  )
            throws TokenExpiredFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#remove");
        }
     
         
        /**
         * Auto generated method signature
         * Pobranie kompletnych elementów. Element jest bytem różniącym się dla każdego serwisu społecznościowego
                                     * @param getItemsRequest12 
             * @return getItemsResponse13 
             * @throws TokenExpiredFault 
         */
        
                 public pl.edu.pk.ias.types.GetItemsResponseE getItems
                  (
                  pl.edu.pk.ias.types.GetItemsRequestE getItemsRequest12
                  )
            throws TokenExpiredFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getItems");
        }
     
    }
    