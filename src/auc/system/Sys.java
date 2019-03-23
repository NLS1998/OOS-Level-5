package auc.system;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
	String choice = "";

	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> users = new LinkedList<User>();

	public Sys() {
		users.add(new Seller("jack", "1122"));
		users.add(new Seller("robby", "2211"));
		users.add(new Buyer("nick", "1111"));
		users.add(new Buyer("robbie", "2222"));
		users.add(new Buyer("david", "3333"));

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

	public void displayMessageLine(String message) {
		System.out.println(message);
	}

	public void displayMessage(String message) {
		System.out.print(message);
	}

	public void run() {
		do {
			System.out.println("\n**AUCTON MAIN MENU **");
			System.out.println("1 - Browse Auctions"); // Feature A
			System.out.println("2 - Login");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");

			choice = Scan.next().toUpperCase();

			switch (choice) {
			case "1": {
				break;
			}
			case "2": {
				login(users);
				break;
			}
			}
		} while (!choice.equals("Q"));
		System.out.println("-- GOODBYE --");

	}

	private static void login(List<User> users) {
		Scanner Scans = new Scanner(System.in);

		System.out.println("");
		System.out.println("Please enter your Username : ");
		String Username = Scans.next();

		System.out.println("");
		System.out.println("Please enter your Password : ");
		String Password = Scans.next();

		boolean isExist = false;

		for (User u : users) {
			while (u.Username.equals(Username) && (u.Password.equals(Password))) {
				isExist = true;
				break;

			}
		}
		if (isExist) {
			System.out.println("Logged in as " + Username);
			for (User u : users) {
				while (u.Username.equals(Username)) {
					if (u instanceof Buyer) {
						System.out.println("Buyer");

						break;

					} else {
						System.out.println("Seller");
						break;
					}
				}

			}

		} else {
			System.out.println("Sorry Please Try Again!!!!");
			login(users);
		}

	}
}
