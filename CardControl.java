package MVC;

// This is the Controller.
public class CardControl {
   private AstroCards model;
   private CardView view;

   public CardControl(AstroCards model, CardView view){
      this.model = model;
      this.view = view;
   }

   public void setCardName(String name){
      model.setName(name);		
   }

   public String getCardName(){
      return model.getName();		
   }

   public void setCardAbility(String ability){
      model.setAbility(ability);		
   }

   public String getCardAbility(){
      return model.getAbility();		
   }

   public void updateView(){				
      view.printCards(model.getName(), model.getAbility(), model.getDuration());
   }	
}