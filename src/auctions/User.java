package auctions;

public class User {
	private String Username;
	private String Password;

	public User(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}

	public boolean validatePass(String userPass) {
		if (Password == userPass) {
			return true;

		} else {
			return false;
		}
	}
	
	public String getUsername(){
		return Username;
		
	}
	
	public String getPassword(){
		return Password;
		
	}
}