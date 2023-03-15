package BankApp;

import java.util.UUID;


public class SBI implements Bank{

    private int balance;
    private String accountNo;
    private  String password;
    public String name;

    public static double rateOfInterest;

    public SBI(int balance, String password, String name) {
        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {
        if(password == this.password){
            return balance;
        }
        return -1;
    }

    @Override
    public String addMoney(int money) {
        balance = balance + money;

        java.lang.String massage = money + " has been added to your acount " + accountNo + "" +
                " total balance in your account " + balance;

        return massage;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {

        if(this.password == password){
            if(drawMoney > balance){
                return "Insufficient balance";
            }
            else{
                balance = balance - drawMoney;
                return "Money withdraw successfully. Remaining balance is " + balance;
            }
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {

        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Password has been update successfully";
        }
        else{
            return "Wrong Password";
        }

    }

    @Override
    public double calculatTotalInterest(int years) {

        double interest = balance*rateOfInterest*years/100;

        return interest;
    }
  }

