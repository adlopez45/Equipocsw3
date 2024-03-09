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
public class PINAuthenticator implements Authenticator {

    @Override
    public boolean authenticate(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter PIN:");
        int pin = scanner.nextInt();
        return false;
    }
    
    
    
    
}
