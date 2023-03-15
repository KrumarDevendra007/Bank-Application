package BankApp;
import java.util.UUID;

public class HDFC implements Bank{

    private int balance;
    private String accountNo;
    private String password;
    public String name;

    public static double rateOfInterest;

    public HDFC(int balance, String password, String name) {
        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }

    @Override
    public int checkBalance(String password) {
        if(this.password == password){
            return balance;
        }
        else{
            return -1;
        }
    }

    @Override
    public String addMoney(int money) {
        balance = balance + money;

        String message = money + " has been added to the account " + accountNo;

        return message;
    }

    @Override
    public String withdrawMoney(int drawMoney, String password) {
        if(this.password.equals(password)){
            if(drawMoney > balance){
                return "Insufficient balance";
            }
            else{
                balance = balance - drawMoney;
                return "Money withdraw successfully";
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
            return "Password has been updataed successfully";
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public double calculatTotalInterest(int years) {

        double interest = balance*rateOfInterest*years/100;

        return interest;
    }
}