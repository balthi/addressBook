package outputFormatter;

/**
* Extends FieldFormatter. Takes a series of fields and values and
* outputs them to a file in XML format.
*/
public class XMLFieldFormatter extends FieldFormatter
{
   private static final String INDENT = "   "; //Default indent is three spaces
   private static final String ERR_MSG = "fields and values must be of the same length";
   
   @Override
   public void writeToFile(String[] fields, String[] values, String fileName)
   {
      if(fields.length > values.length)
      {
         System.err.println(ERR_MSG);
         return;
      }
      String content=getString(fields, values);
      writeFile(content, fileName);
   }
   
   private String getString(String[] fields, String[] values)
   {
      String nl = System.getProperty("line.separator");
      int i;
      String output;
      
      output = ("<" + fields[0] + " Id=\"" + values[0] + "\">" + nl);
      
      for(i=1; i<fields.length; i++)
      {
         output = (output + INDENT + "<" + fields[i] + ">" + values[i] + "</" + fields[i] + ">" + nl);
      }
      
      output = (output + "</" + fields[0] + ">" + nl);
      
      return output;
   }
}