package auctions;

public abstract class User {
	public String Username;
	public String Password;

	
	public User(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}

	public String getUsername() {
		return Username;
	}
	
	 public void setUsername(String name) {
	       this.Username = name;
	    } 
	
	public String getPassword() {
		return Password;
		}
	
	public void setPassword(String Pass) {
		this.Password = Pass;
	}
	
	public String getType(String Type) {
		return Type;
	}
	
//	public String getWins() {
//		return 
//	}
}