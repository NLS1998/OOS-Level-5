package auctions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import auctions.Status.Stat;
import auctions.Bid;

public final class Auction {
	private Boolean blocked = false;
	private LocalDateTime closeDateTime;
	private String username;
	private String itemName;
	public double startPrice, reservePrice;
	private int aucNo;
	private List<Bid> bids = new LinkedList<Bid>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");
	private Stat status = Stat.PENDING;
	Bid highest;
	


	public Auction(int aucNo, String itemName, double startPrice, double reservePrice, String Username,
			LocalDateTime closeDateTime, Stat status) throws Exception {
		if (closeDateTime.isBefore(LocalDateTime.now().plusDays(7))) {
			this.itemName = itemName;
			this.startPrice = startPrice;
			this.reservePrice = reservePrice;
			this.username = Username;
			this.closeDateTime = closeDateTime;
			this.aucNo = aucNo;
			this.status = status;
		} else {
			throw new Exception("ERROR ON CloseDateTime : ( " + closeDateTime.format(formatter.ofPattern("d MMM yy")));
		}
	}

	public String getItemName() {
		return itemName;
	}

	public int getAucNo() {
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

// This method closes the auction. 
	public synchronized void close() {
		status = Stat.CLOSED;


// Finds the highest bid, checks it against the reserve price and then finds who's was the winning bid. 
		if ((highest = getHighestBid()) != null) {
			if (highest.getAmount() >= reservePrice)
				highest.getWho();
		}

		return;
	}

	public Bid getHighestBid() {
		return highest; 
	}

	public String toStrings() {
		return "\nEnded : " + itemName + "\n" + closeDateTime.format(formatter);
	}
	
// Method to allow a buyer to place a bid. 
//	public void placeBid(Double amount, Buyer who, LocalDateTime when) throws Exception {
//	// Checks the status is active first. 
//		if (getStatus() == Stat.ACTIVE) {
//			// Then adds a new bid. 
//				bids.add(new Bid(amount, who, when));
//			}
//		// If doesn't apply to above then goes to exception and throws an error. 
//			else {
//				throw new Exception ("Amount has Error " + amount);
//		}
//	}
	


}
