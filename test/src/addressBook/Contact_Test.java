package addressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;

public class Contact_Test extends TestCase
{
   private static final String BOB = "Bob Wilson";
   private static final String GROOVY = "123 Groovy St.";
   private static final String AUSTIN = "Austin";
   private static final String TX = "TX";
   private static final String AUSTIN_ZIP = "78755";
      
   private static final String XML = "R\\output\\test\\contactOne.xml";
   private static final String JSON = "R\\output\\test\\contactOne.json";
   private static final String PLAIN = "R\\output\\test\\contactOne.txt";
   
   private static String nl = System.getProperty("line.separator");
   private static final String INDENT = "   "; //indent three spaces
   private static final String EOF = "//Z";
   
   private static final String XML_EXPECTED = ("<person Id=\"Bob Wilson\">" + nl
                                          + INDENT + "<address>123 Groovy St.</address>" + nl
                                          + INDENT + "<city>Austin</city>" + nl
                                          + INDENT + "<state>TX</state>" + nl
                                          + INDENT + "<zip>78755</zip>" + nl
                                          + "</person>" + nl);
                                          
   private static final String JSON_EXPECTED = ("{\"person\":\"Bob Wilson\","
                                          + "\"address\":\"123 Groovy St.\","
                                          + "\"city\":\"Austin\","
                                          + "\"state\":\"TX\","
                                          + "\"zip\":\"78755\"}" + nl);
   
   private static final String PLAIN_EXPECTED = ("person: Bob Wilson" + nl
                                          + "address: 123 Groovy St." + nl
                                          + "city: Austin" + nl
                                          + "state: TX" + nl
                                          + "zip: 78755"+ nl
                                          + nl);
      
   private Contact contactOne;
   
   public void setUp()
   {
      this.contactOne = new Contact(BOB, GROOVY, AUSTIN, TX, AUSTIN_ZIP);
   }
   
   public void testWriteToFileXML()
   { 
      contactOne.writeToFile(XML);
      File f = new File(XML);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter(EOF);
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + nl
                     + "Expected: " + nl
                     + XML_EXPECTED 
                     + "Found: " + nl
                     + input, input.equals(XML_EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
   
   public void testWriteToFileJSON()
   { 
      contactOne.writeToFile(JSON);
      File f = new File(JSON);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter(EOF);
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + nl
                     + "Expected: " + nl
                     + JSON_EXPECTED 
                     + "Found: " + nl
                     + input, input.equals(JSON_EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
   
   public void testWriteToFilePLAIN()
   { 
      contactOne.writeToFile(PLAIN);
      File f = new File(PLAIN);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter(EOF);
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + nl
                     + "Expected: " + nl
                     + PLAIN_EXPECTED 
                     + "Found: " + nl
                     + input, input.equals(PLAIN_EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
}