package CMSC203_Assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public class Order implements OrderInterface, Comparable<Order> {

    private final Customer customer;
    private final List<Beverage> beverages;
    private final int orderNumber;
    private final int orderTime;
    private final Day orderDay;

    public Order(int orderTime, Day orderDay, Customer customer){
        this.orderDay = orderDay;
        this.orderTime = orderTime;
        this.customer = customer;
        beverages = new ArrayList<>();
        // create a new order number
        orderNumber = generateOrder();
    }

    public int generateOrder(){
        Random random = new Random();
        return random.nextInt(10000,90000);
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SUNDAY || orderDay == Day.SATURDAY;
    }

    public int getTotalItems(){
        return beverages.size();
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        // if out of bounds
        if(itemNo >= beverages.size()){
            return null;
        }
        return beverages.get(itemNo);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for(Beverage bev : beverages){
            total += bev.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for(Beverage bev : beverages){
            if(bev.getType() == type){
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Order o) {
        int difference = orderNumber - o.orderNumber;
        if(difference == 0){
            return 0;
        }
        if(difference < 0){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString(){
        String build = "Order Number: " + orderNumber + ", Day: " + orderDay.name().toLowerCase() + ", Time: " + orderTime + ", Customer: " + customer.toString() + ", Beverage(s):";
        build += "\n********************";
        for(Beverage b : beverages){
            build += "\n" + b;
        }
        build += "\n********************";
        return build;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }
}
