package auctions;

public class Buyer extends User {
	private String Username;
	private String Password;

	public Buyer(String Username, String Password) {
		super(Username, Password);
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
	
	public String getPassword() {
		return Password;
	}
}


