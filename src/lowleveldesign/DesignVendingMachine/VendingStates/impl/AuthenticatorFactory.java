/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lowleveldesign.DesignVendingMachine.VendingStates.impl;

import lowleveldesign.DesignVendingMachine.VendingStates.Authenticator;

/**
 *
 * @author pipe2
 */
public class AuthenticatorFactory {
    
    public static Authenticator getAuthenticator(AuthenticationOption option) {
        switch (option) {
            case UserCREDENTIALS:
                return new UserCredentialsAuthenticator();
            case PIN:
                return new PINAuthenticator();
            case SocialMEDIA:
                return new SocialMediaAuthenticator();
            default:
                throw new IllegalArgumentException("Invalid authentication option");
        }
    }
    
}
