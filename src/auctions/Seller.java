package auctions;

public class Seller extends User{
	
	private String username;
	private String password;
	

	public Seller(String username, String password) {
		super(username, password);

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
