package auctions;

public class User {
	public String Username;
	public String Password;

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
	public String DatatoCSVString() {
		return Username;
	}
}