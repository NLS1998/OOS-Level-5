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
	private String status; 

	public Auction(int aucNo, String itemName, double startPrice, double reservePrice, String Username, LocalDateTime minusSeconds, String status) {
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.username = Username;
		this.minusSeconds = minusSeconds;
		this.aucNo = aucNo;
		this.status = status;

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

	public String getStatus() {
		return status;
	}

	public Object getCloseDateTime() {
		return null;
	}

}
