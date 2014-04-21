package outputFormatter;

/**
* Extends FieldFormatter. Formats fields and values as JSON.
*/
public class JSONFieldFormatter extends FieldFormatter
{
   
   @Override
   protected String getString(String[] fields, String[] values)
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