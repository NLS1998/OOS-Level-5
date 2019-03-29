package auctions;

public class Item {
	private String itemName;
	
	public Item(String Itemname) {
		setDescription(Itemname);
	}
	
	@Override
	public String toString() {
		return getDescription();
	}

	public void setDescription(String Item) {
		this.itemName = Item;
	}
	
	public String getDescription() {
		return itemName;
	}
}
