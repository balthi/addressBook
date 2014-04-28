package addressBook;

import configuration.SessionConfiguration;
import java.util.Scanner;
import outputFormatter.FieldFormatter;
import outputFormatter.JSONFieldFormatter;
import outputFormatter.PlainTextFieldFormatter;
import outputFormatter.XMLFieldFormatter;

import static configuration.SessionConfiguration.NL;
import static configuration.SessionConfiguration.ADD;
import static configuration.SessionConfiguration.QUIT;

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
      
      System.out.println(WELCOME_MSG);
      
      do
      {
         choice = in.next();
         if(choice.equals(ADD))
         {
            contact = contactBuilder.createContact();
            contact.writeToFile();
         }
         else if(choice.equals(QUIT))
         {
            done = true;
         }
         
      } while(!done);
      
   }
}