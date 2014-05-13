package addressbook.format;

import java.util.Map;
import static addressbook.configuration.SessionConfiguration.NL;

/**
* Extends FieldFormatter. Formats fields and values as JSON.
*/
public class JSONFieldFormatter extends FieldFormatter
{   
   @Override
   protected String getString(Map<String, String> m)
   {
      int size = m.size();
      int i = 0;
      String output;
      
      output = ("{");
      
      for(Map.Entry<String, String> entry : m.entrySet())
      {
         output = (output + "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"");
         i += 1;
         if(i < size)
         {
            output = (output + ",");
         }
      }
      
      output = (output + "}" + NL);
      
      return output;
   }
   
   @Override
   public String toString()
   {
      return("FieldFormatter: JSON");
   }
}