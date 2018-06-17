package MVC;
public class MyMVC {
	public static void main(String[] args) {

		// Fetch card record
		AstroCards model  = retrieveAstroCards();

		// Display cards
		CardView view = new CardView();
		CardControl controller = new CardControl(model, view);
		controller.updateView();

		// Add and update data
		controller.setCardName("The Spire");
		controller.setCardAbility("Increases critical hit rate for a party member or self by 10%");
		controller.updateView();
	}

	private static AstroCards retrieveAstroCards(){
		System.out.println("When you use Draw, you can draw one of the following arcanum: ");
		System.out.println();
		
		AstroCards AstroCards = new AstroCards();
		AstroCards.setName("The Balance");
		AstroCards.setAbility("Increases damage dealt by a party member or self by 10%");
		AstroCards.getDuration();
		return AstroCards;
	}
}