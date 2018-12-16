package model.rules;

import model.Card;
import model.Card.Value;
import model.Player;

public class Soft17HitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;

	@Override
	public boolean DoHit(Player a_dealer) {
		int dealerScore = a_dealer.CalcScore();
		
		if(dealerScore == g_hitLimit) {
			for (Card card : a_dealer.GetHand()) {
				if(card.GetValue() == Value.Ace) {
					return true;
				}
			}
		}		
		return dealerScore < g_hitLimit;	
	}

}
