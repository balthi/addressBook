package outputFormatter;

/**
* Extends FieldFormatter. Formats fields and values as XML.
*/
public class XMLFieldFormatter extends FieldFormatter
{
   private static final String INDENT = "   "; //Default indent is three spaces
   
   @Override
   protected String getString(String[] fields, String[] values)
   {
      int i;
      String output;
      
      output = ("<" + fields[0] + " Id=\"" + values[0] + "\">" + NL);
      
      for(i=1; i<fields.length; i++)
      {
         output = (output + INDENT + "<" + fields[i] + ">" + values[i] + "</" + fields[i] + ">" + NL);
      }
      
      output = (output + "</" + fields[0] + ">" + NL);
      
      return output;
   }
}