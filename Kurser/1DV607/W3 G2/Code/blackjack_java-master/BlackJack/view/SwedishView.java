package view;

import model.Card;

public class SwedishView implements IView 
    {
        public void DisplayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
           }
        
        public UserInput GetInput()
        {
            try {
              int c = System.in.read();
              while (c == '\r' || c =='\n') {
                c = System.in.read();
              }
              
              
              switch (c) {
              case 'p':
  				return UserInput.PLAY;

  			case 'h':
  				return UserInput.HIT;

  			case 's':
  				return UserInput.STAND;

  			case 'q':
  				return UserInput.QUIT;

  			default:
  				System.err.println("Oj! Kan du repetera igen?\n");
  				return UserInput.ERROR;
  			}
            } catch (java.io.IOException e) {
              System.out.println("" + e);
              return UserInput.ERROR;
            }
          }
        
        public void DisplayCard(Card a_card)
        {
            if (a_card.GetColor() == Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }
        public void printWhiteSpaces() {for(int i = 0; i < 50; i++) {System.out.print("\n");}; }
        
        
        public void displayNewCard() {
        	printWhiteSpaces();
        	System.out.println("\nNy ... k�ttbullar: ");
        }
        public void DisplayUserInstructions() {
        	 System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
             
		}
    }
