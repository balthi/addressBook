package outputFormatter;

/**
* Extends FieldFormatter. Takes a series of fields and values and
* outputs them to a file in XML format.
*/
public class XMLFieldFormatter extends FieldFormatter
{
   private static final String INDENT = "   "; //Default indent is three spaces
   
   @Override
   public void writeToFile(String[] fields, String[] values, String identifier, String fileName)
   {
      String content=getString(fields, values, identifier);
      writeFile(content, fileName);
   }
   
   private String getString(String[] fields, String[] values, String identifier)
   {
      String nl = System.getProperty("line.separator");
      int i;
      String output;
      
      output = ("<" + identifier + " " + fields[0] + "=\"" + values[0] + "\">" + nl);
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + INDENT + "<" + fields[i] + ">" + values[i] + "</" + fields[i] + ">" + nl);
      }
      
      output = (output + "</" + identifier + ">" + nl);
      
      return output;
   }
}