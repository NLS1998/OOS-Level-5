package auctions;

import java.time.LocalDateTime;
import java.util.List;

public class StatusCheck {
	private List<Auction> auctions;
	private final Integer delay; 
	
	public StatusCheck (List<Auction> auctions, Integer seconds) {
		this.auctions = auctions; 
		this.delay = seconds * 1000; 
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(delay);
				synchronized (auctions) {
//					auctions.stream().filter (o -> o.getStatus().equals(Status.ACTIVE)).filter(o -> (o.getCloseDateTime()).isBefore(LocalDateTime.now())).forEach(o -> o.closed());
//						System.err.print("\nActive Auctions : " + auctions.stream().filter (o -> o.getStatus().equals(Status.ACTIVE)).filter(o -> (o.getCloseDateTime()).isBefore(LocalDateTime.now())).forEach(o -> o.close()));
					
					for (Auction auction : auctions) {
						if (auction.getStatus().equals(Status.ACTIVE)) {
							if (((LocalDateTime) auction.getCloseDateTime()).isBefore(LocalDateTime.now())) {
								auction.getStatus().equals(Status.close);
							}
						}
					}
						
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
