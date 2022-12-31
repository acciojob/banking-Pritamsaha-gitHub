package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if (amount>getBalance()){
            throw new Exception("Insufficient Balance");
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest=(getBalance()*years*rate)/100;
        double finalAmount=getBalance()+interest;
        return finalAmount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double temp=1+(rate/times);


        double base = getBalance()*temp;
        int power = times*years;
        double result = 1;
        while (power != 0) {
            result = result * base;
            power--;
        }
        return getBalance()+result;
    }

}
