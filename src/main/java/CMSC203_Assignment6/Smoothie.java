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
public class Smoothie extends Beverage {

    private final int numFruits;
    private final boolean hasProtein;

    public Smoothie(String name, Size size, int numFruits, boolean hasProtein){
        super(name, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.hasProtein = hasProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        // factor in extras
        if(hasProtein){
            price += 1.5;
        }
        price += 0.5 * numFruits;
        return price;
    }

    @Override
    public String toString(){
        return super.toString() + ", number of fruit: " + numFruits + ", has protein: " + hasProtein + ", cost: " + calcPrice();
    }

    @Override
    public boolean equals(Object other){
        // check beverage equals() first
        if(!super.equals(other)){
            return false;
        }
        // check if the object is a smoothie
        if(other instanceof Smoothie){
            Smoothie smoothie = (Smoothie) other;
            // check the other smoothie's details
            return numFruits == smoothie.numFruits && hasProtein == smoothie.hasProtein;
        }
        return false;
    }

    public int getNumFruits() {
        return numFruits;
    }

    public boolean isHasProtein() {
        return hasProtein;
    }
}
