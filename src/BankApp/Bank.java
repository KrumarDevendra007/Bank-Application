package BankApp;

public interface Bank {

    public int checkBalance(String password);

    public String addMoney(int money);

    public String withdrawMoney(int drawMoney, String password);

    public String changePassword(String oldPassword, String newPassword);

    public double calculatTotalInterest(int years);

    /*

      //TODO any implemation we an do later

     */
}
