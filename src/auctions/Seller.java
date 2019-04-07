package auctions;

public class Seller extends User{
	public boolean blocked = false;
	private String Username;
	private String Password;
	

	public Seller(String Username, String Password) {
		
		super(Username, Password);

	}


	public String getUsername() {
		return Username;
	}
	
	public void setBlock (boolean blocked) {
		this.blocked = blocked;
	}
	
	public String Password() {
		return Password;
	}
	
}
