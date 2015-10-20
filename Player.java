/**
 * This class stored critical information about the player of Surakarta.
 * @author Alexander Gontcharov
 * @version 1.0
 * @since 10/19/2015
 **/
public class Player {

	private String name;					//The name of the player
	private int total_avaiable_pieces;		//The total number of board pieces that the player has on the board
	public enum Side {shell, pebble;}		//An enum that holds a shell and pebble value
	private Side side;						//Decides the side the player starts on


	public Player() {

	}

    /**
 	 * Constructor for this class.
 	 **/
	public Player(String startName, int startTotalPieces, Side startSide) {
		this.name = startName;
		this.total_avaiable_pieces = startTotalPieces;
		this.side = startSide;
	}

    /**
 	 * Set the name of the player.
 	 **/
	public void setName(String n) {
		this.name = n;
	}

    /**
 	 * Set the total avaialble pieces of the player.
 	 **/
	public void setTotal_available_peices(int total) {
		this.total_avaiable_pieces = total;
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
	public int getTotal_available_pieces() {
		return total_avaiable_pieces;
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
		System.out.println("\t" + playerOne.getTotal_available_pieces());
		System.out.println("\t" + playerOne.getSide());

		//Initialize/set values for player one
		System.out.println("\nSetting data for player one...");
		playerOne.setName("Alexander Gontcharov");
		playerOne.setTotal_available_peices(12);
		playerOne.setSide(Side.shell);

		//Printing playing information after setting it
		System.out.println("Player one information:");
		System.out.println("\t" + playerOne.getName());
		System.out.println("\t" + playerOne.getTotal_available_pieces());
		System.out.println("\t" + playerOne.getSide());


		System.out.println("\n-------------------------------------------------------------\n");

		System.out.println("Testing creating player with the Constructor.");
		System.out.println("creating player...\n");

		//Creating player two
		Player playerTwo = new Player("Deon Naltchadjian", 12, Side.pebble);

		//Printing current player information
		System.out.println("Player two information:");
		System.out.println("\t" + playerTwo.getName());
		System.out.println("\t" + playerTwo.getTotal_available_pieces());
		System.out.println("\t" + playerTwo.getSide());

		//Initialize/set values for player two
		System.out.println("\nSetting data for player one...");
		playerTwo.setName("Matthew Jourard");
		playerTwo.setTotal_available_peices(12);
		playerTwo.setSide(Side.shell);

		//Printing playing information after setting it
		System.out.println("Player two information:");
		System.out.println("\t" + playerTwo.getName());
		System.out.println("\t" + playerTwo.getTotal_available_pieces());
		System.out.println("\t" + playerTwo.getSide());

		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("Succesfully passed all the test cases.");

	}

}
