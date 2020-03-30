package mobile.numbers;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class MobilePhones {
    private String myPhone;
    private ArrayList<Contacts> myContactsL;

    public MobilePhones(String myPhone) {
        this.myPhone = myPhone;
        this.myContactsL = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already in the list! ");
            return false;
        }

        myContactsL.add(contact);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundContact = findContact(oldContact);
        if(foundContact < 0){
            System.out.println(oldContact.getName() + " was not found! ");
            return false;
        }

        this.myContactsL.set(foundContact, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private int findContact(Contacts contact){
        return this.myContactsL.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i = 0; i < this.myContactsL.size(); i++) {
            Contacts contact = this.myContactsL.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean removeContacts(Contacts contact){
        if(findContact(contact) >= 0){
            this.myContactsL.remove(contact);
            System.out.println(contact.getName() + " was deleted from Contacts.");
            return true;
        }
        System.out.println("There is no such a contact");
        return false;
    }

    public String queryContacts(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContacts(String name){
        int position = findContact(name);
        if(position >=0){
            return this.myContactsL.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact list: ");
        for (int i = 0; i < this.myContactsL.size(); i++) {
            System.out.println((i+1)+ ": " +
                    this.myContactsL.get(i).getName() + " ->"+
                    this.myContactsL.get(i).getPhoneNumber());
        }
    }
}
