package addressbook;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static addressbook.configuration.SessionConfiguration.NL;

public class USContactBuilder implements ContactBuilder
{
   private static final String SPACE = " ";
   
   public Contact createContact()
   {
      Contact contact = new Contact();
      Scanner in = new Scanner(System.in);
      in.useDelimiter(NL);
      contact.setName(in.next());
      contact.setAddress(in.next());
      in.useDelimiter(", ");
      contact.setCity(in.next().trim());
      in.useDelimiter(SPACE);
      try
      {
         in.skip(", ");
      }
      catch(NoSuchElementException nsee)
      {
      }
      contact.setState(in.next());
      in.useDelimiter(NL);
      contact.setZip(in.next().trim());
      
      return contact;
   }
}