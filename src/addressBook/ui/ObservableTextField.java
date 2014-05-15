package addressbook.ui;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ObservableTextField extends JTextField implements KeyListener
{

   public ObservableTextField()
   {
      numChars = 0;
      observers = new LinkedList();
      addKeyListener(this);
   }
   
   private int numChars;
   private boolean notNullInput;
   private LinkedList<TextFieldObserver> observers;
   
   /* 
   * The following methods are required to
   * implement the KeyListener interface
   */
   @Override
   public void keyPressed(KeyEvent e)
   {
      //Do nothing
   }
   
   @Override
   public void keyReleased(KeyEvent e)
   {
      //Do nothing
   }
   
   @Override
   public void keyTyped(KeyEvent e)
   {
      if((e.getKeyChar() == KeyEvent.VK_BACK_SPACE) && numChars > 0)
      {
         numChars -= 1;
         if(numChars == 0)
         {
            setChanged(false);
         }
      }
      else if(!(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
      {
         if(numChars == 0)
         {
            setChanged(true);
         }
         numChars += 1;
      }
   }
   
   public void notifyObservers()
   {
      Iterator<TextFieldObserver> iterator = observers.iterator();
      while(iterator.hasNext())
      {
         iterator.next().update(notNullInput);
      }
   }
   
   private void setChanged(boolean changed)
   {
      notNullInput = changed;
      notifyObservers();
   }
   
   public boolean isInputNull()
   {
      return notNullInput;
   }
   
}