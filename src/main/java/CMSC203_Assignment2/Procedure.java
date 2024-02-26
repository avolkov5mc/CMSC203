package CMSC203_Assignment2;

/*
 * Class: CMSC203 CRN 30339
 * Instructor: Grigoriy Grinberg
 * Description: A simulation of a patient
 * Due: 2/26/24
 * Platform/compiler: Java/IntelliJ
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Alexei Volkov
 */

public class Procedure {

    private String name;
    private String date;
    private String practitioner;
    private double charge;

    public Procedure(){}

    public Procedure(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Procedure(String name, String date, String practitioner, double charge) {
        this.name = name;
        this.date = date;
        this.practitioner = practitioner;
        this.charge = charge;
    }

    public String toString(){
        return "\n\tProcedure: " + name + "\n\tDate: " + date + "\n\tPractitioner: " + practitioner + "\n\tCharge: " + charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(String practitioner) {
        this.practitioner = practitioner;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
