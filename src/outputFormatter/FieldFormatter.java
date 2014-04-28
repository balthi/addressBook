package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

import static configuration.SessionConfiguration.NL;

/**
* Abstract class formats fields and values to specific format.
*/
public abstract class FieldFormatter 
{
   protected static final String ERR_MSG = "fields and values must be the same length";
   
   /**
   * Appends the fields and values to the file specified
   */
   public void writeToFile(String[] fields, String[] values, URI fileName)
   {
      if(fields.length != values.length)
      {
         System.err.println(ERR_MSG);
         return;
      }
      String content=getString(fields, values);
      writeFile(content, fileName);

   }
   
   protected String getString(String[] fields, String[] values)
   {
      int i;
      String output = "";
      
      for(i=0; i<fields.length; i++)
      {
         output = (output + fields[i] + " " + values[i] + NL);
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