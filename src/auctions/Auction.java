package auctions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auction {
	LocalDateTime minusSeconds = LocalDateTime.now();
	private String username;
	private String itemName;
	private double startPrice;
	private double reservePrice;
	private int aucNo;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");

	public Auction(int aucNo, String itemName, double startPrice, double reservePrice, String Username, LocalDateTime minusSeconds) {
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.username = Username;
		this.minusSeconds = minusSeconds;
		this.aucNo = aucNo;

		// TODO Auto-generated constructor stub
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
		return minusSeconds.format(formatter);
	}

	public double getStartPrice() {
		return startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

}
