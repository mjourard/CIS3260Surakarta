/**
 * This class stored critical information about the player of Surakarta.
 * @author Alexander Gontcharov
 * @version 1.0
 * @since 10/19/2015
 **/
public class Player {

	private String name;					//The name of the player
	private int totalAvailablePieces;		//The total number of board pieces that the player has on the board
	public enum Side {shell, pebble;}		//An enum that holds a shell and pebble value
	private Side side;						//Decides the side the player starts on


	public Player() {

	}

    /**
 	 * Constructor for this class.
 	 **/
	public Player(String name, int totalAvailablePieces, Side side) {
		this.name = name;
		this.totalAvailablePieces = totalAvailablePieces;
		this.side = side;
	}

    /**
 	 * Set the name of the player.
 	 **/
	public void setName(String name) {
		this.name = name;
	}

    /**
 	 * Set the total avaialble pieces of the player.
 	 **/
	public void setTotalAvailablePeices(int totalAvailablePieces) {
		this.totalAvailablePieces = totalAvailablePieces;
	}

    /**
 	 * Set the side of the player to be either shell or pebble.
 	 **/
	public void setSide(Side s) {
		this.side = s;
	}

    /**
 	 * @return the name of the player.
 	 **/
	public String getName() {
		return name;
	}

    /**
 	 * @return the total available pieces of the player.
 	 **/
	public int getTotalAvailablePieces() {
		return totalAvailablePieces;
	}

    /**
 	 * @return the side the player is on. Could be either a shell or a pebble.
 	 **/
	public Side getSide() {
		return side;
	}

	/**
	* @param args the command line arguments
	*/
	public static void main(String[] args) {

		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("Testing creating player with the default Constructor.");
		System.out.println("creating player...\n");

		//Creating player one
		Player playerOne = new Player();

		//Printing current player information
		System.out.println("Player one information:");
		System.out.println("\t" + playerOne.getName());
		System.out.println("\t" + playerOne.getTotalAvailablePieces());
		System.out.println("\t" + playerOne.getSide());

		//Initialize/set values for player one
		System.out.println("\nSetting data for player one...");
		playerOne.setName("Alexander Gontcharov");
		playerOne.setTotalAvailablePeices(12);
		playerOne.setSide(Side.shell);

		//Printing playing information after setting it
		System.out.println("Player one information:");
		System.out.println("\t" + playerOne.getName());
		System.out.println("\t" + playerOne.getTotalAvailablePieces());
		System.out.println("\t" + playerOne.getSide());


		System.out.println("\n-------------------------------------------------------------\n");

		System.out.println("Testing creating player with the Constructor.");
		System.out.println("creating player...\n");

		//Creating player two
		Player playerTwo = new Player("Deon Naltchadjian", 12, Side.pebble);

		//Printing current player information
		System.out.println("Player two information:");
		System.out.println("\t" + playerTwo.getName());
		System.out.println("\t" + playerTwo.getTotalAvailablePieces());
		System.out.println("\t" + playerTwo.getSide());

		//Initialize/set values for player two
		System.out.println("\nSetting data for player one...");
		playerTwo.setName("Matthew Jourard");
		playerTwo.setTotalAvailablePeices(12);
		playerTwo.setSide(Side.shell);

		//Printing playing information after setting it
		System.out.println("Player two information:");
		System.out.println("\t" + playerTwo.getName());
		System.out.println("\t" + playerTwo.getTotalAvailablePieces());
		System.out.println("\t" + playerTwo.getSide());

		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("Succesfully passed all the test cases.");

	}

}
