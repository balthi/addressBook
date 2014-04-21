package addressBook;

import outputFormatter.FieldFormatter;
import outputFormatter.XMLFieldFormatter;
import outputFormatter.JSONFieldFormatter;
import outputFormatter.PlainTextFieldFormatter;

public class Contact 
{
   /**
   * Constructs a contact object.
   */
   public Contact(String name, String address, String city, String state, String zip)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }
   
   private String name;
   private String address;
   private String city;
   private String state;
   private String zip;
   private FieldFormatter formatter;
   
   private static final String XML = ".xml";
   private static final String JSON = ".json";
   private static final String PLAIN = ".txt";
   
   /**
   * Writes the contact to the file specified
   */
   public void writeToFile(String fileName)
   {
      if(fileName.contains(XML))
      {
         formatter = new XMLFieldFormatter();
      }
      else if(fileName.contains(JSON))
      {
         formatter = new JSONFieldFormatter();
      }
      else if(fileName.contains(PLAIN))
      {
         formatter = new PlainTextFieldFormatter();
      }
      //Provide plaintext as a default formatter
      else
      {
         formatter = new PlainTextFieldFormatter();
      }
      
      String[] fields = {"person", "address", "city", "state", "zip"};
      String[] values = {name, address, city, state, zip};
      
      formatter.writeToFile(fields, values, fileName);
   }
}