// TASK:2

// Online Quiz Platform

/*A Simple Banking Application in Java is an ideal project
for coding beginners. It covers fundamental concepts
like the Scanner class for input, strings, loops, methods,
and conditional statements. This project involves basic
banking operations such as deposits, withdrawals,
checking balances, and exiting the program.*/

import java.util.Scanner;

public class OnlineQuizPlatform {

    private static double balance = 1000.0;      // Initial balance

    private static void menuShow() {
        System.out.println("Welcome to Banking App");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit amount");
        System.out.println("3. Withdraw amount");
        System.out.println("4. Exit");
        System.out.print("Choose from the above options 1 to 4 : ");
    }

    private static int getUserChoice(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void Balance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void Deposit(Scanner scanner) {
        System.out.print("Enter the deposit amount: $");
        double depositAmount = scanner.nextDouble();
        if (isValidAmount(depositAmount)) {
            balance += depositAmount;
            System.out.println("Deposited $" + depositAmount + " Successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void Withdrawal(Scanner scanner) {
        System.out.print("Enter the withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        if (isValidWithdrawal(withdrawalAmount)) {
            balance -= withdrawalAmount;
            System.out.println("Withdrawn $" + withdrawalAmount + " Successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    private static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private static boolean isValidWithdrawal(double withdrawalAmount) {
        return withdrawalAmount > 0 && withdrawalAmount <= balance;
    }
    private static void Exit() {
        System.out.println("Feel free to visit us again,Our services are always available to you....!");
        System.exit(0);
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menuShow();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    Balance();
                    break;
                case 2:
                    Deposit(scanner);
                    break;
                case 3:
                    Withdrawal(scanner);
                    break;
                case 4:
                    Exit();
                    break;
                default:
                    System.out.println("Invalid option. Please choose an option from 1,2,3,4.");
            }
        }
    }
}
