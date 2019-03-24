package auctions;

import java.time.LocalDateTime;
import java.util.Date;

public class Auction {
	private String itemName;
	private double startPrice;
	private double reservePrice;
	private LocalDateTime minusSeconds;

	public Auction(String itemName, double startPrice, double reservePrice, LocalDateTime minusSeconds) {
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.minusSeconds = minusSeconds;
		
		// TODO Auto-generated constructor stub
	}
	
	public String getItemName() {
		return itemName;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}
	
	public LocalDateTime getDateTime() {
		return minusSeconds;
	}
}
