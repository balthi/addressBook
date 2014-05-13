package addressbook;

import java.util.Iterator;
import java.lang.Iterable;
import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;

public class ContactList implements Iterable
{
   private LinkedContact head;
   private LinkedContact tail;
   
   /**
   * Adds contact to the Contact List
   */
   public void addContact(Contact contact)
   {
      if(head == null)
      {
         head = new LinkedContact(contact);
      }
      else if(tail == null)
      {
         tail = new LinkedContact(contact);
         tail.setPrevious(head);
         head.setNext(tail);
      }
      else
      {
         LinkedContact lc = new LinkedContact(contact);
         lc.setPrevious(tail);
         tail.setNext(lc);
         tail = lc;
      }
   }
   
   /**
   * Removes the first instance of contact
   */
   public void removeContact(Contact contact)
   {
      ContactListIterator iterator = new ContactListIterator(this);
      
      while(iterator.hasNext())
      {
         if(iterator.next().equals(contact))
         {
            iterator.remove();
            return;
         }
      }
      
   }
   
   /**
   * Returns an iterator for the ContactList
   */
   public Iterator<Contact> iterator()
   {
      return new ContactListIterator(this);
   }
   
   private class LinkedContact
   {
   
      public LinkedContact(Contact contact)
      {
         this.contact = contact;
      }
      
      private Contact contact;
      private LinkedContact next;
      private LinkedContact previous;
      
      public void setNext(LinkedContact next)
      {
         this.next = next;
      }
      
      public void setPrevious(LinkedContact previous)
      {
         this.previous = previous;
      }
      
      public LinkedContact getNext()
      {
         if(next == null)
         {
            throw new NullPointerException();
         }
         else
         {
            return next;
         }
      }
      
      public boolean hasNext()
      {
         return (next != null);
      }
      
      public LinkedContact getPrevious()
      {
         if(previous == null)
         {
            throw new NullPointerException();
         }
         else
         {
            return previous;
         }
      }
      
      public Contact getContact()
      {
         return contact;
      }
   }
   
   private class ContactListIterator implements Iterator<Contact>
   {
      public ContactListIterator(ContactList contactList)
      {
         this.contactList = contactList;
      }
      
      private ContactList contactList;
      private LinkedContact lc;
      private boolean headReturned = false;
      private boolean nextCalled = false;
      
      /**
      * Returns true if the iteration has more elements
      */
      public boolean hasNext()
      {
         if(lc == null)
         {
            if(contactList.head == null)
            {
               return false;
            }
            else
            {
               lc = contactList.head;
               return true;
            }
         }
         else
         {
            return lc.hasNext();
         }
      }
      
      /**
      * Returns the next contact in the iteration
      * Throws NoSuchElementException if the iteration has no more elements
      */
      public Contact next()
      {
         Contact contact = null;
         if(!headReturned)
         {
            if(contactList.head != null)
            {
               lc = contactList.head;
               headReturned = true;
               contact = lc.getContact();
            }
         }
         else
         {
            if(lc.hasNext())
            {
               lc = lc.getNext();
               contact = lc.getContact();
            }
            else
            {
               throw new NoSuchElementException("Iteration has no more contacts.");
            }
         }
         nextCalled = true;
         return contact;
      }
      
      /**
      * Removes the the last element called by next() from the
      * underlying collection. Throws IllegalStateException if
      * next has not been called, or if remove has already 
      * been called on the last call to the next() method.
      */
      public void remove()
      {
         if(!nextCalled)
         {
            throw new IllegalStateException("Remove has already been called on the contact");
         }
         else
         {
            LinkedContact previous;
            LinkedContact next;
            try
            {
               previous = lc.getPrevious();
            }
            catch(NullPointerException npe)
            {
               head = lc.getNext();
               head.setPrevious(null);
               nextCalled = false;
               return;
            }
         
            try
            {
               next = lc.getNext();
            }
            catch(NullPointerException npe)
            {
               tail = lc.getPrevious();
               tail.setNext(null);
               nextCalled = false;
               return;
            }
         
            previous.setNext(next);
            next.setPrevious(previous);
            nextCalled = false;
         }
      }
   }
}