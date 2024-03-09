/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lowleveldesign.DesignVendingMachine.VendingStates.impl;

import java.util.Scanner;
import lowleveldesign.DesignVendingMachine.VendingMachine;
import lowleveldesign.DesignVendingMachine.VendingStates.Authenticator;

/**
 *
 * @author pipe2
 */
public class SocialMediaAuthenticator implements Authenticator {
    @Override
    public boolean authenticate(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter social media credentials:");
        String socialMediaCredentials = scanner.nextLine();
        // Lógica de autenticación con redes sociales
        return false;
    }


}
