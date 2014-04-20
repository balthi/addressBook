package addressBook;

import java.util.Date;
import outputFormatter.FieldFormatter;
import outputFormatter.XMLFieldFormatter;
import outputFormatter.JSONFieldFormatter;
import outputFormatter.PlainTextFieldFormatter;

public class Contact 
{
   /**
   * Constructs a contact object with no output formatter.
   */
   public Contact(String name, String address, String city, String state, String zip)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.lastUpdated = new Date();
   }
   
   private String name;
   private String address;
   private String city;
   private String state;
   private String zip;
   private Date lastUpdated;
   private FieldFormatter formatter;
   
   private static String XML = ".xml";
   private static String JSON = ".json";
   private static String PLAIN = ".txt";
   
   /**
   * Returns true if name, address and zip fields in both contacts are the same.
   */
   public boolean equals(Contact c)
   {
      return (this.name.equals(c.getName()) && this.address.equals(c.getAddress()) && this.zip.equals(c.getZip()));
   }
   
   /**
   * Returns the contact's address
   */
   public String getAddress()
   {
      return address;
   }
   
   /**
   * Returns the contact's city
   */
   public String getCity()
   {
      return city;
   }
   
   /**
   * Returns the contact's name
   */
   public String getName()
   {
      return name;
   }
   
   /**
   * Returns the contact's state
   */
   public String getState()
   {
      return state;
   }
   
   /**
   * Returns the contact's zip code
   */
   public String getZip()
   {
      return zip;
   }
   
   /**
   * Sets the address for the contact
   */
   public void setAddress(String address)
   {
      this.address = address;
      this.lastUpdated = new Date();
   }
   
   /**
   * Sets the city for the contact
   */
   public void setCity(String city)
   {
      this.city = city;
      this.lastUpdated = new Date();
   }
   
   /**
   * Sets the state for the contact
   */
   public void setState(String state)
   {
      this.state = state;
      this.lastUpdated = new Date();
   }
   
   /*
   * Sets the zip code for the contact
   */
   public void setZip(String zip)
   {
      this.zip = zip;
      this.lastUpdated = new Date();
   }
   
   /**
   * Write the contact to the file specified
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
      String[] fields = {"person", "address", "city", "state", "zip", "updated"};
      String[] values = {name, address, city, state, zip, lastUpdated.toString()};
      
      formatter.writeToFile(fields, values, fileName);
   }
}