package CMSC203_Assignment6;

import java.util.Scanner;

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
public class BevShopDriverApp {

    private static void startOrder(BevShop shop){
        System.out.println("Welcome to the Beverage Shop! Please enter your order: ");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your name? ");
        String customerName = keyboard.nextLine();
        System.out.print("How old are you? ");
        int customerAge = keyboard.nextInt();
        keyboard.nextLine();

        // check customer age
        if(customerAge >= shop.getMinAgeForAlcohol()){
            System.out.println("You are eligible to buy alcoholic beverages.");
        }
        else{
            System.out.println("Unfortunately, you can not buy alcoholic beverages.");
        }

        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(12, Day.THURSDAY, customer);

        for(int i = 0; i < 2; i++){
            System.out.println("You will now order a Smoothie.");

            System.out.print("Beverage Name? ");
            String bevName = keyboard.nextLine();

            Size bevSize = getBevSize(keyboard);

            System.out.print("How many fruit do you want? ");
            int fruits = keyboard.nextInt();
            keyboard.nextLine();
            if(fruits < 0){
                System.out.println("You won't get any fruit.");
                fruits = 0;
            }
            else if(fruits >= shop.getMaxNumOfFruits()){
                fruits = shop.getMaxNumOfFruits();
                System.out.println("You'll get the maximum number of fruits, " + fruits);
            }
            else{
                System.out.println("You'll get " + fruits + " fruit(s).");
            }

            System.out.print("Do you want extra protein? (true/false) ");
            boolean protein = Boolean.parseBoolean(keyboard.nextLine());

            order.addNewBeverage(bevName, bevSize, fruits, protein);
            System.out.println("Your full order is currently: ");
            System.out.println(order);
        }

        for(int i = 0; i < 2; i++){
            System.out.println("You will now order a Coffee.");
            System.out.print("Beverage Name? ");
            String bevName = keyboard.nextLine();
            Size bevSize = getBevSize(keyboard);

            System.out.print("Do you want extra shot? (true/false) ");
            boolean shot = Boolean.parseBoolean(keyboard.nextLine());

            System.out.print("Do you want extra syrup? (true/false) ");
            boolean syrup = Boolean.parseBoolean(keyboard.nextLine());

            order.addNewBeverage(bevName, bevSize, shot, syrup);
            System.out.println("Your full order is currently: ");
            System.out.println(order);
        }

        // If the customer is allowed to drink
        if(customer.getAge() >= shop.getMinAgeForAlcohol()){
            for(int i = 0; i < 2; i++){
                System.out.println("You will now order an Alcoholic Beverage.");

                System.out.print("Beverage Name? ");
                String bevName = keyboard.nextLine();

                Size bevSize = getBevSize(keyboard);

                order.addNewBeverage(bevName, bevSize);
                System.out.println("Your full order is currently: ");
                System.out.println(order);
            }
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Your order is complete. Your total is: " + order.calcOrderTotal());
        System.out.println("Thank you for purchasing from the Beverage Shop.");
        System.out.println("-----------------------------------------------");
    }

    private static Size getBevSize(Scanner keyboard){
        while(true){
            System.out.print("What Size? ");
            try{
                return Size.valueOf(keyboard.nextLine().toUpperCase());
            }
            catch(IllegalArgumentException e){
                System.out.println("Invalid selection. Please choose small, medium, or large. (Case insensitive)");
            }
        }
    }

    public static void main(String[] args){
        BevShop shop = new BevShop();
        System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());

        startOrder(shop);
    }
}
