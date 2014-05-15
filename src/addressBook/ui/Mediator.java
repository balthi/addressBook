package addressbook.ui;

import java.util.Map;
import javax.swing.JPanel;

public class Mediator
{
   AddContactPane pane;
   
   public Mediator(AddContactPane pane)
   {
      this.pane = pane;
   }
   
   public void add()
   {
      Map<String, String> details = pane.getTextValues();
   }
   
   public void cancel()
   {
   }
}