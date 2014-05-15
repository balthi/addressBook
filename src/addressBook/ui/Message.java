package addressbook.ui;

public enum Message
{
   ADD(0),
   CANCEL(1);
   
   private int value;
   
   private Message(int value)
   {
      this.value = value;
   }
}