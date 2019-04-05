package auctions;

import java.time.LocalDateTime;
import java.util.List;

import auctions.Status.Stat;

public class StatusCheck implements Runnable {
	private List<Auction> auctions;
	private final Integer delay; 
	
	public StatusCheck (List<Auction> auctions, Integer seconds) {
		this.auctions = auctions; 
		this.delay = seconds * 1000; 
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(delay);
				synchronized (auctions) {

					
					for (Auction auction : auctions) {
						if (auction.getStatus().equals(Stat.ACTIVE)) {
							if ((auction.getCloseDateTime()).isBefore(LocalDateTime.now())) {
								auction.close();
							}
						}
					}
					System.err.print("\nActive Auctions : " + auctions.stream().filter (o -> o.getStatus().equals(Stat.ACTIVE)).filter(o -> (o.getCloseDateTime()).isBefore(LocalDateTime.now())).forEach(o -> o.close()));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
