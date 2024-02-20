package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.List;
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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
        List<AddressBook> addressBookList = new ArrayList<>();

        char choice;
        do {
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

            addressBookList.add(newContact);

            System.out.println("Do you want to add another contact? (y/n)");
            choice = scanner.nextLine().charAt(0);
        } while (Character.toLowerCase(choice) == 'y');


        System.out.println("Do you want to edit or delete any contact? (edit/delete/no)");
        String editOrDeleteChoice = scanner.nextLine();

        if (editOrDeleteChoice.equalsIgnoreCase("edit")) {
            // Edit contact
            System.out.println("Enter the index of the contact you want to edit:");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (index >= 0 && index < addressBookList.size()) {
                AddressBook contactToEdit = addressBookList.get(index);
                System.out.println("What do you want to edit? (address/city/state/zip/phoneNumber/email)");
                String fieldToEdit = scanner.nextLine();
                System.out.println("Enter new value:");
                String newValue = scanner.nextLine();

                switch (fieldToEdit) {
                    case "address":
                        contactToEdit.setAddress(newValue);
                        break;
                    case "city":
                        contactToEdit.setCity(newValue);
                        break;
                    case "state":
                        contactToEdit.setState(newValue);
                        break;
                    case "zip":
                        contactToEdit.setZip(newValue);
                        break;
                    case "phoneNumber":
                        contactToEdit.setPhoneNumber(newValue);
                        break;
                    case "email":
                        contactToEdit.setEmail(newValue);
                        break;
                    default:
                        System.out.println("Invalid field to edit!");
                }

                System.out.println("Contact updated:");
                contactToEdit.displayContact();
            } else {
                System.out.println("Invalid index!");
            }
        } else if (editOrDeleteChoice.equalsIgnoreCase("delete")) {
            // Delete contact
            System.out.println("Enter the index of the contact you want to delete:");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (index >= 0 && index < addressBookList.size()) {
                addressBookList.remove(index);
                System.out.println("Contact deleted.");
            } else {
                System.out.println("Invalid index!");
            }
        } else {
            System.out.println("No changes made.");
        }

        // Display all contacts
        System.out.println("Address Book:");
        for (int i = 0; i < addressBookList.size(); i++) {
            System.out.println("Contact " + (i+1) + ":");
            addressBookList.get(i).displayContact();
            System.out.println();
        }

        scanner.close();
    }
}

