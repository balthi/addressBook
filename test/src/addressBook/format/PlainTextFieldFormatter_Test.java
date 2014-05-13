package addressbook.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Scanner;
import junit.framework.TestCase;

public class PlainTextFieldFormatter_Test extends TestCase
{
   private static String NL = System.getProperty("line.separator");
   private PlainTextFieldFormatter formatter;
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
   private static final String EXPECTED = ("person: Bob Wilson" + NL
                                          + "address: 123 Groovy St." + NL
                                          + "city: Austin" + NL
                                          + "state: TX" + NL
                                          + "zip: 78755"+ NL
                                          + NL);
   private static LinkedHashMap<String, String> map = new LinkedHashMap(5);                            
   private static final String FILE_PATH = "R\\output\\test\\PlainTextTestFile.txt";
   private URI testFile;
   
   
   public void setUp()
   {
      map.put(PERSON, BOB);
      map.put(ADDRESS, GROOVY);
      map.put(CITY, AUSTIN);
      map.put(STATE, TX);
      map.put(ZIP, AUSTIN_ZIP);
      formatter = new PlainTextFieldFormatter();
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