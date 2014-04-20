package outputFormatter;

/**
* Extends FieldFormatter. Takes a series of fields and values
* and outputs them to a file in JSON format.
*/
public class JSONFieldFormatter extends FieldFormatter
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
      int length = fields.length;
      String output;
      
      output = ("{\"" + identifier + "\": { ");
      
      for(i=0; i<fields.length; i++)
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