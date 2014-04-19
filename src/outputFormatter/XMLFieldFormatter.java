package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;

public class XMLFieldFormatter extends FieldFormatter
{

   private static final String DIRECTORY = "R\\output\\";
   private static final String EXTENSION = ".xml";
   private static final String INDENT = "   "; //Default indent is three spaces
   
   @Override
   public void writeToFile(String[] fields, String[] values, int length, String identifier, String container)
   {
      String content=getString(fields, values, length, identifier);
      writeFile(content, DIRECTORY, EXTENSION, container);
   }
   
   private String getString(String[] fields, String[] values, int length, String identifier)
   {
      String nl = System.getProperty("line.separator");
      int i;
      String output;
      
      output = ("<" + identifier + " " + fields[0] + "=\"" + values[0] + "\">" + nl);
      
      for(i=0; i<length; i++)
      {
         output = (output + INDENT + "<" + fields[i] + ">" + values[i] + "</" + fields[i] + ">" + nl);
      }
      
      output = (output + "</" + identifier + ">" + nl);
      
      return output;
   }
}