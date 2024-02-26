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

public class PatientDriverApp {

    public static void displayPatient(Patient patient){
        System.out.println(patient.toString());
    }

    public static void displayProcedure(Procedure procedure){
        System.out.println(procedure.toString());
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3){
        return p1.getCharge() + p2.getCharge() + p3.getCharge();
    }

    public static void main(String[] args){
        Patient patient = new Patient("John", "P", "Doe", "123 Main Street", "New York City", "New York", 12345, "555-2852", "Jane Doe", "555-4934");

        // init procedure1 - no param constructor
        Procedure procedure1 = new Procedure();
        procedure1.setName("Tonsillectomy");
        procedure1.setDate("3/2/24");
        procedure1.setPractitioner("Dr. Edwards");
        procedure1.setCharge(1500.0);

        // init procedure2 - name+date constructor
        Procedure procedure2 = new Procedure("Appendectomy", "3/15/24");
        procedure2.setPractitioner("Dr. James");
        procedure2.setCharge(4000.0);

        // init procedure3 - full param constructor
        Procedure procedure3 = new Procedure("Wisdom Teeth Removal", "3/25/24", "Dr. Smith", 600.0);

        displayPatient(patient);
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        System.out.println("\nTotal charges: $"+calculateTotalCharges(procedure1,procedure2,procedure3));
    }
}
