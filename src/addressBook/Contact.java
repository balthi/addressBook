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
   
   /*
   * Constructs a contact object with the given output formatter.
   */
   public Contact(String name, String address, String city, String state, String zip, FieldFormatter formatter)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.lastUpdated = new Date();
      this.formatter = formatter;
   }
   
   private String name;
   private String address;
   private String city;
   private String state;
   private String zip;
   private Date lastUpdated;
   private FieldFormatter formatter;
   
   /**
   * Sets XML as the output format
   */
   public static final FieldFormatter XML = new XMLFieldFormatter();
   
   /**
   * Sets JSON as the output format
   */
   public static final FieldFormatter JSON = new JSONFieldFormatter();
   
   /**
   * Sets Plaintext as the output format
   */
   public static final FieldFormatter PLAIN = new PlainTextFieldFormatter();
   
   /**
   * Returns true if all fields in both contacts are the same.
   */
   public boolean equals(Contact c)
   {
      return (this.name.equals(c.getName()) && this.address.equals(c.getAddress()) && this.city.equals(c.getCity()) && this.state.equals(c.getState()) && this.zip.equals(c.getZip()));
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
   * Set the formatting standard for file or console writing.
   * String must be "xml", "json" or "plain"
   */
   public void setFormatter(FieldFormatter formatter)
   {
      this.formatter = formatter;
   }
   
   /**
   * Write the contact to the file specified
   */
   public void writeToFile(String file)
   {
      String[] fields = {"name", "address", "city", "state", "zip", "updated"};
      String[] values = {name, address, city, state, zip, lastUpdated.toString()};
      
      formatter.writeToFile(fields, values, 6, "contact", file);
   }
}