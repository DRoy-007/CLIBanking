import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        byte choice;

        while (true) { 
            System.out.println("==== MAIN MENU ====");
            System.out.println("Press 1: Register\nPress 2: Login\nPress 3: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextByte();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    handleRegister();
                    break;

                case 2:
                    int userId = handleLogin();

                    if (userId != -1) {
                        clearScreen();
                        System.out.println("Login successfull!");
                        dashboard(userId);
                        break;
                    }
                    else System.out.println("Login Failed!");

                    break;

                case 3:
                    System.out.println("Exiting... Goodbye");
                    System.exit(0);

                default: 
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleRegister(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean success = AuthService.register(username, password);

        if(success) System.out.println("Registration successful!");
        else System.out.println("Registration failed!\nUser already exists...");
    }

    private static int handleLogin(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        return AuthService.login(username, password);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void dashboard(int userId){
        while (true) { 
            System.out.println("\n==== DASHBOARD ====\n");
            System.out.println("Press 1: Create Account");
            System.out.println("Press 2: Deposit");
            System.out.println("Press 3: Withdraw");
            System.out.println("Press 4: Transfer");
            System.out.println("Press 5: Logout");
            System.out.print("Enetr your chohice: ");
            byte choice = sc.nextByte();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Create ac to be implemented");
                    break;

                case 2: 
                    System.out.println("Deposit to be implemented");
                    break;

                case 3: 
                    System.out.println("Withdraw to be implemented");
                    break;
                
                case 4:
                    System.out.println("Transfer to be implemented");
                    break;
                
                case 5:
                    System.out.println("Logging out...");
                    return;
            
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}