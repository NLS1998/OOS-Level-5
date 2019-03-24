package auctions;

public class Seller extends User{
	
	private String Username;
	private String Password;
	

	public Seller(String username, String password) {
		super(username, password);

	}

	public boolean validatePass(String userPass) {
        if (Password == userPass) {
            return true;
        }
        else {
            return false;
        }

    }
	public String getUsername() {
		return Username;
	}

	public boolean isBlocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
