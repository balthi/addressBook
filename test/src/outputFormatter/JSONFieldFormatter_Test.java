package outputFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;

public class JSONFieldFormatter_Test extends TestCase
{
   private static String nl = System.getProperty("line.separator");
   private JSONFieldFormatter formatter;
   private static final String EXPECTED = ("{\"person\":\"Bob Wilson\","
                                          + "\"address\":\"123 Groovy St.\","
                                          + "\"city\":\"Austin\","
                                          + "\"state\":\"TX\","
                                          + "\"zip\":\"78755\"}" + nl);
                               
   private static final String[] FIELDS = {"person", "address", "city", "state", "zip"};
   private static final String[] VALUES = {"Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755"};
   private static final String IDENTIFIER = "contact";
   private static final String FILE_PATH = "R\\output\\test\\JSONTestFile.json";
      
   public void setUp()
   {
      formatter = new JSONFieldFormatter();
   }
   
   public void testWriteToFile()
   {
      formatter.writeToFile(FIELDS, VALUES, FILE_PATH);
      File f = new File(FILE_PATH);
      try
      {
         Scanner in = new Scanner(f);
         in.useDelimiter("//Z");
         String input = in.next();
         in.close();
         System.out.println(input);
         assertTrue("Error in testWriteToFile: incorrect string found" + nl
                     + "Expected: " + nl
                     + EXPECTED 
                     + "Found: " + nl
                     + input, input.equals(EXPECTED));
         f.delete();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
   }
}