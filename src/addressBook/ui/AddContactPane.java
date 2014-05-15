package addressbook.ui;

import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import static addressbook.configuration.SessionConfiguration.NAME;
import static addressbook.configuration.SessionConfiguration.ADDRESS;
import static addressbook.configuration.SessionConfiguration.CITY;
import static addressbook.configuration.SessionConfiguration.STATE;
import static addressbook.configuration.SessionConfiguration.ZIP;

public class AddContactPane extends JPanel
{
   private static final String EMPTY_STRING = "";
   
   private JTextField name, address, city, state, zip;
   private JLabel nLabel, aLabel, cLabel, sLabel, zLabel;
   private JButton ok, cancel;
   private Mediator mediator;
   
   public AddContactPane()
   {
      //Create elements for the pane
      name = new JTextField();
      address = new JTextField();
      city = new JTextField();
      state = new JTextField();
      zip = new JTextField();
      
      nLabel = new JLabel("Enter name");
      aLabel = new JLabel("Enter address");
      cLabel = new JLabel("Enter city");
      sLabel = new JLabel("Enter state");
      zLabel = new JLabel("Enter zip");
      
      ok = new OkButton(mediator);
      cancel = new CancelButton(mediator);
      
      //Create layout
      GroupLayout layout = new GroupLayout(this);
      setLayout(layout);
      layout.setAutoCreateGaps(true);
      layout.setAutoCreateContainerGaps(true);
      
      /*Create vertical layout. Each field should get
      * its own row and the buttons go at the bottom.
      */
      layout.setVerticalGroup(layout.createSequentialGroup()
         .addGroup(layout.createParallelGroup()
            .addComponent(nLabel)
            .addComponent(name))
         .addGroup(layout.createParallelGroup()
            .addComponent(aLabel)
            .addComponent(address))
         .addGroup(layout.createParallelGroup()
            .addComponent(cLabel)
            .addComponent(city))
         .addGroup(layout.createParallelGroup()
            .addComponent(sLabel)
            .addComponent(state))
         .addGroup(layout.createParallelGroup()
            .addComponent(zLabel)
            .addComponent(zip))
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(ok)
            .addComponent(cancel))
         );
         
      /*Create horizontal layout. There are two columns, one for 
      * titles to explain the fields, and another for text input
      * fields. One button goes at the bottom of each column
      */
      layout.setHorizontalGroup(layout.createSequentialGroup()
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(nLabel)
            .addComponent(aLabel)
            .addComponent(cLabel)
            .addComponent(sLabel)
            .addComponent(zLabel)
            .addComponent(ok))
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(name)
            .addComponent(address)
            .addComponent(city)
            .addComponent(state)
            .addComponent(zip)
            .addComponent(cancel))
         );
   }
   
   /*
   * Returns a hash map of the text entered
   * in the pane's text fields
   */
   public HashMap<String, String> getTextValues()
   {
      HashMap map = new HashMap(5);
      try
      {
         map.put(NAME, name.getText());
      }
      catch(NullPointerException npe)
      {
         map.put(NAME, EMPTY_STRING);
      }
      try
      {
         map.put(ADDRESS, address.getText());
      }
      catch(NullPointerException npe)
      {
         map.put(ADDRESS, EMPTY_STRING);
      }
      try
      {
         map.put(CITY, city.getText());
      }
      catch(NullPointerException npe)
      {
         map.put(CITY, EMPTY_STRING);
      }
      try
      {
         map.put(STATE, state.getText());
      }
      catch(NullPointerException npe)
      {
         map.put(STATE, EMPTY_STRING);
      }
      try
      {
         map.put(ZIP, zip.getText());
      }
      catch(NullPointerException npe)
      {
         map.put(ZIP, EMPTY_STRING);
      }
      
      return map;
   }
   
   /**
   * clears all text fields in this pane
   */
   public void clearAll()
   {
      name.setText(null);
      address.setText(null);
      city.setText(null);
      state.setText(null);
      zip.setText(null);
   }
}