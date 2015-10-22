package surakarta;

/**
 * This class represents a player of Surakarta.
 *
 * @author Alexander Gontcharov
 * @version 2.0
 * @since 10/19/2015
 */
public class Player {

    private String name;					//The name of the player
    private int totalAvailablePieces;		//The total number of board pieces that the player has on the board	
    private Side side;						//Decides the side the player starts on

    /**
     * Default constructor for this class.
     */
    public Player() {

    }

    /**
     * Constructor for this class.
     *
     * @param name - name of the player
     * @param totalAvailablePieces - How many current pieces the player has on
     * the board
     * @param side - shell or pebble
     */
    public Player(String name, int totalAvailablePieces, Side side) {
        this.name = name;
        this.totalAvailablePieces = totalAvailablePieces;
        this.side = side;
    }

    /**
     * Set the name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the total available pieces of the player.
     */
    public void setTotalAvailablePeices(int totalAvailablePieces) {
        this.totalAvailablePieces = totalAvailablePieces;
    }

    /**
     * Set the side of the player to be either shell or pebble.
     */
    public void setSide(Side side) {
        this.side = side;
    }

    /**
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the total available pieces of the player.
     */
    public int getTotalAvailablePieces() {
        return totalAvailablePieces;
    }

    /**
     * @return the side the player is on. Could be either a shell or a pebble.
     */
    public Side getSide() {
        return side;
    }

    /**
     * The main method is used to test this class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //TEST WITH DEFAULT CONSTRUCTOR
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Testing creating player with the default constructor.");
        System.out.println("-------------------------------------------------------------\n");

        //Creating player one
        System.out.println("creating player one...\n");
        Player playerOne = new Player();

        //Printing current player information
        System.out.println("Player one information:");
        System.out.println("\t" + playerOne.getName());
        System.out.println("\t" + playerOne.getTotalAvailablePieces());
        System.out.println("\t" + playerOne.getSide());

        //Initialize/setting values for player one
        System.out.println("\nSetting data for player one...\n");
        playerOne.setName("Alexander Gontcharov");
        playerOne.setTotalAvailablePeices(12);
        playerOne.setSide(Side.Shells);

        //Printing playing information after setting it
        System.out.println("Player one information:");
        System.out.println("\t" + playerOne.getName());
        System.out.println("\t" + playerOne.getTotalAvailablePieces());
        System.out.println("\t" + playerOne.getSide());

        //TEST WITH CONSTRUCTOR
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Testing creating player with the constructor.");
        System.out.println("-------------------------------------------------------------\n");

        //Creating player two
        System.out.println("creating player two...\n");
        Player playerTwo = new Player("Deon Naltchadjian", 12, Side.Pebbles);

        //Printing current player information
        System.out.println("Player two information:");
        System.out.println("\t" + playerTwo.getName());
        System.out.println("\t" + playerTwo.getTotalAvailablePieces());
        System.out.println("\t" + playerTwo.getSide());

        //Initialize/setting values for player two
        System.out.println("\nSetting data for player two...\n");
        playerTwo.setName("Matthew Jourard");
        playerTwo.setTotalAvailablePeices(6);
        playerTwo.setSide(Side.Shells);

        //Printing playing information after setting it
        System.out.println("Player two information:");
        System.out.println("\t" + playerTwo.getName());
        System.out.println("\t" + playerTwo.getTotalAvailablePieces());
        System.out.println("\t" + playerTwo.getSide());

        //Success
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("Succesfully passed all the test cases.");
        System.out.println("-------------------------------------------------------------\n");

    }
}
