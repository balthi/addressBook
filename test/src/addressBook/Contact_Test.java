package addressBook;

import java.io.File;
import java.net.URI;
import static java.net.URI.create;
import junit.framework.TestCase;

public class Contact_Test extends TestCase
{
   private static final String BOB = "Bob Wilson";
   private static final String GROOVY = "123 Groovy St.";
   private static final String AUSTIN = "Austin";
   private static final String TX = "TX";
   private static final String AUSTIN_ZIP = "78755";
   
   private static final String JANE = "Jane Baker";
   private static final String MAPLE = "5743 Maple Ave";
   private static final String DENVER = "Denver";
   private static final String CO = "CO";
   private static final String DENVER_ZIP = "80294";
   
   private static final String CONTACT_ONE = "R\\output\\test\\contactOne.xml";
      
   private Contact contactOne;
   private Contact contactTwo;
   private Contact contactThree;
   private Contact contactFour;
   
   public void setUp()
   {
      this.contactOne = new Contact(BOB, GROOVY, AUSTIN, TX, AUSTIN_ZIP);
      this.contactTwo = new Contact(BOB, GROOVY, AUSTIN, TX, AUSTIN_ZIP);
      this.contactThree = new Contact(JANE, GROOVY, DENVER, CO, DENVER_ZIP);
      this.contactFour = new Contact(BOB, MAPLE, AUSTIN, TX, AUSTIN_ZIP);
   }
   
   public void testEqualsEqual()
   {
      assertTrue("Error in testEqualsEqual: Objects are identical", contactOne.equals(contactTwo));
   }
   
   public void testEqualsPartiallyEqual()
   {
      assertTrue("Error in testEqualsPartiallyEqual: Objects are not identical", !contactOne.equals(contactThree));
   }
   
   public void testEqualsNotEqual()
   {
      assertTrue("Error in testEqualsNotEqual: Objects are completely different", !contactOne.equals(contactFour));
   }
   
   public void testWriteToFile()
   { 
      contactOne.writeToFile(CONTACT_ONE);
      File f = new File(CONTACT_ONE);
      assertTrue("Error in testWriteToFile: File does not exist", f.exists());
      f.delete();
   }
}