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
public abstract class Beverage {

    private final String name;
    private final Type type;
    private final Size size;
    private final double basePrice = 2.0;
    private final double sizePrice = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice(){
        // assumes size enum is ordered from smallest to biggest
        return basePrice + sizePrice * (size.ordinal());
    }

    public abstract double calcPrice();

    @Override
    public String toString(){
        return name + "," + size.name().toLowerCase();
    }

    @Override
    public boolean equals(Object other){
        // check if the object is a beverage
        if(other instanceof Beverage){
            Beverage otherBev = (Beverage) other;
            // check the other beverage's details
            return name.equals(otherBev.name) && type == otherBev.type && size == otherBev.size;
        }
        return false;
    }

    public String getBevName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
