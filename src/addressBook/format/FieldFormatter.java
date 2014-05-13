package addressbook.format;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

import static addressbook.configuration.SessionConfiguration.NL;

/**
* Abstract class formats fields and values to specific format.
*/
public abstract class FieldFormatter 
{
   
   /**
   * Appends the fields and values to the file specified
   */
   public void writeToFile(Map<String, String> m, URI fileName)
   {
      String content=getString(m);
      writeFile(content, fileName);

   }
   
   protected String getString(Map<String, String> m)
   {
      String output = "";
      
      for(Map.Entry<String, String> entry : m.entrySet())
      {
         output = (output + entry.getKey() + " " + entry.getValue() + NL);
      }
      return output;
   }
      
   protected void writeFile(String content, URI fileName)
   {
      File f;
      FileWriter fr;
      
      try
      {
         f = new File(fileName);
         
         if(!f.exists())
         {
            try 
            {
               f.createNewFile();
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
         }
         else
         {
            try
            {
               f.setWritable(true);
            }
            catch(SecurityException se)
            {
               se.printStackTrace();
            }
         }
         
         try
         {
            fr = new FileWriter(f, true);
            fr.write(content);
            fr.close();
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(NullPointerException npe)
      {
         npe.printStackTrace();
      }  
   }
}