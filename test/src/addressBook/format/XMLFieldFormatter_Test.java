package addressbook.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Scanner;
import junit.framework.TestCase;

import static addressbook.configuration.SessionConfiguration.NL;

public class XMLFieldFormatter_Test extends TestCase
{
   private XMLFieldFormatter formatter;
   private static final String BOB = "Bob Wilson";
   private static final String GROOVY = "123 Groovy St.";
   private static final String AUSTIN = "Austin";
   private static final String TX = "TX";
   private static final String AUSTIN_ZIP = "78755";
   
   private static final String PERSON = "person";
   private static final String ADDRESS = "address";
   private static final String CITY = "city";
   private static final String STATE = "state";
   private static final String ZIP = "zip";
   
   private static final String INDENT = "   "; //indent three spaces
   private static final String EXPECTED = ("<person Id=\"Bob Wilson\">" + NL
                                          + INDENT + "<address>123 Groovy St.</address>" + NL
                                          + INDENT + "<city>Austin</city>" + NL
                                          + INDENT + "<state>TX</state>" + NL
                                          + INDENT + "<zip>78755</zip>" + NL
                                          + "</person>" + NL);
   private static LinkedHashMap<String, String> map = new LinkedHashMap(5);
   private static final String FILE_PATH = "R\\output\\test\\XMLTestFile.xml";
   private URI testFile;
   
   public void setUp()
   {
      map.put(PERSON, BOB);
      map.put(ADDRESS, GROOVY);
      map.put(CITY, AUSTIN);
      map.put(STATE, TX);
      map.put(ZIP, AUSTIN_ZIP);
      formatter = new XMLFieldFormatter();
      File f = new File(FILE_PATH);
      testFile = f.toURI();
   }
   
   public void testWriteToFile()
   {
      formatter.writeToFile(map, testFile);
      File f = new File(FILE_PATH);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter("//Z");
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + NL
                     + "Expected: " + NL
                     + EXPECTED 
                     + "Found: " + NL
                     + input, input.equals(EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
}