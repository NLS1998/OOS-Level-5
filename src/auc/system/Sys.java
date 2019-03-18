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
	private List<User> users = new LinkedList<User>();

	private Seller seller;
	private Buyer buyer;

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

	private User getUser(String Username) {
		for (User currentUser : users) {
			if (currentUser.getUsername().equals(Username)) {
				return currentUser;

			}
		}

		return null;
	}

	public boolean authenticateUser(String usernameAccount, String userPass) {
		User userAccount = getUser(usernameAccount);

		if (userAccount != null) {
			return userAccount.validatePass(userPass);
		} else {
			return false;
		}
	}

}
