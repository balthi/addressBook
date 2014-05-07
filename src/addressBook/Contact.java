package addressbook;

import addressbook.format.FieldFormatter;
import addressbook.format.FormatterFactory;
import addressbook.format.XMLFieldFormatter;
import addressbook.format.JSONFieldFormatter;
import addressbook.format.PlainTextFieldFormatter;

import static addressbook.configuration.SessionConfiguration.ADDRESS_BOOK;
import static addressbook.configuration.SessionConfiguration.NL;

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
   
   @Override
   public String toString()
   {
      String out = (name + NL + address + NL + city + ", " + state + " " + zip + NL);
      return out;
   }
}