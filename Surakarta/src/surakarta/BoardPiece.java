package surakarta;

/**
 * This class stores the critical information about the board pieces.
 * @author Sarah Bullock 
 */
public class BoardPiece {
	private int id;								//Unique ID of the board piece	
	private Side side;							//The side of the board piece - either shell or pebble
	private int column;			//The column location of the board piece
	private int row;			//The row location of the board piece

	/**
 	 * Default constructor for this class.
 	 */
	public BoardPiece() {

	}

	/**
 	 * Constructor for this class.
 	 * @param id - unique ID of the board piece
 	 * @param side - shell or pebble
         * @param row - the row location of the board piece
 	 * @param column - the column location of the board piece 	 
 	 */
	public BoardPiece(int id, Side side, int row, int column) {
		this.id = id;
		this.side = side;
		this.column = column;
		this.row = row;
	}

	/**
         * Set the unique ID of the board piece.
         * @param id The unique id of the board piece.
         */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the side of the board piece to be either a shell or a pebble.
	 */
	public void setSide(Side side) {
		this.side = side;
	}

	/**
	 * Set the horizontal position of the board piece.
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * Set the vertical position of the board piece.
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Get the unique ID of the board Piece.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the side the player is on. Could be either a shell or a pebble.
	 */
	public Side getSide() {
		return side;
	}

	/**
	 * Get the horizontal position of the board piece.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Get the vertical position of the board piece.
	 */
	public int getRow() {
		return row;
	}	


	/**
	 * The main method is used to test this class.
	 * @param args the command line arguments
	 */
	 public static void main (String[] args) {

	 	//TEST WITH DEFAULT CONSTRUCTOR
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("Testing creating board piece with the default constructor.");
		System.out.println("-------------------------------------------------------------\n");

		//Creating board piece one
		System.out.println("creating board piece one...\n");
		BoardPiece shellA = new BoardPiece();

		System.out.println("Board Piece one information:");
		System.out.println("\t" + shellA.getId());
		System.out.println("\t" + shellA.getSide());
		System.out.println("\t" + shellA.getColumn());
		System.out.println("\t" + shellA.getRow());

		//Initialize/setting values for board piece one
		System.out.println("\nSetting data for board Piece one...");
		shellA.setId(1);
		shellA.setSide(Side.Shells);
		shellA.setColumn(2);
		shellA.setRow(5);

		System.out.println("Board Piece one information:");
		System.out.println("\t" + shellA.getId());
		System.out.println("\t" + shellA.getSide());
		System.out.println("\t" + shellA.getColumn());
		System.out.println("\t" + shellA.getRow());

		//TEST WITH CONSTRUCTOR
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("Testing creating board piece with the constructor.");
		System.out.println("-------------------------------------------------------------\n");

		//Creating board piece two
		System.out.println("creating board piece two...\n");
		BoardPiece pebbleA = new BoardPiece(10, Side.Pebbles, 3, 7);

		System.out.println("Board Piece two information:");
		System.out.println("\t" + pebbleA.getId());
		System.out.println("\t" + pebbleA.getSide());
		System.out.println("\t" + pebbleA.getColumn());
		System.out.println("\t" + pebbleA.getRow());

		//Initialize/setting values for board piece one
		System.out.println("\nSetting data for board Piece two...");
		pebbleA.setId(1);
		pebbleA.setSide(Side.Pebbles);
		pebbleA.setColumn(2);
		pebbleA.setRow(5);

		System.out.println("Board Piece two information:");
		System.out.println("\t" + pebbleA.getId());
		System.out.println("\t" + pebbleA.getSide());
		System.out.println("\t" + pebbleA.getColumn());
		System.out.println("\t" + pebbleA.getRow());

		//Sucess
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("Succesfully passed all the test cases.");
		System.out.println("-------------------------------------------------------------\n");
	}
}
