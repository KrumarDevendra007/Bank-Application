package BankApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SBI.rateOfInterest = 7;
        HDFC.rateOfInterest = 8;
        AxisBank.rateOfInterest = 9;

        SBI account1 = new SBI(100000, "123", "Kumar Devendra");
        HDFC account2 = new HDFC(50000, "456", "Amit kumar Ram");
        AxisBank account3 = new AxisBank(50000, "789", "Nikku Kumar");

        // Wrong password for check
        int balance = account1.checkBalance("852");
        System.out.println("The balance for the account1 is " + balance);

        // Correct password
        int balanceCheck = account1.checkBalance("123");
        System.out.println("The balance for the account1 is " + balanceCheck);

        // Add Money
        String bankMessage = account2.addMoney(5000);
        System.out.println(bankMessage);

        // check balance withdraw money
        String message1 = account3.withdrawMoney(5000, "789");
        System.out.println(message1);

        // change password Axis bank wrong password
        String changePass1 = account3.changePassword("100", "001");
        System.out.println(changePass1);

        // change password Axis bank right password
        String message = account3.changePassword("789", "700");
        System.out.println(message);

        //  Rate of Interest
        double interest1 = account3.calculatTotalInterest(15);
        System.out.println(interest1);

        System.out.println("Make it dynamic");

        System.out.println("Welcome to Axis Bank Please enter the Details to create account");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name : ");
        String name = sc.nextLine();
        System.out.println("Enter balance : ");
        int intialBalance = sc.nextInt();
        System.out.println("Enter the password : ");
        String password = sc.next();

        AxisBank newAccount = new AxisBank(intialBalance, password, name);

        System.out.println("Your account has been created successfully.");
    }
}