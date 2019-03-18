package auctions;

import java.time.LocalDateTime;
import java.util.Date;

public class Auction {
	private Date closeDate;
	private char status;
	private double startPrice;
	private double reservePrice;
	private LocalDateTime minusSeconds;
	private LocalDateTime plusSeconds;

	public Auction(double startPrice, double reservePrice, LocalDateTime minusSeconds) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.minusSeconds = minusSeconds;
		
		// TODO Auto-generated constructor stub
	}


}
