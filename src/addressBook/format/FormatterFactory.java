package addressbook.format;

import static addressbook.configuration.SessionConfiguration.FORMAT;
import static addressbook.configuration.SessionConfiguration.XML;
import static addressbook.configuration.SessionConfiguration.JSON;
import static addressbook.configuration.SessionConfiguration.PLAIN;

public class FormatterFactory
{
   private static FieldFormatter formatter;
   
   public static FieldFormatter getFieldFormatter()
   {
      if(formatter == null)
      {
         switch(FORMAT)
         {
            case XML:
               formatter =  new XMLFieldFormatter();
               break;
            case JSON:
               formatter = new JSONFieldFormatter();
               break;
            case PLAIN:
               formatter = new PlainTextFieldFormatter();
               break;
            default:
               formatter = new XMLFieldFormatter();
               break;
         }
      }
      return formatter; 
   }
}