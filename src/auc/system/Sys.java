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

	private Scanner Scan = new Scanner(System.in);
	String choice = "";
	// creates a auction collection linked list
	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	// creates user linked list
	private List<User> users = new LinkedList<User>();
	private int auctNo;

	public Sys() {
		users.add(new Seller("jack", "1122"));
		users.add(new Seller("robby", "2211"));
		users.add(new Buyer("nick", "1111"));
		users.add(new Buyer("robbie", "2222"));
		users.add(new Buyer("david", "3333"));

		try {
			auctions.add(new Auction(0, "HDMI Cable", 7.50, 12.50, "jack", LocalDateTime.now().minusHours(40), ));
			auctions.add(new Auction(1, "Amazon Echo Dot", 7.50, 12.50, "robby", LocalDateTime.now().plusSeconds(86400)));
			auctions.add(new Auction(2, "16GB Micro SD Card", 7.50, 12.50, "jack", LocalDateTime.now().plusSeconds(70)));

			auctions.add(new Auction(3, "Apple USB-C to HDMI Dongle", 50.00, 100.00,"robby", LocalDateTime.now().minusSeconds(40)));
			auctions.add(new Auction(4, "Apple AirPods", 50.00, 100.00, "jack", LocalDateTime.now().plusSeconds(70)));

			auctions.add(new Auction(5, "Windows Laptop 2016", 100.00, 150.00, "robby", LocalDateTime.now().minusSeconds(40)));
			auctions.add(new Auction(6, "Apple Macbook Black May 2010", 100.00, 150.00, "jack", LocalDateTime.now().plusSeconds(70)));

		} catch (Exception e) {

		}
	}

	public void run() {
		// System initiates.
		do {
			System.out.println("\n**AUCTON MAIN MENU **");
			System.out.println("1 - Browse Auctions"); // Feature A
			System.out.println("2 - Register");
			System.out.println("3 - Login");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");

			choice = Scan.next().toUpperCase();

			switch (choice) {
			case "1": {
				browseAuctions();
				break;
			}
			case "2": {
				register(users);
				break;
			}
			case "3": {
				login(users);
				break;
			}
			}
		} while (!choice.equals("Q"));
		System.out.println("-- GOODBYE --");

	}

	private void register(List<User> users) {

		System.out.println("");
		System.out.println("Please enter your Username : ");
		String Username = Scan.next();

		System.out.println("");
		System.out.println("Please enter your Password : ");
		String Password = Scan.next();

		System.out.println("");
		System.out.println("Please Specifiy if you are a (B)Buyer or (S)Seller");
		String Type = Scan.next().toUpperCase();

		// checks if username variable is null if not stores new user and password to
		// user list.
		if (Username != null) {
			if (Type.equals("B")) {
				users.add(new Buyer(Username, Password));
				System.out.println("Welcome : " + Username + "!!" + "\n");
				System.out.println("Log in");
				login(users);
			} else if (Type.equals("S")) {
				users.add(new Seller(Username, Password));
				System.out.println("Welcome : " + Username + "!!" + "\n");
				System.out.println("Log in");
				login(users);
			} else {
				System.out.println("B or S key inputs only");
			}
		}
	}
	
	private void createAuction( List<Auction> auctions, String Username) {
		double adding;
		long total = 0;
		double minute = 60;
		double hour = 60;
		
		System.out.println("");
		System.out.println("Please enter Item Name : ");
		String itemName = Scan.next();

		System.out.println("");
		System.out.println("Please enter your Starting Price : ");
		double startPrice = Scan.nextDouble();

		System.out.println("");
		System.out.println("Please enter your Reserve Price : ");
		double resPrice = Scan.nextDouble();
		
		System.out.println("");
		System.out.println("Please enter your auction end date (in hours) : ");
		int hs = Scan.nextInt();
	
	    
		// algorithm to convert hours to seconds and add to Auction linked list.
		// Including seller name.
		if (hs > 0) {
		adding	= minute * hour;
		total = (long) (adding * hs);
		auctions.add(new Auction(auctNo, itemName, startPrice, resPrice, Username, LocalDateTime.now().plusSeconds(total)));
		System.out.println("Auction Created\n");
		}
		}

	public void browseAuctions() {
		// displays live auctions and end date
		for (int i = 0; i < auctions.size(); i++) {
			Auction auc = auctions.get(i);
			System.out.println("Auction No : " + i);
			System.out.println("\nName of Auction -> " + auc.getItemName());
			System.out.println("Reserve Price -> £" + auc.getReservePrice());
			System.out.println("Start Price -> £" + auc.getStartPrice());
			System.out.println("End Time/Date -> " + auc.formatDateTime());
			System.out.println("Seller -> " + auc.getSeller());
			System.out.println("");
		}

	}

	private void login(List<User> users) {
		// User log in
		System.out.println("");
		System.out.println("Please enter your Username : ");
		String Username = Scan.next();

		System.out.println("");
		System.out.println("Please enter your Password : ");
		String Password = Scan.next();

		boolean isExist = false;

		for (User u : users) {
			while (u.Username.equals(Username) && (u.Password.equals(Password))) {
				isExist = true;
				break;

			}
		}
		if (isExist) {
			System.out.println("Logged in as " + Username + "\n");
			for (User u : users) {
				while (u.Username.equals(Username)) {
					if (u instanceof Buyer) {
						buyerMenu();
						break;

					} else {
						sellerMenu(Username);
						break;
					}
				}

			}

		} else {
			System.out.println("Sorry Please Try Again!!!!");
			login(users);
		}

	}

	private void buyerMenu() {

		// buyer menu for users who are stored as buyers
		String decision = "";

		do {
			System.out.println("-- Buyer Menu --");
			System.out.println("1 -- View Active Auctions");
			System.out.println("2 -- Make a Bid");
			System.out.println("L -- Log out of System and Return to Main Menu");
			System.out.println("Q -- Log out of System and Quit Program");

			decision = Scan.next().toUpperCase();

			switch (decision) {
			case "1": {
				browseAuctions();
				break;
			}
			case "2": {
				makeBid(decision, users, auctions, auctNo);
				break;
			}
			case "L": {
				System.out.println("Logged Out");
				run();
				break;
			}
			}
		} while (!decision.equals("Q"));
		System.out.println("-- GOODBYE --");
		System.exit(0);
		
	}

	private void makeBid(String Userame, List<User>users, List<Auction>auctions, int auctNo) {
		browseAuctions();

		System.out.println("");
		System.out.println("Please enter auction number ");
		int aucNo = Scan.nextInt();
		// so far allows Buyer to select an auction via number and displays this to console.
		// need to allow user to make a bid.
		while(aucNo >= 0) {
		for(Auction auc : auctions) {
			if (auc.getAucNo() == aucNo) {
				
				System.out.println("\nName of Auction -> " + auc.getItemName());
				System.out.println("Reserve Price -> £" + auc.getReservePrice());
				System.out.println("Start Price -> £" + auc.getStartPrice());
				System.out.println("End Time/Date -> " + auc.formatDateTime());
				System.out.println("Seller -> " + auc.getSeller());
				System.out.println("");
				
			}
		}break;
		}
	}

	private void sellerMenu(String Username) {

		// Seller menu for users stored as a seller.
		String decision = "";

		do {
			System.out.println("-- Seller Menu --");
			System.out.println("1 -- Create an Auction");
			System.out.println("2 -- Show your Current Auctions");
			System.out.println("L -- Log out of System and Return to Main Menu");
			System.out.println("Q -- Log out of System and Quit Program");

			decision = Scan.next().toUpperCase();

			switch (decision) {
			case "1": {
				createAuction(auctions, Username);
				break;
			}
			case "2": {
				currentAuctions(Username, users, auctions);
				break;
			}
			case "L": {
				run();
				break;
			}
			}
		} while (!decision.equals("Q"));
		System.out.println("-- GOODBYE --");
		System.exit(0);
	}


	// Shows Sellers live auctions.
	private void currentAuctions(String Username, List <User> users, List<Auction> auctions) {
		for (int i = 0; i < auctions.size(); i++) {
			Auction auc = auctions.get(i);
			if (auc != null) {
				if (auc.getSeller().equals(Username)) {
					
					
					System.out.println("Auction : " + auctNo);
					
					System.out.println("\nName of Auction -> " + auc.getItemName());
					System.out.println("Reserve Price -> £" + auc.getReservePrice());
					System.out.println("Start Price -> £" + auc.getStartPrice());
					System.out.println("End Time/Date -> " + auc.formatDateTime());
					System.out.println("Seller -> " + auc.getSeller());
					System.out.println("");
				}
		}
	}

}}
