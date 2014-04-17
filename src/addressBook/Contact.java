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
   public Contact(String name, String address, String city, String state, String zip, String outputFormat)
   {
      this.name = name;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.lastUpdated = new Date();
      
      outputFormat = outputFormat.toLowerCase();
      switch (outputFormat.charAt(0)) 
      {
         case 'x':
            this.formatter = new XMLFieldFormatter();
            break;
         case 'j':
            this.formatter = new JSONFieldFormatter();
            break;
         case 'p':
            this.formatter = new PlainTextFieldFormatter();
            break;
         default:
            this.formatter = new PlainTextFieldFormatter();
            break;
      }
   }
   
   private String name;
   private String address;
   private String city;
   private String state;
   private String zip;
   private Date lastUpdated;
   private FieldFormatter formatter;
   
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
      return this.address;
   }
   
   /**
   * Returns the contact's city
   */
   public String getCity()
   {
      return this.city;
   }
   
   /**
   * Returns the contact's name
   */
   public String getName()
   {
      return this.name;
   }
   
   /**
   * Returns the contact's state
   */
   public String getState()
   {
      return this.state;
   }
   
   /**
   * Returns the contact's zip code
   */
   public String getZip()
   {
      return this.zip;
   }
   
   /**
   * Set the formatting standard for file or console writing.
   * String must be "xml", "json" or "plain"
   */
   public void setFormatter(String outputFormat)
   {
      outputFormat = outputFormat.toLowerCase();
      switch (outputFormat.charAt(0)) 
      {
         case 'x':
            this.formatter = new XMLFieldFormatter();
            break;
         case 'j':
            this.formatter = new JSONFieldFormatter();
            break;
         case 'p':
            this.formatter = new PlainTextFieldFormatter();
            break;
         default:
            System.err.println("Invalid output format. Valid formats are \"xml\", \"json\", and \"plain\"");
            break;
      }
   }
   
   /**
   * Write the contact to the file specified
   */
   public void writeToFile(String file)
   {
      String[] fields = {"name", "address", "city", "state", "zip", "updated"};
      String[] values = {this.name, this.address, this.city, this.state, this.zip, this.lastUpdated.toString()};
      
      formatter.writeToFile(fields, values, 6, "contact", file);
   }
}