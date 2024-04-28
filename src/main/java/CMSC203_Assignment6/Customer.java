package CMSC203_Assignment6;
/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: Simulates a beverage shop and orders/products
 * Due: 4/29/24
 * Platform/compiler: Java/IntelliJ
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Alexei Volkov
 */
public class Customer {

    private final String name;
    private final int age;

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Customer(Customer other){
        this.name = other.name;
        this.age = other.age;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
