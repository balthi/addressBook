package addressbook.format;

import static addressbook.configuration.SessionConfiguration.NL;

/**
* Extends FieldFormatter. Formats fields and values as plaintext.
*/
public class PlainTextFieldFormatter extends FieldFormatter
{
   
   @Override
   protected String getString(String[] fields, String[] values)
   {
      int i;
      String output = "";
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + fields[i] + ": " + values[i] + NL);
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