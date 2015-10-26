package surakarta;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Deon
 */
public class GameController {

    public static final int TOTALROW = 6;
    public static final int TOTALCOLUMN = 6;
    public static final int TOTALPIECES = 24;

    private enum Direction {

        Up,
        Right,
        Down,
        Left
    }

    private enum GridDirection {

        Row,
        Column
    }

    //int that stores total shells on board
    private int totalShells;
    //int that stores total pebbles on the board
    private int totalPebbles;
    //2D int array which stores total size of the board
    private char[][] boardGrid;
    //int that stores total rows of the boardGrid
    private int totalRow;
    //int that stores total columns of the boardGrid
    private int totalColumns;
    //Player array storing both instances of the players
    private Player[] player;
    //BoardPiece array that stores the 24 board piece objects
    private BoardPiece[] boardPieces;
    //Enum of type Side that represents whichever side's turn it is
    private Side turn;
    //int that stores current game number being played
    private int gameNumber;
    //int that stores total games played
    private int totalGames;

    /**
     * primary constructor sets the board grid rows and columns, updates current
     * game and total games.
     */
    public GameController(int bgRow, int bgColumn, int g, int totalG) {

        setBoardGridTotalRow(bgRow);
        setBoardGridTotalColumn(bgColumn);
        gameNumber = g;
        totalGames = totalG;

    }

    /**
     * method setTotalShells mutator method that sets the private variable
     * totalShells
     *
     * @param s - the integer to replace totalShells
     */
    public void setTotalShells(int s) {
        totalShells = s;
    }

    /**
     * method setTotalPebbles mutator method that sets the private variable
     * totalPebbles
     *
     * @param p - the integer to replace totalShells
     */
    public void setTotalPebbles(int p) {
        totalPebbles = p;
    }

    /**
     * method setBoardGrid mutator method that sets the private variable
     * boardGrid
     *
     * @param bg - the char array to replace boardGrid
     */
    public void setBoardGrid(char[][] bg) {
        boardGrid = bg;
    }

    /**
     * method setBoardGridTotalRow mutator method that sets the private variable
     * totalRow
     *
     * @param r - the integer to replace totalRow
     */
    private void setBoardGridTotalRow(int r) {
        totalRow = r;
    }

    /**
     * method setBoardGridTotalColumn mutator method that sets the private
     * variable totalColumns
     *
     * @param c - the integer to replace totalRow
     */
    private void setBoardGridTotalColumn(int c) {
        totalColumns = c;
    }

    /**
     * method getTotalShells accessor method that retreives the private variable
     * totalShells
     *
     * @return totalShells - returns the total number of shells in play
     */
    public int getTotalShells() {
        return totalShells;
    }

    /**
     * method getTotalPebbles accessor method that retreives the private
     * variable totalPebbles
     *
     * @return totalPebbles - returns the total number of pebbles in play
     */
    public int getTotalPebbles() {
        return totalPebbles;
    }

    /**
     * method getTotalShells accessor method that retreives the private variable
     * boardGrid
     *
     * @return boardGrid - returns the boardGrid array
     */
    public char[][] getBoardGrid() {
        return boardGrid;
    }

    /**
     * method getBoardGridTotalRow accessor method that retrieves the private
     * variable totalRow
     *
     * @return totalRow - returns the total number of rows on the board
     */
    public int getBoardGridTotalRow() {
        return totalRow;
    }

    /**
     * method getBoardGridTotalColumn accessor method that retreives the private
     * variable totalColumns
     *
     * @return totalColumns - returns the total number of columns on the board
     */
    public int getBoardGridTotalColumn() {
        return totalColumns;
    }

    /**
     * method resetBoardState this method initializes boardGrid as a new char
     * array of size [totalRow][totalColumns] sets every element in the
     * boardGrid array to a pebble, blank space, or shell initializes
     * boardPieces as a new array of size [TOTALPIECES] loops through the
     * boardPieces array and makes each element its own unique piece
     */
    public void resetBoardState() {

        setBoardGridTotalRow(TOTALROW);
        setBoardGridTotalColumn(TOTALCOLUMN);
        this.boardGrid = new char[totalRow][totalColumns];

        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalColumns; j++) {
                if (i < 2) {
                    boardGrid[i][j] = 'P';
                } else if (i >= 2 && i < 4) {
                    boardGrid[i][j] = '+';
                } else {
                    boardGrid[i][j] = 'S';
                }
            }
        }

        boardPieces = new BoardPiece[TOTALPIECES];

        int bpCounter = 0;

        for (int i = 0; i < totalColumns; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Pebbles, 0, i);
            bpCounter++;
        }
        for (int i = 0; i < totalColumns; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Pebbles, 1, i);
            bpCounter++;
        }
        for (int i = 0; i < totalColumns; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Shells, 4, i);
            bpCounter++;
        }
        for (int i = 0; i < totalColumns; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Shells, 5, i);
            bpCounter++;
        }
        
        this.totalShells = 12;
        
        this.totalPebbles = 12;

    }

    /**
     * Handles asking the player to make a move, as well as updating all the internal data to reflect the move made by the user.
     */
    public void executePlayerTurn() {

        //integer that represents selection of move (0) or capture (1)
        int selection;
        //integer array that stores starting row, column and ending row, column for desired move
        int[] coords;
        //integer that stores the array element in boardPiece in the event that the desired move is valid
        int validation = -1;

        selection = 0;

        coords = new int[]{-1, -1, -1, -1};

        View.showBoard(boardGrid);
        
        /*System.out.println("Board Data:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("[" + boardGrid[i][j] + "]");
            }
            System.out.println("");
        }*/

        //while loop that checks for validation on the move/ capture
        while (validation == -1) {
            selection = View.isTurnMoveOrCapture(this.turn);
            coords = View.getTurnCoordinates();

            if (selection == 0) {                
                validation = validateMove(coords[0], coords[1], coords[2], coords[3]);                
            } else {
                validation = validateCapture(coords[0], coords[1], coords[2], coords[3]);                
                if (validation == -1) {
                    System.out.println("If nothing was displayed, missed a case.");
                }
            }
        }

        //performing the move once validated
        boardPieces[validation].setRow(coords[2]);
        boardPieces[validation].setColumn(coords[3]);
        boardGrid[coords[0]][coords[1]] = '+';
        if (boardPieces[validation].getSide() == Side.Shells) {
            boardGrid[coords[2]][coords[3]] = 'S';
        } else {
            boardGrid[coords[2]][coords[3]] = 'P';
        }

        if (selection == 1) {
            //update the enemy piece
            for (BoardPiece piece : boardPieces) {
                if (piece.getRow() == coords[2] && piece.getColumn() == coords[3] && piece.getSide() != boardPieces[validation].getSide()) {
                    //elminate the piece
                    piece.setRow(-1);
                    piece.setColumn(-1);
                    break;
                }
            }
            
            if (turn == Side.Pebbles) {
                totalShells--;
            } else {
                totalPebbles--;
            }
        }

        //performing the capture once validated
    }

    /**
     * Applies game logic to the proposed passed in move to determine whether
     * the move is allowed or not.
     *
     * @param startingRow The row of the piece being moved.
     * @param startingColumn The column of the piece being moved.
     * @param endingRow The destination row of the piece.
     * @param endingColumn The destination column of the piece.
     * @return -1 if the move is not valid. If the move is valid, the ID of the
     * piece being moved is returned.
     */
    public int validateMove(int startingRow, int startingColumn, int endingRow, int endingColumn) {

        int chosenPiece, desired, currentRow, currentColumn;

        chosenPiece = -1;
        desired = -1;
        
        //if the column is out of bounds
        if (endingRow < 0 || endingRow > 5) {
            throw new IllegalArgumentException("The endingRow parameter was out of bounds.");            
        }
        //if the row is out of bounds
        if (endingColumn < 0 || endingColumn > 5) {
            throw new IllegalArgumentException("The endingColumn parameter was out of bounds.");            
        }                

        for (int i = 0; i < boardPieces.length; i++) {
            
            currentRow = boardPieces[i].getRow();
            currentColumn = boardPieces[i].getColumn();             
            if (currentRow == startingRow && currentColumn == startingColumn) {
                chosenPiece = i;
            }
            if (currentRow == endingRow && currentColumn == endingColumn) {
                desired = i;
            }
        }

        //if the desired spot is taken, or the chosen piece does not actually have a piece
        if (chosenPiece == -1) {
            View.tellPlayerMoveInvalid(InvalidMoveReason.NoPieceSelected);
            return -1;
        }
        
        if (desired != -1) {
            View.tellPlayerMoveInvalid(InvalidMoveReason.EndCoordinatesOccupied);
            return -1;
        }
        //if the desired column or row is more than 1 column or row away
        if (Math.abs(startingRow - endingRow) > 1 || Math.abs(startingColumn - endingColumn) > 1) {
            View.tellPlayerMoveInvalid(InvalidMoveReason.EndCoordinatesOutOfRange);
            return -1;
        }
        
        //If the piece selected to move does not belong to the player whose turn it is
        if (boardPieces[chosenPiece].getSide() != this.turn) {
            View.tellPlayerMoveInvalid(InvalidMoveReason.OpponentsPieceSelected);
            return -1;
        }
        

        return chosenPiece;
    }

    /**
     * A method that returns the side a piece belongs to.
     *
     * @param row the row the piece belongs to.
     * @param column the column that the piece belongs to.
     * @return the side the piece belongs to.
     */
    private Side getSideOfPiece(int row, int column) {
        if (this.boardGrid[row][column] == 'S') {
            return Side.Shells;
        } else if (this.boardGrid[row][column] == 'P') {
            return Side.Pebbles;
        } else {
            throw new IllegalArgumentException("The passed in row and column do not have a boardPiece at their intersection.");
        }

    }

    /**
     * A method to determine if an intersecting row and column have a piece at
     * them.
     *
     * @param row The row of the intersection.
     * @param column The column of the intersection.
     * @return true if the intersection is occupied by a piece, false if it is
     * empty.
     */
    private boolean isIntersectionOccupied(int row, int column) {
        return this.boardGrid[row][column] != '+';
    }

    /**
     * The initial calling of this recursive method needs to be passed in
     * coordinates one intersection ahead of the original piece in the direction
     * that the piece is travelling. 1. Determine if the path to the loop is
     * clear. 1a path not clear, if first impass is ending coordinates, capture
     * is valid. Otherwise the loop is invalid. 1b path is clear, go to end of
     * row or column 2. invert row and column values, begin back at step 1,
     * passing in the new direction and the other value of GridDirection.
     *
     * @param startingRow
     * @param startingColumn
     * @param endingRow
     * @param endingColumn
     * @param direction
     * @param gridDirection
     * @return True if following loops can lead to the passed in endingRow and
     * endingRow. False otherwise.
     */
    private boolean doesLoopLeadToCapture(int startingRow, int startingColumn, int endingRow, int endingColumn, Direction direction, GridDirection gridDirection) {

        boolean hitPiece;

        Direction nextDirection;

        GridDirection nextGridDirection;
        
        int nextColumn;
        
        int nextRow;                

        if (startingRow == endingRow && startingColumn == endingColumn) {
            return true;
        } else if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
            return false;
        }

        hitPiece = false;
        //Taking a loop:
        //1 determine if traversing a row or column, and going up/down or left/right
        switch (gridDirection) {
            case Row:
                if (direction == Direction.Left) {
                    while (startingColumn > 0) {
                        startingColumn--;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }

                } else if (direction == Direction.Right) {
                    while (startingColumn < 5) {
                        startingColumn++;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("The direction variable must be Left or Right when gridDirection is set to Row.");
                }

                if (startingRow >= 4) {
                    nextDirection = Direction.Up;
                } else {
                    nextDirection = Direction.Down;
                }

                nextGridDirection = GridDirection.Column;

                break;
            case Column:
                if (direction == Direction.Up) {
                    while (startingRow > 0) {
                        startingRow--;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }
                } else if (direction == Direction.Down) {
                    while (startingRow < 5) {
                        startingRow++;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("The direction variable must be Up or Down when gridDirection is set to Column.");
                }

                if (startingColumn >= 4) {
                    nextDirection = Direction.Left;
                } else {
                    nextDirection = Direction.Right;
                }

                nextGridDirection = GridDirection.Row;
                break;
            default:
                throw new IllegalArgumentException("The gridDirection variable has been modified to include more than just the 'Row' and 'Column' values. Please revise.");
        } /* end of the switch statement */

        if (hitPiece) {
            return (startingRow == endingRow && startingColumn == endingColumn);
        }

        /* determine which end the loop comes out of */
        switch (direction) {
            case Up:
                if (nextDirection == Direction.Left) {
                    nextRow = 5 - startingColumn;
                    nextColumn = 5;
                } else {
                    nextRow = startingColumn;
                    nextColumn = 0;
                }
                break;
            case Right:
                if (nextDirection == Direction.Up) {
                    nextRow = 5;
                    nextColumn = startingRow;
                } else {
                    nextRow = 0;
                    nextColumn = 5 - startingRow;
                }
                break;
            case Down:
                if (nextDirection == Direction.Left) {
                    nextRow = startingColumn;
                    nextColumn = 5;
                } else {
                    nextRow = 5 - startingColumn;
                    nextColumn = 5;
                }
                break;
            case Left:
                if (nextDirection == Direction.Up) {
                    nextRow = 5;
                    nextColumn = 5 - startingRow;
                } else {
                    nextRow = 0;
                    nextColumn = startingRow;
                }
                break;
            default:
                throw new IllegalArgumentException("direction was not one of Up, Right, Left or Down. Review code base.");
        }
        return this.doesLoopLeadToCapture(nextRow, nextColumn, endingRow, endingColumn, nextDirection, nextGridDirection);
    } /* end of doesLoopLeadToCapture */


    /**
     * Applies game logic to the proposed passed in move to determine if the
     * capture passed in is valid or not. Rows and Columns are 0-based.
     *
     * @param startingRow The row of the capturing piece.
     * @param startingColumn The column of the capturing piece.
     * @param endingRow The row of the piece being captured.
     * @param endingColumn The column of the piece being captured.
     * @return -1 if the capture is invalid, and the ID of the piece doing the
     * capturing if it is a valid capture.
     */
    public int validateCapture(int startingRow, int startingColumn, int endingRow, int endingColumn) {

        boolean innerLoopAccess;
        
        Direction nextDirection;
        
        GridDirection nextGridDirection;

        boolean outerLoopAccess;

        int passedColumn;

        int passedRow;

        boolean sameColumn;

        boolean sameRow;

        if (!isIntersectionOccupied(startingRow, startingColumn)) {                            
            View.tellPlayerCaptureInvalid(InvalidCaptureReason.NoPieceSelected);
            return -1;
        }
        
        if (!isIntersectionOccupied(endingRow, endingColumn)) {
            View.tellPlayerCaptureInvalid(InvalidCaptureReason.NoOpponentsPieceSelected);
            return -1;
        }

        //Determine if the piece at the starting location is yours
        if (this.getSideOfPiece(startingRow, startingColumn) != this.turn) {
            View.tellPlayerCaptureInvalid(InvalidCaptureReason.OpponentsPieceSelectedWithStartCoordinates);
            return -1;
        }

        //Determine if the piece at the end location is theirs
        if (this.getSideOfPiece(endingRow, endingColumn) == this.turn) {
            View.tellPlayerCaptureInvalid(InvalidCaptureReason.FriendlyPieceSelectedWithEndCoordinates);
            return -1;
        }

        /* Determine if they set on the same circuit
         * There are two loops available to pieces: an inner loop and an outer loop
         * If a piece has a 2 or a 5 as one of the coordinates, it has access to the inner loop.
         * If a piece has a 3 or a 4 as one of the coordinates, it has access to the outer loop. 
         * if both coordinates have access to either loop, they can capture each other. */
        innerLoopAccess = false;

        outerLoopAccess = false;

        sameRow = startingRow == endingRow;

        sameColumn = startingColumn == endingColumn;

        //Determine inner loop access
        if ((startingRow == 1 || startingRow == 4) || (startingColumn == 1 || startingColumn == 4)) {
            if ((endingRow == 1 || endingRow == 4) || (endingColumn == 1 || endingColumn == 4)) {
                innerLoopAccess = true;
            }
        }

        //Determine outer loop access
        if ((startingRow == 2 || startingRow == 3) || (startingColumn == 2 || startingColumn == 3)) {
            if ((endingRow == 2 || endingRow == 3) || (endingColumn == 2 || endingColumn == 3)) {
                outerLoopAccess = true;
            }
        }

        if (!innerLoopAccess && !outerLoopAccess) {
            View.tellPlayerCaptureInvalid(InvalidCaptureReason.NoLoopSequenceAvailableToReachEndCoordinates);
            return -1;
        }
        
        /*************
         * MOVING UP *
         *************/
        if (!sameColumn || (sameColumn && startingRow < endingRow)) {

            //Start the loop one move up to avoid hitting the capturing piece in the algorithm.
            
            if (startingRow == 0) {
                //the passedRow and passedColumns are given startingColumn and startingRow respectively when startingRow is set to 0 because they are already on a loop and are taking it.
                if (startingColumn <= 2) {
                    passedRow = startingColumn;
                    passedColumn = 0;
                    nextDirection = Direction.Right;                    
                } else {
                    passedRow = 5 - startingColumn;
                    passedColumn = 5;
                    nextDirection = Direction.Left;
                }                
                nextGridDirection = GridDirection.Row;
            } else {
                passedRow = startingRow - 1;
                passedColumn = startingColumn;
                nextDirection = Direction.Up;
                nextGridDirection = GridDirection.Column;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, nextDirection, nextGridDirection)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        /***************
         * MOVING DOWN *
         ***************/
        if (!sameColumn || (sameColumn && startingRow > endingRow)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingRow == 5) {
                if (startingColumn <= 2) {
                    nextDirection = Direction.Right;
                    passedRow = 5 - startingColumn;
                    passedColumn = 0;
                } else {
                    nextDirection = Direction.Left;
                    passedRow = startingColumn;
                    passedColumn = 5;
                }
                nextGridDirection = GridDirection.Row;
            } else {
                passedRow = startingRow + 1;
                passedColumn = startingColumn;
                nextDirection = Direction.Down;
                nextGridDirection = GridDirection.Column;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, nextDirection, nextGridDirection)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        /****************
         * MOVING RIGHT *
         ****************/
        if (!sameRow || (sameRow && startingColumn > endingColumn)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingColumn == 5) {
                if (startingRow <= 2) {
                    passedRow = 0;
                    passedColumn = 5 - startingRow;
                    nextDirection = Direction.Down;                    
                } else {
                    passedRow = 5;
                    passedColumn = startingRow;
                    nextDirection = Direction.Up;
                }
                nextGridDirection = GridDirection.Column;
            } else {
                passedRow = startingRow;
                passedColumn = startingColumn + 1;
                nextDirection = Direction.Right;
                nextGridDirection = GridDirection.Row;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, nextDirection, nextGridDirection)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        /***************
         * MOVING LEFT *
         ***************/
        if (!sameRow || (sameRow && startingColumn < endingColumn)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingColumn == 0) {
                if (startingRow <= 2) {
                    passedRow = 0;
                    passedColumn = startingRow;
                    nextDirection = Direction.Down;
                } else {
                    passedRow = 5;
                    passedColumn = 5 - startingRow;
                    nextDirection = Direction.Up;
                }
                nextGridDirection = GridDirection.Column;                
            } else {
                passedRow = startingRow;
                passedColumn = startingColumn - 1;
                nextDirection = Direction.Left;
                nextGridDirection = GridDirection.Row;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, nextDirection, nextGridDirection)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            } else {
                return -1;
            }
        }
        
        return -1;
    }

    /**
     * method isGameOver method that determines whether the game is over based
     * on the remaining pebbles and shells
     *
     * @return - the method returns 0 or 1 depending on which player is the
     * winner. if there is no immediate winner, the method returns -1
     */
    public int isGameOver() {

        //int that determines whether there is a winner.
        int winner = -1;

        //winner is pebbles player, and winner variable is set to the index of the pebbles player
        System.out.println("totalShells = " + Integer.toString(totalShells) + ", totalPebbles = " + Integer.toString(totalPebbles));
        if (totalShells == 0) {
            winner = Side.Shells.ordinal();
        } //winner is shells player
        else if (totalPebbles == 0) {
            winner = Side.Pebbles.ordinal();
        }

        //if the game has a winner, update their score, display score, return their index
        if (winner != -1) {
            View.displayScore(this.player, gameNumber, totalGames);
            return winner;
        }
        return -1;
    }

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

        String userMenuChoice = "default";						//The players' menu choice 
        String playerOneName;									//The name of player one
        String playerTwoName;									//The name of player two
        int totalGames;											//Number of total games the players want to play
        Player playerOne;										//Player instance for player one						
        Player playerTwo;										//Player instance for player two
        GameController surakarta;								//Game controller instance for Surakarta
        View surakartaBoard;									//View instance for Surakarta
        Scanner userInput;										//Scanner

        //Display greeting message
        System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\tWELCOME TO SURAKARTA!");
        System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println("Surakarta is an indonesian strategy board game made for 2 players to play.\n"
                + "It is a turn based game that involves a uniquely designed board and 12 pieces\n"
                + "per player which are represented as shells and pebbles.\n");

        //Display Surakarta menu
        System.out.println("----------------");
        System.out.println("SURAKARTA MENU");
        System.out.println("----------------");
        System.out.println("(1) Play");
        System.out.println("(q) Quit\n");

        userInput = new Scanner(System.in);

        //Loop until you get the correct user input
        while ((!userMenuChoice.equalsIgnoreCase("quit"))
                && (!userMenuChoice.equalsIgnoreCase("q"))
                && (!userMenuChoice.equalsIgnoreCase("play"))
                && (!userMenuChoice.equalsIgnoreCase("1"))) {

            //Get the user input
            userMenuChoice = userInput.nextLine();

            //Play
            if ((userMenuChoice.equalsIgnoreCase("play")) || (userMenuChoice.equalsIgnoreCase("1"))) {

                //Create player one
                System.out.println("Please enter Player 1 name: ");
                playerOneName = userInput.nextLine();
                //MODIFY HOW WE CALL ENUM
                playerOne = new Player(playerOneName, 12, Side.Shells);

				//Printing player one information
				/*System.out.println("Player one information:");
                 System.out.println("\t" + playerOne.getName());
                 System.out.println("\t" + playerOne.getTotalAvailablePieces());
                 System.out.println("\t" + playerOne.getSide());*/
                //Create player two
                System.out.println("Please enter Player 2 name: ");
                playerTwoName = userInput.nextLine();
                //MODIFY HOW WE CALL ENUM
                playerTwo = new Player(playerTwoName, 12, Side.Pebbles);

				//Printing player two information
				/*System.out.println("Player one information:");
                 System.out.println("\t" + playerTwo.getName());
                 System.out.println("\t" + playerTwo.getTotalAvailablePieces());
                 System.out.println("\t" + playerTwo.getSide());*/
                System.out.println("Please enter the number of total games you want to play: ");
                totalGames = userInput.nextInt();

                //Could be constants for the size of the board grid
                surakarta = new GameController(6, 6, 1, totalGames);
                surakarta.resetBoardState();
                surakarta.turn = Side.Pebbles;
                
                /* //Uncomment this section of code to test the validateCapture method 
                //Testing validateCapture
                surakarta.testValidateCapture();
                */
                                
                while (surakarta.isGameOver() == -1) {
                    surakarta.executePlayerTurn();
                    surakarta.turn = (surakarta.turn == Side.Pebbles) ? Side.Shells : Side.Pebbles;
                }
				//surakartaBoard = new View(surakarta.getBoardGrid, );  STOPPED HERE
                //Continue with the play functionality in here....
            } //Quit
            else if ((userMenuChoice.equalsIgnoreCase("quit")) || (userMenuChoice.equalsIgnoreCase("q"))) {
                System.out.println("Exiting Surakarta...");
                System.out.println("Bye-bye!\n");
            } //Invalid input
            else {
                System.err.println("Invalid choice: " + userMenuChoice);
            }
        }
    } /* end of main */
    
    /**
     * A method used to test the validateCapture method. Written in haste, this would need to be redone if a redesign was ever done as it relies on a lot of cheating to test quickly.
     */
    private void testValidateCapture() {                
        /******************/
        /* NEGATIVE CASES */
        /******************/
        
        /* Pass in start coordinates where there is no piece */
        this.resetBoardState();
        System.out.println("Beginning test for 'Pass in start coordinates where there is no piece' test.");
        if (this.validateCapture(2,2,3,3) != -1) {
            System.out.println("Failed the 'Pass in start coordinates where there is no piece' test.");
        }
        
        
        
        /* Pass in start coordinates where an opposing piece exists */
        System.out.println("Beginning test for 'Pass in start coordinates where an opposing piece exists' test.");
        if (this.validateCapture(4,0,3,3) != -1) {
            System.out.println("Failed the 'Pass in start coordinates where an opposing piece exists' test.");
        }
        
        /* Pass in end coordinates where there is no piece */
        System.out.println("Beginning test for 'Pass in end coordinates where there is no piece' test.");
        if (this.validateCapture(0,1,3,3) != -1) {
            System.out.println("Failed the 'Pass in end coordinates where there is no piece' test.");
        }
        
        /* Pass in end coordinates where there is a friendly piece */
        System.out.println("Beginning test for 'Pass in end coordinates where there is a friendly piece' test.");
        if (this.validateCapture(0,1,0,3) != -1) {
            System.out.println("Failed the 'Pass in end coordinates where there is a friendly piece' test.");
        }
        
        /*** SCENARIOS WHERE THE START COORDINATES HAVE A FRIENDLY PIECE AND THE END COORDINATES HAVE AN OPPOSING PIECE ***/
        
        /* The friendly piece is on a different loop than the enemy piece and hits a different piece */
        /* will use friendly piece at row 2, column 2 as well as row 3, column 3 and enemy piece at row 4, column 1 */        
        System.out.println("Beginning test for 'The friendly piece is on a different loop than the enemy piece and hits a different piece' test.");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 2 && j == 2) {
                    boardGrid[i][j] = 'P';
                } else if (i == 3 && j == 3) {
                    boardGrid[i][j] = 'P';
                } else if (i == 4 && j == 1) {
                    boardGrid[i][j] = 'S';                                    
                } else {
                    boardGrid[i][j] = '+';
                }
            }
        }
        
        for (BoardPiece piece : boardPieces) {
            
            piece.setRow(-1);
            piece.setColumn(-1);                
            
        }
        
        boardPieces[0].setRow(2);
        boardPieces[0].setColumn(2);
        
        boardPieces[1].setRow(3);
        boardPieces[1].setColumn(3);
        
        boardPieces[boardPieces.length - 1].setRow(4);
        boardPieces[boardPieces.length - 1].setColumn(1);
        
        if (this.validateCapture(1,0,5,2) != -1) {
            System.out.println("Failed the 'The friendly piece is on a different loop than the enemy piece and hits a different piece' test.");
        }
        
        /* The friendly piece is on a different loop than the enemy piece and hits itself in a full loop */        
        /* will use friendly piece at row 2, column 2 as well as row 3, column 3 and enemy piece at row 4, column 1 */        
        System.out.println("Beginning test for 'The friendly piece is on a different loop than the enemy piece and hits itself in a full loop' test.");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 2 && j == 2) {
                    boardGrid[i][j] = 'P';                
                } else if (i == 4 && j == 1) {
                    boardGrid[i][j] = 'S';                                    
                } else {
                    boardGrid[i][j] = '+';
                }
            }
        }
        
        for (BoardPiece piece : boardPieces) {
            
            piece.setRow(-1);
            piece.setColumn(-1);                
            
        }
        
        boardPieces[0].setRow(2);
        boardPieces[0].setColumn(2);                
        
        boardPieces[boardPieces.length - 1].setRow(4);
        boardPieces[boardPieces.length - 1].setColumn(1);
                
        if (this.validateCapture(1,0,5,2) != -1) {
            System.out.println("Failed the 'The friendly piece is on a different loop than the enemy piece and hits itself in a full loop' test.");
        }                
        
        /* The friendly piece is surrounded and cannot reach a loop */
        /* will use friendly pieces at (row, column): (2,2), (2,1), (1,2), (2,3), (3,2) and enemy piece at row 4, column 1 */        
        System.out.println("Beginning test for 'The friendly piece is surrounded and cannot reach a loop' test.");
        this.resetBoardState();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {                
                boardGrid[i][j] = '+';                
            }
        }
        
        boardGrid[2][2] = 'P';
        boardGrid[2][1] = 'P';
        boardGrid[1][2] = 'P';
        boardGrid[2][3] = 'P';
        boardGrid[3][2] = 'P';
        boardGrid[4][1] = 'S';
        
        for (BoardPiece piece : boardPieces) {
            
            piece.setRow(-1);
            piece.setColumn(-1);                
            
        }
        
        boardPieces[0].setRow(2);
        boardPieces[0].setColumn(2);                
        
        boardPieces[1].setRow(2);
        boardPieces[1].setColumn(1);                
        
        boardPieces[2].setRow(1);
        boardPieces[2].setColumn(2);                
        
        boardPieces[3].setRow(2);
        boardPieces[3].setColumn(3);                
        
        boardPieces[4].setRow(3);
        boardPieces[4].setColumn(2);                                
        
        boardPieces[boardPieces.length - 1].setRow(4);
        boardPieces[boardPieces.length - 1].setColumn(1);
        
        if (this.validateCapture(1,0,5,2) != -1) {
            System.out.println("Failed the 'The friendly piece is surrounded and cannot reach a loop' test.");
        }                
        
        
        /* The friendly piece can't reach a loop but has a straight shot at the enemy piece. */
        /* Will use basic setup for this */
        System.out.println("Beginning test for 'The friendly piece can't reach a loop but has a straight shot at the enemy piece' test.");
        this.resetBoardState();
        if (this.validateCapture(1,3,4,3) != -1) {
            System.out.println("Failed the 'The friendly piece can't reach a loop but has a straight shot at the enemy piece.' test.");
        }
        
        /******************/
        /* POSITIVE CASES */
        /******************/
        
        /* passes through one loop to get to the end piece */
        /* Will use a friendly piece at (1,1) and (2,1) and an enemy piece at (2,4) */
        System.out.println("Beginning test for 'passes through one loop to get to the end piece' test.");
        this.resetBoardState();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {                
                boardGrid[i][j] = '+';                
            }
        }
        
        boardGrid[1][1] = 'P';
        boardGrid[2][1] = 'P';        
        boardGrid[2][4] = 'S';
        
        for (BoardPiece piece : boardPieces) {
            
            piece.setRow(-1);
            piece.setColumn(-1);                
            
        }
        
        boardPieces[0].setRow(1);
        boardPieces[0].setColumn(1);                
        
        boardPieces[1].setRow(2);
        boardPieces[1].setColumn(1);                                
        
        boardPieces[boardPieces.length - 1].setRow(2);
        boardPieces[boardPieces.length - 1].setColumn(4);
        
        System.out.println("Beginning the 'passes through one loop to get to the end piece' test.");
        if (validateCapture(1,1,2,4) == -1) {
            System.out.println("Failed the 'passes through one loop to get to the end piece' test.");
        }
        
        /* passes through three loops to get to the end piece */
        /* will move the enemy piece from the last test to (4,1) */
        System.out.println("Beginning test for 'passes through three loops to get to the end piece' test.");
        boardGrid[2][4] = '+';
        boardGrid[4][1] = 'S';
        
        boardPieces[boardPieces.length - 1].setRow(4);
        boardPieces[boardPieces.length - 1].setColumn(1);
        
        System.out.println("Beginning the 'passes through three loops to get to the end piece' test.");
        if (validateCapture(1,1,4,1) == -1) {
            System.out.println("Failed the 'passes through three loops to get to the end piece' test.");
        }
    }

}
