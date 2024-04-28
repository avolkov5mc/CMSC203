package CMSC203_Assignment6;

import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterface {

    private final List<Order> orders;

    public BevShop(){
        orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= 8 && time <= 23;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits <= getMaxNumOfFruits();
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() >= getMaxOrderForAlcohol();
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        orders.add(new Order(time, day, new Customer(customerName, customerAge)));
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if(isEligibleForMore()){
            System.out.println("You have reached the maximum number of alcoholic drinks per order.");
            return;
        }
        if(!isValidAge(getCurrentOrder().getCustomer().getAge())){
            System.out.println("You are too young to purchase alcohol.");
            return;
        }
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getOrderNumber() == orderNo){
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if(index == -1){
            return -1;
        }
        return orders.get(index).calcOrderTotal();
    }

    @Override
    public double totalMonthlySale() {
        double total = 0.0;
        for(Order order : orders){
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        // if empty, return null
        if(orders.size() == 0){
            return null;
        }
        return orders.get(orders.size()-1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        // if out of bounds
        if(index < 0 || index >= orders.size()){
            return null;
        }
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        int min;
        for(int i = 0; i < orders.size()-1; i++){
            min = i;
            for(int j = i+1; j < orders.size(); j++){
                // if this order is smaller than previous min
                if(orders.get(j).compareTo(orders.get(min)) < 0){
                    min = j;
                }
            }
            // swap places
            Order temp = orders.get(min);
            orders.set(min, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString(){
        String build = "Orders: ";
        build += "================================";
        for(Order order : orders){
            build += "\n" + order.toString();
        }
        build += "================================";
        build += "\nTotal Monthly Sale: " + totalMonthlySale();
        return build;
    }
}
