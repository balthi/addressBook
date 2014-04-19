package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FieldFormatter 
{
   public void writeToFile(String[] fields, String[] values, int length, String identifier, String container)
   {
   }
      
   protected static void writeFile(String content, String directory, String extension, String container)
   {
      File f;
      FileWriter fr;
      
      try
      {
         f = new File(directory + container + extension);
         
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