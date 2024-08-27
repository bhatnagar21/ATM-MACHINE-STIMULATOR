import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {

    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    public ATMSimulation(String pin) {
        this.balance = 0.0;

        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    // Function to inquire balance
    public void inquireBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Function to withdraw cash
    public void withdrawCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Successfully withdrew: $" + amount);
        }
    }

    // Function to deposit cash
    public void depositCash(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Successfully deposited: $" + amount);
    }

    // Function to change PIN
    public void changePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN successfully changed.");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    // Function to display transaction history
    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Main function to simulate the ATM
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set your initial PIN: ");
        String pin = scanner.nextLine();
        ATMSimulation atm = new ATMSimulation(pin);

        while (true) {
            System.out.println("\nATM Machine Simulation");
            System.out.println("1. Inquire Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.inquireBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.depositCash(depositAmount);
                    break;
                case 4:
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter current PIN: ");
                    String currentPin = scanner.nextLine();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();
                    atm.changePin(currentPin, newPin);
                    break;
                case 5:
                    atm.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting. Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}