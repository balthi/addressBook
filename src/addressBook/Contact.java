package addressbook;

import addressbook.format.FieldFormatter;
import addressbook.format.FormatterFactory;
import java.util.LinkedHashMap;

import static addressbook.configuration.SessionConfiguration.ADDRESS_BOOK;
import static addressbook.configuration.SessionConfiguration.NL;

public class Contact 
{
   
   /**
   * Constructs a contact object.
   */
   public Contact() {
   }
   
   /**
   * Constructs a contact object with 
   * the given attributes
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
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setAddress(String address)
   {
      this.address = address;
   }
   
   public void setCity(String city)
   {
      this.city = city;
   }
   
   public void setState(String state)
   {
      this.state = state;
   }
   
   public void setZip(String zip)
   {
      this.zip = zip;
   }
   
   /**
   * Writes the contact to a file with the 
   * specified fileName
   */
   public void writeToFile()
   {
      LinkedHashMap<String, String> map = new LinkedHashMap(5);
      map.put("contact", name);
      map.put("address", address);
      map.put("city", city);
      map.put("state", state);
      map.put("zip", zip);
      
      FormatterFactory.getFieldFormatter().writeToFile(map, ADDRESS_BOOK);
   }
   
   @Override
   public String toString()
   {
      String out = (name + NL + address + NL + city + ", " + state + " " + zip + NL);
      return out;
   }
}