package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Abstract class formats fields and values to specific format.
*/
public abstract class FieldFormatter 
{
   protected static final String NL = System.getProperty("line.separator");
   protected static final String ERR_MSG = "fields and values must be the same length";
   
   /**
   * Appends the fields and values to the file specified
   */
   public void writeToFile(String[] fields, String[] values, String fileName)
   {
   }
      
   protected void writeFile(String content, String fileName)
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