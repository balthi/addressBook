package outputFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;

public class XMLFieldFormatter extends FieldFormatter
{
   @Override
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
         f = new File("R\\output\\" + container + ".xml");
         System.out.println("File created");
         
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
                  System.out.println("File writable");
               }
               catch (SecurityException se)
               {
                  se.printStackTrace();
               }
            }
            
            System.out.println("Writing to file");
            fr = new FileWriter(f, true);
            fr.write("<" + identifier + " " + fields[0] + "=\"" + values[0] + "\">" + nl);
            
            for(i=0; i < length; i++)
            {
               fr.write("    <" + fields[i] + ">" + values[i] + "</" + fields[i] + ">" + nl); //Four spaces begin each line
               System.out.println("Writing " + fields[i] + " to file.");
            }
            
            fr.write("</" + identifier + ">" + nl);
            
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