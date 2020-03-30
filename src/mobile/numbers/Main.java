package mobile.numbers;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhones myMoblePhone = new MobilePhones("0888862329");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while(!quit){
            System.out.println("\nEnter action: (6 to show avaible actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    myMoblePhone.printContacts();
                    break;
                case 2:
                    addNewContacts();
                    break;
                case 3:
                    updateContacts();
                    break;
                case 4:
                    removeContacts();
                    break;
                case 5:
                    queryContacts();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }
    private static void queryContacts(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = myMoblePhone.queryContacts(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name :" + existingContactRecord.getName() + " , phone number: " + existingContactRecord.getPhoneNumber());
    }

    private static void removeContacts(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = myMoblePhone.queryContacts(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }

        if(myMoblePhone.removeContacts(existingContactRecord)){
            System.out.println(existingContactRecord + " was successfully deleted from contacts list.");
        }else{
            System.out.println("Error deleting record.");
        }
    }

    private static void addNewContacts(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContacts(name,number);
        if(myMoblePhone.addNewContact(newContact)){
            System.out.println("New contact added: "+ name + " -> " +
                    number);
        }else{
            System.out.println("Cannot add, " + name + " is already in the list.");
        }
    }

    private static void updateContacts(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = myMoblePhone.queryContacts(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContacts(newName,newNumber);
        if(myMoblePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record.");
        }else{
            System.out.println("Error updating record.");
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions(){
        System.out.println("\nAvaible actions:\npress:");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add new contact\n" +
                "3 - to update an existing contact\n"+
                "4 - to remove an existing contact\n"+
                "5 - query if contact exists\n"+
                "6 - to print a list of availe actions");
        System.out.println("Choose your action: ");
    }
}


