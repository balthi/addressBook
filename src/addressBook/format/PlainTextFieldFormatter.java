package addressbook.format;

import java.util.Map;
import static addressbook.configuration.SessionConfiguration.NL;

/**
* Extends FieldFormatter. Formats fields and values as plaintext.
*/
public class PlainTextFieldFormatter extends FieldFormatter
{
   
   @Override
   protected String getString(Map<String, String> m)
   {
      String output = "";
      
      for(Map.Entry<String, String> entry : m.entrySet())
      {
         output = (output + entry.getKey() + ": " + entry.getValue() + NL);
      }
      
      output = (output + NL);
      return output;
   }
   
   @Override
   public String toString()
   {
      return("FieldFormatter: Plaintext");
   }
}