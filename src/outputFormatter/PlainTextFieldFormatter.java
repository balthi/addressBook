package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;

public class PlainTextFieldFormatter extends FieldFormatter
{

   private static final String DIRECTORY = "R\\output\\";
   private static final String EXTENSION = ".txt";

   @Override
   public void writeToFile(String[] fields, String[] values, int length, String identifier, String container)
   {
      String content = getString(fields, values, length, identifier);
      writeFile(content, DIRECTORY, EXTENSION, container);
   }
   
   private String getString(String[] fields, String[] values, int length, String identifier)
   {
      String nl = System.getProperty("line.separator");
      int i;
      String output;
      
      output = (identifier + nl);
      
      for(i=0; i<length; i++)
      {
         output = (output + fields[i] + ": " + values[i] + nl);
      }
      
      output = (output + nl);
      return output;
   }
}