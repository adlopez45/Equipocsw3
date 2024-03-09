package lowleveldesign.DesignVendingMachine.VendingStates.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import lowleveldesign.DesignVendingMachine.VendingMachine;
import lowleveldesign.DesignVendingMachine.VendingStates.Authenticator;

/**
 * Implementación de la interfaz Authenticator para la autenticación basada en credenciales de usuario.
 */
public class UserCredentialsAuthenticator implements Authenticator {

    private Map<String, String> userCredentials;

    public UserCredentialsAuthenticator() {
        userCredentials = new HashMap<>();
        // Agregar usuarios y contraseñas predefinidos
        userCredentials.put("Felipe", "Password1");
        userCredentials.put("user2", "SecurePass123");
        // Puedes agregar más usuarios y contraseñas según sea necesario
    }

    @Override
    public boolean authenticate(VendingMachine vendingMachine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario:");
        String username = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();

        // Verificar si las credenciales ingresadas son válidas
        if (userCredentials.containsKey(username)) {
            String storedPassword = userCredentials.get(username);
            if (storedPassword.equals(password)) {
                System.out.println("¡Autenticación exitosa!");
                return true;
            } else {
                System.out.println("Contraseña incorrecta. Autenticación fallida.");
                return false;
            }
        } else {
            System.out.println("Nombre de usuario no válido. Autenticación fallida.");
            return false;
        }
    }

    // Método para validar la contraseña según las restricciones
    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}
