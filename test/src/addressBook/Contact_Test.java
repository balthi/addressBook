package addressbook;

import addressbook.configuration.SessionConfiguration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.lang.SecurityException;
import java.util.Scanner;
import junit.framework.TestCase;

import static addressbook.configuration.SessionConfiguration.NL;
import static addressbook.configuration.SessionConfiguration.JSON;
import static addressbook.configuration.SessionConfiguration.ADDRESS_BOOK;
import static addressbook.configuration.SessionConfiguration.USER;

public class Contact_Test extends TestCase
{
   private static String PROPERTIES_FILE_PATH = "R\\config\\";
   private static String PROPERTIES_FILE = PROPERTIES_FILE_PATH + USER + "Configuration.xml";
   
   private static final String BOB = "Bob Wilson";
   private static final String GROOVY = "123 Groovy St.";
   private static final String AUSTIN = "Austin";
   private static final String TX = "TX";
   private static final String AUSTIN_ZIP = "78755";
   
   private static final String EOF = "//Z";
                                          
   private static final String JSON_EXPECTED = ("{\"contact\":\"Bob Wilson\","
                                          + "\"address\":\"123 Groovy St.\","
                                          + "\"city\":\"Austin\","
                                          + "\"state\":\"TX\","
                                          + "\"zip\":\"78755\"}" + NL);
      
   private Contact contactOne;
   
   public void setUp()
   {
      //StringBufferInputStream s = new StringBufferInputStream(JSON);
      //System.setIn(s);
      SessionConfiguration sc = SessionConfiguration.getSessionConfiguration();
      sc.loadSessionConfiguration();
      this.contactOne = new Contact(BOB, GROOVY, AUSTIN, TX, AUSTIN_ZIP);
   }
   
   public void testWriteToFileJSON()
   { 
      contactOne.writeToFile();
      File f = new File(ADDRESS_BOOK);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter(EOF);
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + NL
                     + "Expected: " + NL
                     + JSON_EXPECTED 
                     + "Found: " + NL
                     + input, input.equals(JSON_EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      
      System.out.println(PROPERTIES_FILE);
      File config = new File(PROPERTIES_FILE);
      try
      {
         config.deleteOnExit();
      }
      catch(SecurityException se)
      {
         se.printStackTrace();
      }
   }
}