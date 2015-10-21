/**
 * This class stores the critical information about the board pieces.
 * @author
 */
public class BoardPiece {
	private int id;

	public enum Side {shell, pebble}; //To be removed

	private Side side;
	private int boardLocationX;
	private int boardLocationY;

	/**
 	 * Default constructor for this class.
 	 */
	public BoardPiece() {

	}

	/**
 	 * Constructor for this class.
 	 * @param id
 	 * @param side
 	 * @param boardLocationX
 	 * @param boardLocationY
 	 */
	public BoardPiece(int id, Side side, int boardLocationX, int boardLocationY) {
		this.id = id;
		this.side = side;
		this.boardLocationX = boardLocationX;
		this.boardLocationY = boardLocationY;
	}

	/**
	 *
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
	public void setboardLocationX(int boardLocationX) {
		this.boardLocationX = boardLocationX;
	}

	/**
	 * Set the vertical position of the board piece.
	 */
	public void setboardLocationY(int boardLocationY) {
		this.boardLocationY = boardLocationY;
	}

	/**
	 *
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
	public int getboardLocationX() {
		return boardLocationX;
	}

	/**
	 * Get the vertical position of the board piece.
	 */
	public int getboardLocationY() {
		return boardLocationY;
	}	
}
