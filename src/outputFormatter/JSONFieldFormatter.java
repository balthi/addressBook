package outputFormatter;

/**
* Extends FieldFormatter. Formats fields and values as JSON.
*/
public class JSONFieldFormatter extends FieldFormatter
{
   
   /*
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
      int last = fields.length - 1;
      String output;
      
      output = ("{");
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + "\"" + fields[i] + "\":\"" + values[i] + "\"");
         if(i < last)
         {
            output = (output + ",");
         }
      }
      
      output = (output + "}" + NL);
      
      return output;
   }
}