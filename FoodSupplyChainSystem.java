
package foodsupplychainsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodSupplyChainSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser;
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Food Supply Chain System");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    signUp(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (currentUser != null) {
                userMenu(scanner);
            }
        }
        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + currentUser.getName());
                return;
            }
        }
        System.out.println("Invalid email or password. Please try again.");
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Select role: 1. Admin 2. Producer 3. Distributor");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        User newUser;
        switch (roleChoice) {
            case 1:
                newUser = new Admin(name, email, password);
                break;
            case 2:
                newUser = new Producer(name, email, password);
                break;
            case 3:
                newUser = new Distributor(name, email, password);
                break;
            default:
                System.out.println("Invalid role choice. Sign up failed.");
                return;
        }

        users.add(newUser);
        currentUser = newUser;
        System.out.println("Sign up successful. Welcome, " + currentUser.getName());
    }

    private static void userMenu(Scanner scanner) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Add Products to Cart");
            System.out.println("2. Asset Tracking");
            System.out.println("3. Blockchain Transactions");
            System.out.println("4. Smart Contracts");
            System.out.println("5. My Wallet");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProductsToCart(scanner);
                    break;
                case 2:
                    assetTracking(scanner);
                    break;
                case 3:
                    blockchainTransactions(scanner);
                    break;
                case 4:
                    manageSmartContracts(scanner);
                    break;
                case 5:
                    viewWallet();
                    break;
                case 6:
                    currentUser = null;
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addProductsToCart(Scanner scanner) {
        System.out.print("Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Inventory product = new Inventory(productId, productName, quantity, price);
        cart.addItem(product);
    }

    private static void assetTracking(Scanner scanner) {
        // Implementation for asset tracking
        System.out.println("Asset tracking (functionality not yet implemented).");
    }

    private static void blockchainTransactions(Scanner scanner) {
        System.out.println("Blockchain Transactions Menu:");
        System.out.println("1. Create Transaction");
        System.out.println("2. View Transactions");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                Transaction.createTransaction(scanner, users, currentUser);
                break;
            case 2:
                Transaction.viewTransactions();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void manageSmartContracts(Scanner scanner) {
        // Implementation for managing smart contracts
        System.out.println("Managing smart contracts (functionality not yet implemented).");
    }

    private static void viewWallet() {
        // Implementation for viewing wallet
        System.out.println("Viewing wallet (functionality not yet implemented).");
    }
}





