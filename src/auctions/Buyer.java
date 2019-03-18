package auctions;

public class Buyer extends User {
	private String username;
	private String password;

	public Buyer(String username, String password) {
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
	
	public String getPassword() {
		return password;
	}
}


