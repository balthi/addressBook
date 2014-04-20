package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Abstract class that takes a complex data type which can be 
* represented as a series of fields and outputs those data types
* to a file.
*/
public abstract class FieldFormatter 
{
   public void writeToFile(String[] fields, String[] values, String identifier, String fileName)
   {
   }
      
   protected static void writeFile(String content, String fileName)
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