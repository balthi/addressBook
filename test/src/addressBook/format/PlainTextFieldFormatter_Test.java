package addressbook.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;
import junit.framework.TestCase;

public class PlainTextFieldFormatter_Test extends TestCase
{
   private static String NL = System.getProperty("line.separator");
   private PlainTextFieldFormatter formatter;
   private static final String EXPECTED = ("person: Bob Wilson" + NL
                                          + "address: 123 Groovy St." + NL
                                          + "city: Austin" + NL
                                          + "state: TX" + NL
                                          + "zip: 78755"+ NL
                                          + NL);
                               
   private static final String[] FIELDS = {"person", "address", "city", "state", "zip"};
   private static final String[] VALUES = {"Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755"};
   private static final String FILE_PATH = "R\\output\\test\\PlainTextTestFile.txt";
   private URI testFile;
   
   
   public void setUp()
   {
      formatter = new PlainTextFieldFormatter();
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