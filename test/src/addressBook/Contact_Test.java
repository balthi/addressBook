package addressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import junit.framework.TestCase;

public class Contact_Test extends TestCase
{
   private Contact contactOne;
   private Contact contactTwo;
   private Contact contactThree;
   private Contact contactFour;
   
   public void setUp()
   {
      this.contactOne = new Contact("Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755", "xml");
      this.contactTwo = new Contact("Bob Wilson", "123 Groovy St.", "Austin", "TX", "78755", "xml");
      this.contactThree = new Contact("Jane Baker", "123 Groovy St.", "Denver", "CO", "80294", "json");
      this.contactFour = new Contact("Jill Park", "5743 Maple Ave", "Tucson", "AZ", "85726", "plain");
   }
   
   public void testEqualsEqual()
   {
      assertTrue("Error in testEqualsEqual: Objects are identical", this.contactOne.equals(this.contactTwo));
   }
   
   public void testEqualsPartiallyEqual()
   {
      assertTrue("Error in testEqualsPartiallyEqual: Objects are not identical", !this.contactOne.equals(this.contactThree));
   }
   
   public void testEqualsNotEqual()
   {
      assertTrue("Error in testEqualsNotEqual: Objects are completely different", !this.contactOne.equals(this.contactFour));
   }
   
   public void testWriteXML()
   {
      File f = new File("R\\output\\contactOne.xml");
      String correct = "";
      String actual = "";
      if(f.exists())
      {
         f.delete();
      }
      File readFrom = new File("R\\input\\contactOne.xml");
      try
      {
         Scanner readIn = new Scanner(readFrom);
         readIn.useDelimiter("\\Z");
         correct = readIn.next();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      
      contactOne.writeToFile("contactOne");
      
      f = new File("R\\output\\contactOne.xml");
      try
      {
         Scanner testIn = new Scanner(f);
         testIn.useDelimiter("\\Z");
         actual = testIn.next();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      
      assertTrue("Error in testWriteXML: incorrect string returned.", correct.equals(actual));
   }
   
   public void testWriteJSON()
   {
      File f = new File("R\\output\\contactThree.json");
      String correct = "";
      String actual = "";
      if(f.exists())
      {
         f.delete();
      }
      File readFrom = new File("R\\input\\contactThree.json");
      try
      {
         Scanner readIn = new Scanner(readFrom);
         readIn.useDelimiter("\\Z");
         correct = readIn.next();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      
      contactThree.writeToFile("contactThree");
      
      f = new File("R\\output\\contactThree.json");
      try
      {
         Scanner testIn = new Scanner(f);
         testIn.useDelimiter("\\Z");
         actual = testIn.next();
      }
      catch(FileNotFoundException fnfe)
      {
         fnfe.printStackTrace();
      }
      
      System.out.println("Correct: " + correct);
      System.out.println("Actual: " + actual);
      assertTrue("Error in testWriteJSON: incorrect string returned.", correct.equals(actual));   }
   
   public void testWritePlainText()
   {
      contactFour.writeToFile("contactFour");
   }
}