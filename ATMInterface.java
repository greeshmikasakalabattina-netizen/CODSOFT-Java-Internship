import java.util.Scanner;
class BankAccount {    
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(10000);

        int choice;

        System.out.println("===== ATM INTERFACE =====");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();

                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                        System.out.println("Remaining Balance: ₹" + account.getBalance());
                    } else {
                        System.out.println("Withdrawal failed! Insufficient balance or invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();

                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful!");
                        System.out.println("New Balance: ₹" + account.getBalance());
                    } else {
                        System.out.println("Deposit failed! Enter a valid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1 to 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}