package auc.system;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import auctions.Auction;
import auctions.Buyer;
import auctions.Seller;
import auctions.User;

public class Sys {

	private final Scanner Scan = new Scanner(System.in);

	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	public List<User> users = new LinkedList<User>();

	public Seller seller;
	public Seller buyer;

	public Sys() {
		users.add(new Seller("Jack", "1122"));
		users.add(new Seller("Robby", "2211"));
		users.add(new Buyer("Nick", "1111"));
		users.add(new Buyer("Robbie", "2222"));
		users.add(new Buyer("David", "3333"));

		try {
			auctions.add(new Auction(7.50, 12.50, LocalDateTime.now().minusSeconds(40)));
			auctions.add(new Auction(7.50, 12.50, LocalDateTime.now().plusSeconds(70)));
			auctions.add(new Auction(7.50, 12.50, LocalDateTime.now().plusSeconds(70)));

			auctions.add(new Auction(50.00, 100.00, LocalDateTime.now().minusSeconds(40)));
			auctions.add(new Auction(50.00, 100.00, LocalDateTime.now().plusSeconds(70)));

			auctions.add(new Auction(100.00, 150.00, LocalDateTime.now().minusSeconds(40)));
			auctions.add(new Auction(100.00, 150.00, LocalDateTime.now().plusSeconds(70)));

		} catch (Exception e) {

		}
	}

	private boolean userAuthenticate = false;

	public void displayMessageLine(String message) {
		System.out.println(message);
	}

	public void displayMessage(String message) {
		System.out.print(message);
	}

	public void run() {
		while (true) {
			while (!userAuthenticate) {
				displayMessageLine("");
				displayMessageLine("Welcome!");
				authenticateUser();
			}
		}
	}
	boolean authenticate = false;
	private void authenticateUser() {
		displayMessageLine("");
		displayMessage("Please enter your Username : ");
		String Username = Scan.nextLine();
	
		displayMessageLine("");
		displayMessage("Please enter your Password : ");
		String Password = Scan.nextLine();
	
		for (int i = 0; i < users.size(); i++) {
			for (int j = 0; j < users.size(); j++) {
				if (Username.equals(users.get(i).getUsername())) {
					if (Password.equals(users.get(j).getPassword())) {
					displayMessageLine("welcomeeeeeeeeeeeeeeeeeee");
				} else {
					
					displayMessageLine("Wrong Username or Password. Please try again!");
					
				}
			

		}
	}

}}}