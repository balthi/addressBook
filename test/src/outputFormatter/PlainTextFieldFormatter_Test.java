package outputFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;

public class PlainTextFieldFormatter_Test extends TestCase
{
   private static String nl = System.getProperty("line.separator");
   private PlainTextFieldFormatter formatter;
   private static final String EXPECTED = ("person: Bob Wilson" + nl
                                          + "address: 123 Groovy St." + nl
                                          + "city: Austin" + nl
                                          + "state: TX" + nl
                                          + "zip: 78755"+ nl
                                          + nl);
                               
   private static final String[] FIELDS = {"person", "address", "city", "state", "zip"};
   private static final String[] VALUES = {"Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755"};
   private static final String IDENTIFIER = "contact";
   private static final String FILE_PATH = "R\\output\\test\\PlainTextTestFile.txt";
   
   
   public void setUp()
   {
      formatter = new PlainTextFieldFormatter();
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