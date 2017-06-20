import java.util.*;
import java.io.*;
import org.junit.Ignore;

@Ignore public class RentACat {

	private static Scanner keyboard;

	private static ArrayList<Cat> catsList;
	private static ArrayList<Customer> customersList;

	public static void main(String[] args) {

		if(!init()) {
			System.out.println("Error initializing");
			return;
		}

		while(menu()) {}

		keyboard.close();
		System.out.println("Exiting");

	}

  public static boolean init() {

    try {

      catsList = new ArrayList<Cat>();
      customersList = new ArrayList<Customer>();

      String[] catNames = {"Doc", "Grumpy", "Happy", "Sleepy", "Bashful","Sneezy", "Dopey"};
      String[] customerNames = {"Lindsay Rubeski", "Nissie Zelen", "Sanson Granfors",
        "Karen Marean", "Lesley Cathcart", "Burlie Andreas", "Stacey Nadathur", "Allissa Kleiner"};

      for(int i = 0; i < 7; i++) {
        double cost = Math.round( (100.00 + Math.random() * (500.00 - 100.00) ) /10) * 10;
        catsList.add(new Cat(i+1, catNames[i], cost));
      }

      for(int i = 0; i < 8; i++) {
        customersList.add(new Customer(i+1, customerNames[i]));
      }

      return true;

    }
    catch(Exception ex) {
      ex.printStackTrace();
      return false;
    }

  }

	public static boolean menu() {

		try {

			System.out.print("Option [1,2,3,4] > ");
			keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();

			if(input.equals("1")) { //Print available catsList
				System.out.println(listCats());
			}
			else if(input.equals("2")) { //Rent cat
				while(tryCatRental()) {}
			}
			else if(input.equals("3")) { //Return cat
				while(tryCatReturn()) {}
			}
			else if(input.equals("4")) { //Quit
				return false;
			}
			else { //Bad input
				System.out.println("Please enter a valid option (1-4) ");
			}

			return true;

		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public static String listCats() {

		String list = "";
		for(Cat cat: catsList) {
			if(cat.getCustomerId() == 0) {
				list += cat.toString() + "\n";
			}
		}
		return list.substring(0, list.lastIndexOf("\n"));

	}

	//Option 2: Try and rent a cat
	public static boolean tryCatRental() {

		int id = getCustomerId();
		if(id == -1) {
			return false;
		}
		if(id == 0) {
			while(id == 0) {
				id = getCustomerId();
			}
		}

		int catId = getCatRental(id);
		if(catId == -1) {
			return false;
		}
		if(catId == 0) {
			while(catId == 0) {
				catId = getCatRental(id);
			}
		}
		return false;

	}

  //Helper method to get customerId from customer and validate
	public static int getCustomerId() {

		try {

			System.out.print("Customer ID > ");
			String input = keyboard.nextLine();

			if(input.equalsIgnoreCase("quit")) { //Returns to menu
				return -1;
			}

			int id = Integer.parseInt(input);
			for(Customer customer: customersList) {
					if(customer.getId() == id) { // id was found
						return id;
					}
			}

			System.out.println("Customer was not found");
			return 0;

		}
		catch(NumberFormatException nfe) {
			System.out.println("Please enter an integer customer id");
			return 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}

	}

  //Helper method to get catId from customer and validate
	public static int getCatRental(int rentorId) {

		try {

			System.out.print("Rent which cat? > ");
			String input = keyboard.nextLine();

			if(input.equalsIgnoreCase("quit")) { //Return to menu
				return -1;
			}

			int id = Integer.parseInt(input);

			for(Cat cat: catsList) {

				if(cat.getId() == id) {
          if(cat.rentCat(rentorId)) {
						System.out.println(cat.getName() + " has been rented to Customer " + rentorId);
						return 1;
					}
					else {
						System.out.println(cat.getName() + " is not here! ");
						return 0;
					}
				}

			}

			System.out.println("Invalid cat ID. ");
			return 0;

		}
		catch(NumberFormatException nfe) {
			System.out.println("Please enter an integer for cat id");
			return 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}

	}


	public static boolean tryCatReturn() {

		int catReturn = getCatReturn();
		if(catReturn == - 1) {
			return false;
		}
		if(catReturn == 0) {
			while(catReturn == 0) {
				catReturn = getCatReturn();
			}
		}
		return false;
	}

  //Helper method to get catId from customer and validate
	public static int getCatReturn() {

		try {

			System.out.print("Return which cat? > ");
			String input = keyboard.nextLine();

			if(input.equalsIgnoreCase("quit")) { //Return to menu
				return -1;
			}

			int id = Integer.parseInt(input);

			for(Cat cat: catsList) {
				if(cat.getId() == id) {
					if(cat.getCustomerId() != 0) {
						System.out.println(cat.getCustomerId() + " paid " + cat.getCost() +
							"\nWelcome Back " + cat.getName());
						cat.returnCat();
						return 1;
					}
					else {
						System.out.println("Error, " + cat.getName() + " has not been rented. ");
						return 0;
					}
				}

			}

			System.out.println("Invalid cat ID. ");
			return 0;

		}
		catch(NumberFormatException nfe) {
			System.out.println("Please enter an integer for cat id");
			return 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return -1;
		}

	}
}
