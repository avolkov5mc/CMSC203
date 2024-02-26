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

public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int ZIP;
    private String phone;
    private String e_Name;
    private String e_Phone;

    public Patient(){}
    public Patient(String f, String m, String l){
        firstName = f;
        middleName = m;
        lastName = l;
    }
    public Patient(String firstName, String middleName, String lastName, String street, String city, String state, int ZIP, String phone, String e_Name, String e_Phone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
        this.phone = phone;
        this.e_Name = e_Name;
        this.e_Phone = e_Phone;
    }

    public String buildFullName(){
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress(){
        return street + " " + city + " " + state + " " + ZIP;
    }

    public String buildEmergencyContact(){
        return e_Name + " " + e_Phone;
    }

    public String toString(){
        return "Patient Info:" + "\n  Name: " + buildFullName() + "\n  Address: " + buildAddress() + "\n  Emergency Contact: " + buildEmergencyContact();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyName() {
        return e_Name;
    }

    public void setEmergencyName(String e_Name) {
        this.e_Name = e_Name;
    }

    public String getEmergencyPhone() {
        return e_Phone;
    }

    public void setEmergencyPhone(String e_Phone) {
        this.e_Phone = e_Phone;
    }
}
