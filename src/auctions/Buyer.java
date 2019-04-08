package auctions;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import auctions.Status.Stat;
import auctions.Auction;

public class Buyer extends User {
	private List<Auction> won = new LinkedList<Auction>();

	private Boolean change = false;

	public Buyer(String Username, String Password) {
		super(Username, Password);
	}

	public void winner(Auction auction) {
		won.add(auction);
		change = true;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}
	
	// Method to display buyers winning auction's. 
	public List<Auction> getWins() {
        return won;
	}


}
