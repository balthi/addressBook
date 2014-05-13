package addressbook;

import addressbook.configuration.SessionConfiguration;
import java.util.Iterator;
import junit.framework.TestCase;

import static addressbook.configuration.SessionConfiguration.NL;

public class ContactList_Test extends TestCase
{
   private String BOB = "Bob Wilson";
   private String SUSAN = "Susan Adams";
   private String JOE = "Joe Smith";
   private String MARY = "Mary Contrary";
   
   private String MAPLE = "1814 Maple Ave.";
   private String ULIT = "1812 Ulit Ave.";
   private String FRANCISCO = "2028 Francisco St.";
   private String PRINCE = "2247 Prince St.";
   
   private String AUSTIN = "Austin";
   private String DENVER = "Denver";
   
   private String TX = "TX";
   private String CO = "CO";
   
   private String AUSTIN_ZIP = "78759";
   private String DENVER_ZIP = "80246";
   
   private Contact Bob;
   private Contact Susan;
   private Contact Joe;
   private Contact Mary;
   private ContactList cl;
   private Iterator<Contact> iterator;
   
   public void setUp()
   {
      SessionConfiguration sc = SessionConfiguration.getSessionConfiguration();
      sc.loadSessionConfiguration();
      Bob = new Contact(BOB, MAPLE, AUSTIN, TX, AUSTIN_ZIP);
      Susan = new Contact(SUSAN, ULIT, DENVER, CO, DENVER_ZIP);
      Joe = new Contact(JOE, FRANCISCO, AUSTIN, TX, AUSTIN_ZIP);
      Mary = new Contact(MARY, PRINCE, DENVER, CO, DENVER_ZIP);
   }
   
   public void testIteratorHead()
   {  
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      Contact contact = iterator.next();
      assertTrue("Contacts do not match in testIteratorHead.", Bob.equals(contact));
   }
   
   public void testIteratorTail()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      Contact contact;
      for(int i=0; i<3; i++)
      {
         contact = iterator.next();
         if(i==2)
         {
            assertTrue("Contacts do not macth in testIteratorTail.", Joe.equals(contact));
         }
      }
   }
      
   public void testIteratorRemoveContactAfterIterator()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      cl.removeContact(Susan);
      Contact one = iterator.next();
      Contact two = iterator.next();
      assertTrue("First Contacts do not macth in testIteratorRemoveContactAfterIterator.", Bob.equals(one));
      assertTrue("Second Contacts do not macth in testIteratorRemoveContactAfterIterator.", Joe.equals(two));
   }
   
   public void testIteratorRemoveContactBeforeIterator()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      assertTrue("hasNext failed on one in testIteratorRemoveContactBeforeIterator", iterator.hasNext());
      Contact one = iterator.next();
      assertTrue("hasNext failed on two in testIteratorRemoveContactBeforeIterator", iterator.hasNext());
      Contact two = iterator.next();
      cl.removeContact(Bob);
      assertTrue("hasNext failed on three in testIteratorRemoveContactBeforeIterator", iterator.hasNext());
      Contact three = iterator.next();
      assertTrue("First contacts do not macth in testIteratorRemoveContactBeforeIterator.", Bob.equals(one));
      assertTrue("Second contacts do not macth in testIteratorRemoveContactBeforeIterator.", Susan.equals(two));
      assertTrue("Third contacts do not macth in testIteratorRemoveContactBeforeIterator.", Joe.equals(three));
      assertTrue("hasNext failed on four in testIteratorRemoveContactBeforeIterator", !iterator.hasNext());
   }
   
   public void testIteratorRemoveContactOnIterator()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      Contact one = iterator.next();
      Contact two = iterator.next();
      cl.removeContact(Susan);
      Contact three = iterator.next();
      assertTrue("First contacts do not macth in testIteratorRemoveContactOnIterator.", Bob.equals(one));
      assertTrue("Second contacts do not macth in testIteratorRemoveContactOnIterator.", Susan.equals(two));
      assertTrue("Third contacts do not macth in testIteratorRemoveContactOnIterator.", Joe.equals(three));
   }
   
   public void testAddContact()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      cl.addContact(Joe);
      iterator = cl.iterator();
      Contact contact = null;
      cl.addContact(Mary);
      for(int i=0; i<4; i++)
      {
         contact = iterator.next();
      }
      assertTrue("Contacts do not macth in testAddContact.", Mary.equals(contact));
   }
   
   public void testAddContactIteratorOnTail()
   {
      cl = new ContactList();
      cl.addContact(Bob);
      cl.addContact(Susan);
      iterator = cl.iterator();
      iterator.next();
      iterator.next();
      cl.addContact(Joe);
      Contact contact = iterator.next();
      assertTrue("Contacts do not match in testAddContactIteratorOnTail.", Joe.equals(contact));
   }
}