package auctions;

public class Seller {
	
	private String username;
	private String password;

	public Seller(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean validatePass(String userPass) {
        if (password == userPass) {
            return true;
        }
        else {
            return false;
        }

    }
	public String getUsername() {
		return username;
	}
}
