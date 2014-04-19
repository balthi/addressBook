package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;

public class JSONFieldFormatter extends FieldFormatter
{

   private static final String DIRECTORY = "R\\output\\";
   private static final String EXTENSION = ".json";
   
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
      
      output = ("{\"" + identifier + "\": { ");
      
      for(i=0; i<length; i++)
      {
         output = (output + "\"" + fields[i] + "\":\"" + values[i] + "\"");
         if(i < length-1)
         {
            output = (output + ", ");
         }
         else
         {
            output = (output + " ");
         }
      }
      
      output = (output + "} }" + nl);
      
      return output;
   }
}