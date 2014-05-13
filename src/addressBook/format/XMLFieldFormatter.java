package addressbook.format;

import java.util.Map;
import static addressbook.configuration.SessionConfiguration.NL;

/**
* Extends FieldFormatter. Formats fields and values as XML.
*/
public class XMLFieldFormatter extends FieldFormatter
{
   private static final String INDENT = "   "; //Default indent is three spaces
   
   @Override
   protected String getString(Map<String, String> m)
   {
      int i = 0;
      String output = "";
      String label = "";
      
      //output = ("<" + fields[0] + " Id=\"" + values[0] + "\">" + NL);
      
      for(Map.Entry<String, String> entry : m.entrySet())
      {
         if(i==0)
         {
            label = entry.getKey();
            output = ("<" + label + " Id=\"" + entry.getValue() + "\">" + NL);
            i += 1;
         }
         else
         {
            output = (output + INDENT + "<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">" + NL);
         }
      }
      
      output = (output + "</" + label + ">" + NL);
      
      return output;
   }
   
   @Override
   public String toString()
   {
      return("FieldFormatter: XML");
   }
}