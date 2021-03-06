package outputFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import junit.framework.TestCase;

public class XMLFieldFormatter_Test extends TestCase
{
   private static String nl = System.getProperty("line.separator");
   private XMLFieldFormatter formatter;
   private static final String INDENT = "   "; //indent three spaces
   private static final String EXPECTED = ("<person Id=\"Bob Wilson\">" + nl
                                          + INDENT + "<address>123 Groovy St.</address>" + nl
                                          + INDENT + "<city>Austin</city>" + nl
                                          + INDENT + "<state>TX</state>" + nl
                                          + INDENT + "<zip>78755</zip>" + nl
                                          + "</person>" + nl);
   private static final String[] FIELDS = {"person", "address", "city", "state", "zip"};
   private static final String[] VALUES = {"Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755"};
   private static final String FILE_PATH = "R\\output\\test\\XMLTestFile.xml";
   
   public void setUp()
   {
      formatter = new XMLFieldFormatter();
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