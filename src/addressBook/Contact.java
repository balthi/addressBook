package addressBook;

import outputFormatter.FieldFormatter;
import outputFormatter.FormatterFactory;
import outputFormatter.XMLFieldFormatter;
import outputFormatter.JSONFieldFormatter;
import outputFormatter.PlainTextFieldFormatter;

import static configuration.SessionConfiguration.ADDRESS_BOOK;

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
   private FieldFormatter formatter = FormatterFactory.getFieldFormatter();
   
   /**
   * Writes the contact to a file with the 
   * specified fileName
   */
   public void writeToFile()
   {
      String[] fields = {"contact", "address", "city", "state", "zip"};
      String[] values = {name, address, city, state, zip};
      
      formatter.writeToFile(fields, values, ADDRESS_BOOK);
   }
}