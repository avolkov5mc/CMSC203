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
public class Coffee extends Beverage {

    private final boolean extraShot;
    private final boolean extraSyrup;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup){
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        // factor in extras
        if(extraShot){
            price += 0.5;
        }
        if(extraSyrup){
            price += 0.5;
        }
        return price;
    }

    @Override
    public String toString(){
        return super.toString() + ", extra shot: " + extraShot + ", extra syrup: " + extraSyrup + ", cost: " + calcPrice();
    }

    @Override
    public boolean equals(Object other){
        // check beverage equals() first
        if(!super.equals(other)){
            return false;
        }
        // check if the object is a Coffee
        if(other instanceof Coffee){
            Coffee coffee = (Coffee) other;
            // check the other coffee's details
            return extraSyrup == coffee.extraSyrup && extraShot == coffee.extraShot;
        }
        return false;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }
}
