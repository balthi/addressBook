package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ClassCastException;
import java.lang.NullPointerException;
import java.net.URI;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

public class SessionConfiguration
{

   private SessionConfiguration() {}
   
   //System Properties
   public static final String NL = System.getProperty("line.separator");
   public static final String USER = System.getProperty("user.name");
   private static String PROPERTIES_FILE_PATH = "R\\config\\";
   private static String PROPERTIES_FILE = PROPERTIES_FILE_PATH + USER + "Configuration.xml";
   public static URI ADDRESS_BOOK;
   private static String ADDRESS_BOOK_KEY = "addressBook";
   private static String DEFAULT_ADDRESS_BOOK_PATH = "R\\output\\";
   public static String ADD = "add";
   public static String QUIT = "quit";
   
   //Format properties
   private static String FORMAT_KEY = "format";
   private static String GET_FORMAT = "Please enter your desired format: xml, json or txt.";
   public static String FORMAT;
   public static final String XML = "xml";
   public static final String JSON = "json";
   public static final String PLAIN = "txt";
   private static String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL;
   private static String PLAIN_HEADER = "Contacts: " + NL + NL;
   
   //Region properties
   public static String REGION;
   private static String REGION_KEY = "region";
   private static String GET_REGION = "Please enter your country name.";
   private static final String US = "us";
   
   private static Properties properties = new Properties();
   private static SessionConfiguration sc;
   
   /**
   * Get the current session configuration
   */
   public static SessionConfiguration getSessionConfiguration()
   {
      if(sc == null)
      {
         sc = new SessionConfiguration();
      }
      return sc;
   }
   
   /**
   * Load session configuration details
   */
   public static void loadSessionConfiguration()
   {
      try
      {
         properties.loadFromXML(new FileInputStream(new File(PROPERTIES_FILE)));
      }
      catch(InvalidPropertiesFormatException ipfe)
      {
         ipfe.printStackTrace();
      }
      catch(IOException ioe)
      {
         //If an IOException occurs, set all properties and save them
         //to an XML file
         setRegion();
         setFormat();
         setAddressBook();
         initializeAddressBook();
         storeProperties();
      }
      catch(NullPointerException npe)
      {
         npe.printStackTrace();
      }
      
      FORMAT = properties.getProperty(FORMAT_KEY);
      REGION = properties.getProperty(REGION_KEY);
      String addressBook = properties.getProperty(ADDRESS_BOOK_KEY);
      File fAddressBook;
      try
      {
         fAddressBook = new File(addressBook);
         ADDRESS_BOOK = fAddressBook.toURI();
      }
      catch(NullPointerException nnpe)
      {
         nnpe.printStackTrace();
      }
   }
   
   //Get data format choice from user and store it in properties
   private static void setFormat()
   {
      Scanner in = new Scanner(System.in);
      String choice;
      boolean valid = false;
      
      do
      {
         System.out.println(GET_FORMAT);
         choice = in.next();
         switch(choice)
         {
            case XML:
               properties.setProperty(FORMAT_KEY, XML);
               valid = true;
               break;
            case JSON:
               properties.setProperty(FORMAT_KEY, JSON);
               valid = true;
               break;
            case PLAIN:
               properties.setProperty(FORMAT_KEY, PLAIN);
               valid = true;
               break;
         }
      } while(!valid);
   }
   
   //Pre-requisite: format is already set.
   //Using data format and user name, generate the name
   //for the user's address book. Then create the 
   //address book and add it to properties
   private static void setAddressBook()
   {
      String format = properties.getProperty(FORMAT_KEY);
      String book = "Book";
      String fileName = DEFAULT_ADDRESS_BOOK_PATH + USER + book + "." + format;
      
      File f = new File(fileName);
      try
      {
         f.createNewFile();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
      properties.setProperty(ADDRESS_BOOK_KEY, fileName);
   }
   
   //Write the initial header lines to the address book.
   //Pre-requisite: Format and Address book are already set.
   private static void initializeAddressBook()
   {
      String format = properties.getProperty(FORMAT_KEY);
      String book = properties.getProperty(ADDRESS_BOOK_KEY);
      
      try
      {
         FileWriter fr = new FileWriter(new File(book));
         
         if(format.equals(XML))
         {
            fr.write(XML_HEADER);
         }
         
         fr.close();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   private static void setRegion()
   {
      properties.setProperty(REGION_KEY, US);
      //TODO: exand this method to support multiple regions.
   }
   
   //Store the new system properties to a file
   private static void storeProperties()
   {
      OutputStream os;
      File f = new File(PROPERTIES_FILE);
      
      try
      {
         os = new FileOutputStream(f);
         try
         {
            properties.storeToXML(os, USER + " configuration saved");
            os.close();
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
         catch(NullPointerException npe)
         {
            npe.printStackTrace();
         }
         catch(ClassCastException cce)
         {
            cce.printStackTrace();
         }
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      catch(SecurityException se)
      {
         se.printStackTrace();
      }
   }
}