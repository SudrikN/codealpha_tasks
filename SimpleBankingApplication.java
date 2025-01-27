import java.util.Scanner;

public class SimpleBankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0; 

        System.out.println("Welcome to the Simple Banking Application!");

        while (true) {
            
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

        
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter the amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Successfully deposited $" + deposit);
                    } else {
                        System.out.println("Invalid amount! Please enter a positive value.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal > 0 && withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.println("Successfully withdrew $" + withdrawal);
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance! You have $" + balance);
                    } else {
                        System.out.println("Invalid amount! Please enter a positive value.");
                    }
                    break;

                case 3: 
                    System.out.println("Your current balance is $" + balance);
                    break;

                case 4:
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    scanner.close(); // Close the scanner
                    return;

                default: 
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}
