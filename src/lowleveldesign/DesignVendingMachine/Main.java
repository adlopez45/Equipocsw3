package lowleveldesign.DesignVendingMachine;


import java.util.Scanner;
import lowleveldesign.DesignVendingMachine.VendingStates.Authenticator;
import lowleveldesign.DesignVendingMachine.VendingStates.State;
import lowleveldesign.DesignVendingMachine.VendingStates.impl.AuthenticationOption;
import lowleveldesign.DesignVendingMachine.VendingStates.impl.AuthenticatorFactory;


public class Main {

    public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine();
    boolean authenticationSuccessful = false;
    int authenticationAttempts = 0;

    // Llena el inventario y muestra los productos disponibles
    System.out.println("| Filling up the inventory |");
    fillUpInventory(vendingMachine);
    displayInventory(vendingMachine);

    // Solicita al usuario que elija un método de autenticación
    AuthenticationOption authenticationOption = chooseAuthenticationMethod();
    Authenticator authenticator = AuthenticatorFactory.getAuthenticator(authenticationOption);

    while (!authenticationSuccessful && authenticationAttempts < 3) {
        try {
            // Realiza la autenticación según el método elegido
            authenticationSuccessful = authenticator.authenticate(vendingMachine);

            // Incrementa el contador de intentos de autenticación
            authenticationAttempts++;
            
            if (!authenticationSuccessful && authenticationAttempts < 3) {
                System.out.println("Autenticación fallida. Por favor, intente nuevamente.");
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra durante el proceso de autenticación
            System.out.println("Se produjo un error durante la autenticación. Por favor, intente nuevamente.");
        }
    }

    if (authenticationSuccessful) {
          try {
             Scanner scanner = new Scanner(System.in);
            System.out.println("¡Autenticación exitosa! Opciones restringidas:");
            System.out.println("1. Gestionar inventario");
            System.out.println("2. Gestionar monedas o billetes");
            System.out.println("Ingrese el número de la opción deseada:");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                manageInventory();
                break;
             case 2:
                manageCoinsOrBills();
                break;
                default:
                System.out.println("Opción no válida");
                break;
            }
        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    } else {
        System.out.println("Número máximo de intentos de autenticación alcanzado, usuario bloqueado. Contacte al administrador. Finalizando...");
        System.exit(0); 
    }
}

    private static AuthenticationOption chooseAuthenticationMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose authentication method:");
        System.out.println("1. User Credentials");
        System.out.println("2. PIN");
        System.out.println("3. Social Media");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return AuthenticationOption.UserCREDENTIALS;
            case 2:
                System.out.println("PIN authentication is not available at the moment.");
            return AuthenticationOption.UserCREDENTIALS; 
            case 3:
                System.out.println("Social Media authentication is not available at the moment.");
            return AuthenticationOption.UserCREDENTIALS; 
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    
   
    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }
    
    private static void manageInventory() {
        System.out.println("Gestionando el inventario...");
    }

    private static void manageCoinsOrBills() {
        System.out.println("Gestionando las monedas o billetes...");
    }
    
}
