/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lowleveldesign.DesignVendingMachine.VendingStates.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import lowleveldesign.DesignVendingMachine.VendingMachine;
import lowleveldesign.DesignVendingMachine.VendingStates.Authenticator;

/**
 *
 * @author pipe2
 */
public class UserCredentialsAuthenticator implements Authenticator {

    private Map<String, String> userCredentials;

    public UserCredentialsAuthenticator() {
        userCredentials = new HashMap<>();
        // Agregar usuarios y contraseñas predefinidos
        userCredentials.put("Felipe", "123");
        userCredentials.put("user2", "password2");
        // Puedes agregar más usuarios y contraseñas según sea necesario
    }

    @Override
    public boolean authenticate(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Verificar si las credenciales ingresadas son válidas
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                System.out.println("Authentication successful.");
                return true;
            } else {
                System.out.println("Invalid password. Authentication failed.");
                return false;
            }
        } else {
            System.out.println("Invalid username. Authentication failed.");
            return false;
        }
    }
}
