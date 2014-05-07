package addressbook;

import addressbook.configuration.SessionConfiguration;
import java.util.Iterator;
import java.util.Scanner;

import static addressbook.configuration.SessionConfiguration.NL;
import static addressbook.configuration.SessionConfiguration.ADD;
import static addressbook.configuration.SessionConfiguration.QUIT;

public class AddressBook
{

   static SessionConfiguration sc = SessionConfiguration.getSessionConfiguration();
   static String WELCOME_MSG = NL + "Welcome to the address book. You may add contacts by "
                                 + "using the \"add\" keyword and typing an address on "
                                 + "the following lines following a typical US format. "
                                 + "You may quit the application by typing \"quit\"" + NL;
   

   public static void main(String[] args)
   {
      sc.loadSessionConfiguration();
      ContactBuilder contactBuilder = ContactBuilderFactory.createContactBuilder();
      boolean done = false;
      Scanner in = new Scanner(System.in);
      in.useDelimiter(NL);
      String choice;
      Contact contact;
      ContactList cl = new ContactList();
      Iterator<Contact> iterator = cl.iterator();
      
      System.out.println(WELCOME_MSG);
      
      do
      {
         choice = in.next();
         if(choice.equals(ADD))
         {
            contact = contactBuilder.createContact();
            cl.addContact(contact);
         }
         else if(choice.equals(QUIT))
         {
            done = true;
         }
         
      } while(!done);
      
      while(iterator.hasNext())
      {
         iterator.next().writeToFile();
      }
      
   }
}