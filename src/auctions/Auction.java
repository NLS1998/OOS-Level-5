package auctions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import auctions.Status.Stat;

public final class Auction {
	private Boolean blocked = false;
	private LocalDateTime closeDateTime;
	private String username;
	private String itemName;
	private double startPrice, reservePrice;
	private int aucNo;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");
	private Stat status = Stat.PENDING; 

	public Auction(int aucNo, String itemName, double startPrice, double reservePrice, String Username, LocalDateTime closeDateTime, Stat status) {
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.username = Username;
		this.closeDateTime = closeDateTime;
		this.aucNo = aucNo;
		this.status = status;
	}

	public String getItemName() {
		return itemName;
	}
	
	public int getAucNo () {
		return aucNo;
	}
	
	public String getSeller() {
		return username;
	}

	public void setSeller(String User) {
		this.username = User;
	}
	
	public String formatDateTime() {
		return closeDateTime.format(formatter);
	}

	public double getStartPrice() {
		return startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public Stat getStatus() {
		return status;
	}

	public LocalDateTime getCloseDateTime() {
		return closeDateTime;
	}
	
	public synchronized void close() {
 		status = Stat.CLOSED;
 		
 		Bid highest;
 		
 		if ((highest = getHighestBid()) !=null) {
 			if (highest.getAmount() >= reservePrice)
 				highest.getWho();
 		}
 		return;
 	}

	private Bid getHighestBid() {
		return null;
	}
	
	private String getWins() {
		return itemName;
	}
	
	public String toStrings() {
		return "\nEnded : " + itemName + "\n" + closeDateTime.format(formatter);
	}

}
