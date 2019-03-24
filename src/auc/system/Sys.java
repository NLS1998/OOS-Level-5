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

	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> users = new ArrayList<User>();

	public Seller seller;
	public Buyer buyer;

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
	
public void mainMenu() {
 		
 		String decision = ""; 
 		
 		do {
 			System.out.println("-- Auction System --");
 			System.out.println("1 -- Log In");
 			System.out.println("2 -- Make a bid");
 			System.out.println("3 -- Start Auction");
 			System.out.println("4 -- View Auctions");
 			System.out.println("Q -- Quit System");
 			
 			decision = Scan.next().toUpperCase(); 
 			
 			switch(decision) {
 			case"1": {
 				login();
 				break;
 			}
 			case"2": {
 				makeBid();
 				break;
 			}
 			case"3": {
 				startAuction();
 				break; 
 			}
 			case"4": {
 				viewAuctions();
 				break;
 			}
 			}
 		} while (!decision.equals("Q"));
 		System.out.println("-- Thanks for Visiting --");
 		System.exit(0);
 	}

	private void viewAuctions() {
	
	}

	private void startAuction() {
	
	}

	private void makeBid() {
	
	}
	
	

	public void displayMessageLine(String message) {
		System.out.println(message);
	}

	public void displayMessage(String message) {
		System.out.print(message);
	}

	private void login() {

		System.out.println("");
		System.out.println("Please enter your Username : ");
		String Username = Scan.next();

		System.out.println("");
		System.out.println("Please enter your Password : ");
		String Password = Scan.next();

		for (int i = 0; i < users.size(); i++) {
			User object = users.get(i);
			if (object != null) {
				if (object.Username.equals(Username) && (object.Password.equals(Password))) {
					System.out.println("Logged in as " + object.DatatoCSVString());
					if (Seller.class.isInstance(users)) {
	 					seller = (Seller)users;
	 					
	 					if (!seller.isBlocked()) {
	 						sellerMenu();
	 					}
	 				}
	 			}
	 			else {
	 				buyer = Buyer.class.cast(users);
	 				buyerMenu();
	 			}
			}
		}
	}

	private void buyerMenu() {
		
		String decision = "";
		
		do { 
			System.out.println("-- Buyer Menu --");
			System.out.println("1 -- View Active Auctions");
			System.out.println("2 -- Make a Bid");
			System.out.println("L1 -- Log out of System and Return to Main Menu");
			System.out.println("L2 -- Log out of System and Quit Program");
			
			decision = Scan.next().toUpperCase(); 
			
			switch(decision) {
			case"1": {
				activeAuctions();
				break;
			}
			case"2": {
				makeBid();
				break;
			}
			case"L1": {
 				logOutReturn();
 				break;
 			}
			case"L2": { 
 				logOutQuit();
 				break;
 			}
			}
		}while (!decision.equals(""));
		
	}
	
private void activeAuctions() {
		
	}

private void sellerMenu() {
 		
 		String decision = "";
 		
 		do {
 			System.out.println("-- Seller Menu --");
 			System.out.println("1 -- Create an Auction");
 			System.out.println("2 -- Show your Current Auctions");
 			System.out.println("L1 -- Log out of System and Return to Main Menu");
 			System.out.println("L2 -- Log out of System and Quit Program");

 			decision = Scan.next().toUpperCase();
 			
 			switch(decision) {
 			case"1": { 
 				createAuction();
 				break;
 			}
 			case"2": { 
 				currentAuctions();
 				break;
 			}
 			case"L1": {
 				logOutReturn();
 				break;
 			}
 			case"L2": { 
 				logOutQuit();
 				break;
 			}
 			}
 		}while (!decision.equals(""));
 	}
 	
	private void createAuction() {
 		
 	}
 	
 	private void currentAuctions() {
 		
 	}
 	
 	private void logOutReturn() {
	
 	}
 	private void logOutQuit() {
	
 	}
 	
 	
}


