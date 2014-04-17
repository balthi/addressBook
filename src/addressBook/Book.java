package addressBook;

import java.util.ArrayList;

public class Book 
{

   public Book(String name)
   {
      this.name = name;
      this.contacts = new ArrayList<Contact>(10);
   }
   
   public Book(String name, int numberOfContacts)
   {
      this.name = name;
      this.contacts = new ArrayList<Contact>(numberOfContacts);
   }

   private String name;
   private ArrayList<Contact> contacts;
   
   /**
   * Add a new contact to the book with the given information
   */
   public void addContact(String name, String address, String city, String state, String zip)
   {
      //TODO: insert method body here
   }
   
   /**
   * Add the new contact to the book
   */
   public void addContact(Contact c)
   {
      //TODO: insert method body here
   }

}