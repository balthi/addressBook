package outputFormatter;

/**
* Extends FieldFormatter. Takes a series of fields and values and
* outputs them to a file in plain text.
*/
public class PlainTextFieldFormatter extends FieldFormatter
{

   @Override
   public void writeToFile(String[] fields, String[] values, String identifier, String fileName)
   {
      String content = getString(fields, values, identifier);
      writeFile(content, fileName);
   }
   
   private String getString(String[] fields, String[] values, String identifier)
   {
      String nl = System.getProperty("line.separator");
      int i;
      String output;
      
      output = (identifier + nl);
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + fields[i] + ": " + values[i] + nl);
      }
      
      output = (output + nl);
      return output;
   }
}