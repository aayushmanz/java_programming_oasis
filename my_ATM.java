import java.util.Scanner;
import java.io.PrintStream;
import java.util.Vector;

public class my_ATM {
    public static void main (String[] args){
        int choice = 0;
        double amount = 0;
        double balance = 1000;
        Vector <String> history = new Vector<>();
        Scanner sc = new Scanner(System.in);
        PrintStream p = System.out;

        do {
            p.println("--------Menu of ATM---------");
            p.println("1. Transactions History");
            p.println("2. Withdraw");
            p.println("3. Deposit");
            p.println("4. Transfer");
            p.println("5. Quit");
            p.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (history.isEmpty()) {
                        System.out.println("No transaction held yet !!!");
                    } else {
                        System.out.println("What you want to see :");
                        System.out.println("1. For withdraw and deposit history");
                        System.out.println("2. For all transaction details");
                        System.out.println("---------------------------");
                        System.out.println("Enter your choice : ");
                        int choose = sc.nextInt();

                        switch(choose){
                            case 1:
                                for (String record : history) {
                                    if (record.contains("Deposited") || record.contains("Withdrawn")) {
                                        System.out.println(record);
                                    }
                                }
                                break;
                            case 2:
                                for (String record : history) {
                                    System.out.println(record);
                                }
                                break;
                            default:
                                System.out.println("Invalid choice !!!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter Withdraw amount : ");
                    amount = sc.nextDouble();

                    if (amount > 0 && amount <= balance) {
                        balance = balance - amount;
                        System.out.println("Withdraw Successful! Remaining Balance: " + balance);
                        history.add("Withdrawn: " + amount + " | Balance: " + balance);
                    } else {
                        System.out.println("Invalid amount or Insufficient balance !!!");
                    }
                    break;

                case 3:
                    System.out.println("Enter deposit amount : ");
                    amount = sc.nextDouble();

                    if (amount > 0) {
                        balance = balance + amount;
                        System.out.println("Deposit Successful! New Balance: " + balance);
                        history.add("Deposited: " + amount + " | Balance: " + balance);
                    } else {
                        System.out.println("Invalid amount !!!");
                    }
                    break;

                case 4:
                    System.out.println("Enter the account number : ");
                    long account_number = sc.nextLong();
                    System.out.println("Enter your amount for transfer : ");
                    amount = sc.nextDouble();

                    if (amount > 0 && amount <= balance) {
                        balance = balance - amount;
                        System.out.println("Your transaction to " + account_number + " of " + amount + " is successfully transferred");
                        history.add("Transferred: " + amount + " to " + account_number + " | Balance: " + balance);
                    } else {
                        System.out.println("Invalid amount or Insufficient balance !!!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for trusting our bank !!!");
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid choice !!!");
            }

        } while(choice != 5);
    }
}
