package auctions;

public class Buyer {
	private String username;
	private String password;

	public Buyer(String username, String password) {
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


