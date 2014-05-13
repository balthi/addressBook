package addressbook.ui;

import javax.swing.JFrame;

public class MainFrame
{  
   private static MainFrame frame;
   private static String FRAME_TITLE = "Address Book";
   
   private MainFrame()
   {
      //Do nothing
   }
   
   public static MainFrame getMainFrame()
   {
      if(frame == null)
      {
         frame = new MainFrame();
      }
      return frame;
   }
   
   public void createAndShowGUI()
   {
      JFrame frame = new JFrame(FRAME_TITLE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //TODO: add other elements to frame
      
      //Display frame
      frame.pack();
      frame.setVisible(true);
   }
}