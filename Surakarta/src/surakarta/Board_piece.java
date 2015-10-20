/**
 * Board_piece class Represents a piece on the board
 * 
 * @author Sarah Bullock ID 0785241
 */
public class Board_piece {
	//Constructor for the Board_piece class
	public Board_piece(char startIcon, int startId, Side startSide, int startX, int startY) {
		super();
		this.icon = startIcon;
		this.id = startId;
		this.side = startSide;
		this.board_piece_location_x = startX;
		this.board_piece_location_y = startY;
	}

	// Variable that stores the given icon the board will have on the screen
	private char icon;
	// Variable that stores the unique ID of the board piece
	private int id;

	// An enum that holds a shell and pebble value, this is a public variable
	public enum Side {
		shell, pebble
	};

	// Variable that is an enum and decides the side the player is on
	private Side side;
	// Variable that is the “x” location of the board piece on the board
	private int board_piece_location_x;
	// Variable that is the “y” location of the board piece on the board
	private int board_piece_location_y;

	// Set private int variable “id” to the value passed in from the argument
	// called “uniqueid”
	public char getIcon() {
		return icon;
	}

	// That value in an int variable called “id” is returned through the method
	// as an int return type
	public int getId() {
		return id;
	}

	// That value in a Side variable called “side” is returned through the
	// method as a Side return type
	public Side getSide() {
		return side;
	}

	// That value in an int variable called “board_piece_location_x” is returned
	// through the method as an int return type
	public int getBoard_piece_location_x() {
		return board_piece_location_x;
	}

	// That value in an int variable called “board_piece_location_y” is returned
	// through the method as an int return type
	public int getBoard_piece_location_y() {
		return board_piece_location_y;
	}

	// Set private char variable “icon” to the value passed in from the argument
	// called “i”
	public void setIcon(char icon) {
		this.icon = icon;
	}

	// Set private int variable “id” to the value passed in from the argument
	// called “uniqueid”
	public void setId(int id) {
		this.id = id;
	}

	// Set private Side variable “side” to the value passed in from the argument
	// called “s”
	public void setSide(Side side) {
		this.side = side;
	}

	// Set private int variable “board_piece_location_x” to the value passed in
	// from the argument called “x”
	public void setBoard_piece_location_x(int board_piece_location_x) {
		this.board_piece_location_x = board_piece_location_x;
	}

	// Set private int variable “board_piece_location_y” to the value passed in
	// from the argument called “y”
	public void setBoard_piece_location_y(int board_piece_location_y) {
		this.board_piece_location_y = board_piece_location_y;
	}

}
