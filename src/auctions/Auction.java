package auctions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auction {
	LocalDateTime minusSeconds = LocalDateTime.now();
	private String itemName;
	private double startPrice;
	private double reservePrice;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");

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

	public String formatDateTime() {
		return minusSeconds.format(formatter);
	}

	public double getStartPrice() {
		return startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

}
