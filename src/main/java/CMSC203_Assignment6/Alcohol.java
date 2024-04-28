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
public class Alcohol extends Beverage {

    private final boolean isWeekend;

    public Alcohol(String name, Size size, boolean isWeekend){
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        // factor in extras
        if(isWeekend){
            price += 0.6;
        }
        return price;
    }

    @Override
    public String toString(){
        return super.toString() + ", weekend fee: " + isWeekend + ", cost: " + calcPrice();
    }

    @Override
    public boolean equals(Object other){
        // check beverage equals() first
        if(!super.equals(other)){
            return false;
        }
        // check if the object is alcohol
        if(other instanceof Alcohol){
            Alcohol alcohol = (Alcohol) other;
            // check the other alcohol's details
            return isWeekend == alcohol.isWeekend;
        }
        return false;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
