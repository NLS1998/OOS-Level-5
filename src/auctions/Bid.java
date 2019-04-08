package auctions;

import java.time.LocalDateTime;
import auctions.Buyer;

public class Bid {
    private double amount;
    private Buyer who;
    private LocalDateTime when;
    private double highest;

    
    public Bid(double amount, Buyer who, LocalDateTime when) {
        this.amount = amount;
        this.who = who;
        this.when = when;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public double getHighestBid() {
    	return highest;
    }
    
    public void setHighest(double Bid) {
    	this.highest = Bid;
    }

    public void setBid(double Bid) {
        this.amount = Bid;
    }
    
    public Buyer getWho() {
        return who;
    }
    
    public LocalDateTime getWhen() {
        return when;
    }
}