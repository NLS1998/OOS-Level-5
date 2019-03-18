package auctions;

public class Item {
	private String description;
	
	public Item(String description) {
		setDescription(description);
	}
	
	@Override
	public String toString() {
		return getDescription();
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
