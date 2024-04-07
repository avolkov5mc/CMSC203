package CMSC203_Lab6;

/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: A simulation of a patient
 * Due: 4/8/24
 * Platform/compiler: Java/IntelliJ
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Alexei Volkov
 */
public class SavingsAccount extends BankAccount {

    private double apr = 2.5;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String owner, double balance){
        super(owner, balance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount original, double balance){
        super(original, balance);
        savingsNumber = original.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest(){
        deposit((getBalance() / 100.0) * (apr / 12));
    }

    @Override
    public String getAccountNumber(){
        return accountNumber;
    }
}
