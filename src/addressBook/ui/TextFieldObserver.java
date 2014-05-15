package addressbook.ui;

public class TextFieldObserver
{
   private boolean modified;
   private ObservableTextField observed;
   
   public TextFieldObserver(ObservableTextField observed)
   {
      this.observed = observed;
      modified = observed.isInputNull();
   }
   
   
   public void update(boolean validInput)
   {
      modified = validInput;
   }
}