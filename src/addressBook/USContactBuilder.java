package addressbook;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static addressbook.configuration.SessionConfiguration.NL;

public class USContactBuilder implements ContactBuilder
{
   private static final String SPACE = " ";
   private String name;
   private String address;
   private String city;
   private String state;
   private String zip;
   
   
   public Contact createContact()
   {
      Scanner in = new Scanner(System.in);
      in.useDelimiter(NL);
      name = in.next();
      address = in.next();
      in.useDelimiter(", ");
      String tCity = in.next();
      in.useDelimiter(SPACE);
      try
      {
         in.skip(", ");
      }
      catch(NoSuchElementException nsee)
      {
      }
      state = in.next();
      in.useDelimiter(NL);
      String tZip = in.next();
      
      city = tCity.trim();
      zip = tZip.trim();
      
      Contact contact = new Contact(name, address, city, state, zip);
      return contact;
   }
}