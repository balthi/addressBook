package outputFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;
import junit.framework.TestCase;

import static configuration.SessionConfiguration.NL;

public class JSONFieldFormatter_Test extends TestCase
{
   private JSONFieldFormatter formatter;
   private static final String EXPECTED = ("{\"person\":\"Bob Wilson\","
                                          + "\"address\":\"123 Groovy St.\","
                                          + "\"city\":\"Austin\","
                                          + "\"state\":\"TX\","
                                          + "\"zip\":\"78755\"}" + NL);
                               
   private static final String[] FIELDS = {"person", "address", "city", "state", "zip"};
   private static final String[] VALUES = {"Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755"};
   private static final String FILE_PATH = "R\\output\\test\\JSONTestFile.json";
   private URI testFile;
      
   public void setUp()
   {
      formatter = new JSONFieldFormatter();
      File f = new File(FILE_PATH);
      testFile = f.toURI();
   }
   
   public void testWriteToFile()
   {
      formatter.writeToFile(FIELDS, VALUES, testFile);
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