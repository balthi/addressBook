package outputFormatter;

/**
* Extends FieldFormatter. Formats fields and values as plaintext.
*/
public class PlainTextFieldFormatter extends FieldFormatter
{
   
   /**
   * Appends the fields and values to the specified file
   */
   @Override
   public void writeToFile(String[] fields, String[] values, String fileName)
   {
      if(fields.length != values.length)
      {
         System.err.println(ERR_MSG);
         return;
      }
      String content = getString(fields, values);
      writeFile(content, fileName);
   }
   
   private String getString(String[] fields, String[] values)
   {
      int i;
      String output = "";
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + fields[i] + ": " + values[i] + NL);
      }
      
      output = (output + NL);
      return output;
   }
}