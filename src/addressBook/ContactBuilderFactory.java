package addressbook;

import static addressbook.configuration.SessionConfiguration.REGION;

public class ContactBuilderFactory
{
   public static ContactBuilder createContactBuilder()
   {
      switch(REGION)
      {
         default:
            return new USContactBuilder();
      }
   }
}