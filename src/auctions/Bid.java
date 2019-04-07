package auctions;

import java.time.LocalDateTime;

public class Bid {
    private double amount;
    private Buyer who;
    private LocalDateTime when;

    
    public Bid( double amount, Buyer who, LocalDateTime when) {
        this.amount = amount;
        this.who = who;
        this.when = when;
    }
    
    public double getAmount() {
        return amount;
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

