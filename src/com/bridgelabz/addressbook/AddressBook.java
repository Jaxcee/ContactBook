package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter methods

    // Setter methods
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display method
    public void displayContact() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter City: ");
        String city = scanner.nextLine();

        System.out.println("Enter State: ");
        String state = scanner.nextLine();

        System.out.println("Enter ZIP: ");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        AddressBook newContact = new AddressBook(firstName, lastName, address, city, state, zip, phoneNumber, email);
        System.out.println(newContact);
        newContact.displayContact();

        System.out.println("Do you want to edit or delete any contact? (edit/delete/no)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("edit")) {
            System.out.println("What do you want to edit? (address/city/state/zip/phoneNumber/email)");
            String fieldToEdit = scanner.nextLine();
            System.out.println("Enter new value:");
            String newValue = scanner.nextLine();

            switch (fieldToEdit) {
                case "address":
                    newContact.setAddress(newValue);
                    break;
                case "city":
                    newContact.setCity(newValue);
                    break;
                case "state":
                    newContact.setState(newValue);
                    break;
                case "zip":
                    newContact.setZip(newValue);
                    break;
                case "phoneNumber":
                    newContact.setPhoneNumber(newValue);
                    break;
                case "email":
                    newContact.setEmail(newValue);
                    break;
                default:
                    System.out.println("Invalid field to edit!");
            }

            System.out.println("Contact updated:");
            newContact.displayContact();
        } else if (choice.equalsIgnoreCase("delete")) {
            System.out.println("Are you sure you want to delete this contact? (yes/no)");
            String deleteChoice = scanner.nextLine();
            if (deleteChoice.equalsIgnoreCase("yes")) {
                newContact = null;
                System.out.println("Contact deleted.");
            }
        } else {
            System.out.println("No changes made.");
        }

        scanner.close();
    }
}
