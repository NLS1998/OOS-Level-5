package auctions;

import java.time.LocalDateTime;
import java.util.Date;

public class Auction {
	private double startPrice;
	private double reservePrice;
	private LocalDateTime minusSeconds;

	public Auction(double startPrice, double reservePrice, LocalDateTime minusSeconds) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.minusSeconds = minusSeconds;
		
		// TODO Auto-generated constructor stub
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
