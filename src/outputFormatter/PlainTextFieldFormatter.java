package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;

public class PlainTextFieldFormatter extends FieldFormatter
{
   public void writeToFile(String[] fields, String[] values, int length, String identifier, String container)
   {
      String nl = System.getProperty("line.separator");
      File f;
      FileWriter fr;
      int i;
      
      /*
      * Try opening a file with the given container name, and appending all
      * fields to that file. If the file does not exist, create the file and
      * then append fields to the file
      */
      try
      {
         f = new File("R\\output\\" + container + ".txt");
         
         try
         {
            if(!f.exists())
            {
               f.createNewFile();
            }
            else
            {
               try 
               {
                  f.setWritable(true);
               }
               catch (SecurityException se)
               {
                  se.printStackTrace();
               }
            }
      
            fr = new FileWriter(f, true);
      
            fr.write(container + nl);
      
            for(i=0; i < length; i++)
            {
               fr.write(fields[i] + ": " + values[i] + nl);
            }
      
            fr.write(nl);
            
            fr.close();
            
         }
         catch(IOException ioeWrite)
         {
            ioeWrite.printStackTrace();
         } //closes catch from write attempt
      }
      catch(NullPointerException npe)
      {
         npe.printStackTrace();
      } // close catch from open file
   }
}