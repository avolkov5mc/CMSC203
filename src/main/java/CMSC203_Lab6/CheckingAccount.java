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
public class CheckingAccount extends BankAccount {

    private static final double FEE = 0.15;

    public CheckingAccount(String name, double amt){
        super(name, amt);
        setAccountNumber(getAccountNumber()+"-10");
    }
    @Override
    public boolean withdraw(double amount){
        return super.withdraw(amount + FEE);
    }
}
