package outputFormatter;

import static configuration.SessionConfiguration.FORMAT;
import static configuration.SessionConfiguration.XML;
import static configuration.SessionConfiguration.JSON;
import static configuration.SessionConfiguration.PLAIN;

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