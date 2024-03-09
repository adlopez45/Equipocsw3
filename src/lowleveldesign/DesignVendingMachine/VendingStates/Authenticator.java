/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lowleveldesign.DesignVendingMachine.VendingStates;

import lowleveldesign.DesignVendingMachine.VendingMachine;

/**
 *
 * @author pipe2
 */
public interface Authenticator {
 
    boolean authenticate(VendingMachine vendingMachine);
    
}
