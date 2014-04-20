package outputFormatter;

/**
* Extends FieldFormatter. Takes a series of fields and values
* and outputs them to a file in JSON format.
*/
public class JSONFieldFormatter extends FieldFormatter
{   
   private static final String ERR_MSG = "fields and values must be of the same length";
   
   @Override
   public void writeToFile(String[] fields, String[] values, String fileName)
   {
      if(fields.length > values.length)
      {
         System.err.println(ERR_MSG);
         return;
      }
      String content = getString(fields, values);
      writeFile(content, fileName);
   }
   
   private String getString(String[] fields, String[] values)
   {
      String nl = System.getProperty("line.separator");
      int i;
      int length = fields.length;
      String output;
      
      output = ("{");
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + "\"" + fields[i] + "\":\"" + values[i] + "\"");
         if(i < length-1)
         {
            output = (output + ",");
         }
      }
      
      output = (output + "}" + nl);
      
      return output;
   }
}