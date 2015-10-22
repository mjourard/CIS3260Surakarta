package surakarta;

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
        boardGrid = new char[totalRow][totalColumns];

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

        for (int i = 0; i < totalRow; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Shells, i, 0);
            bpCounter++;
        }
        for (int i = 0; i < totalRow; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Shells, i, 1);
            bpCounter++;
        }
        for (int i = 0; i < totalRow; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Pebbles, i, 4);
            bpCounter++;
        }
        for (int i = 0; i < totalRow; i++) {
            boardPieces[bpCounter] = new BoardPiece(bpCounter, Side.Pebbles, i, 5);
            bpCounter++;
        }

    }

    public void executePlayerTurn() {

        //integer that represents selection of move (0) or capture (1)
        int selection;
        //integer array that stores starting row, column and ending row, column for desired move
        int[] coords;
        //integer that stores the array element in boardPiece in the event that the desired move is valid
        int validation = -1;
        
        selection = 0;
        
        coords = new int[] {-1, -1, -1, -1};

        View.showBoard(boardGrid);

        //while loop that checks for validation on the move/ capture
        while (validation == -1) {
            selection = View.isTurnMoveOrCapture();
            coords = View.getTurnCoordinates();

            if (selection == 0) {
                validation = validateMove(coords[0], coords[1], coords[2], coords[3]);
                if (validation == -1) {
                    View.tellPlayerMoveInvalid();
                }
            } else {
                validation = validateCapture(coords[0], coords[1], coords[2], coords[3]);
                if (validation == -1) {
                    View.tellPlayerCaptureInvalid();
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
        }


        //performing the capture once validated
        
    }

    /**
     * Applies game logic to the proposed passed in move to determine whether the move is allowed or not.
     * @param startingRow The row of the piece being moved.
     * @param startingColumn The column of the piece being moved.
     * @param endingRow The destination row of the piece.
     * @param endingColumn The destination column of the piece.
     * @return -1 if the move is not valid. If the move is valid, the ID of the piece being moved is returned.
     */
    public int validateMove(int startingRow, int startingColumn, int endingRow, int endingColumn) {                        

        int chosenPiece, desired, xLoc, yLoc;

        chosenPiece = -1;
        desired = -1;

        for (int i = 0; i < boardPieces.length; i++) {
            xLoc = boardPieces[i].getColumn();
            yLoc = boardPieces[i].getRow();
            if (xLoc == startingRow && yLoc == startingColumn) {
                chosenPiece = i;
            }
            if (xLoc == endingRow && yLoc == endingColumn) {
                desired = i;
            }
        }

        //if the desired spot is taken, or the chosen piece does not actually have a piece
        if (desired != -1 || chosenPiece == -1) {
            return -1;
        }
        //if the desired column or row is more than 1 column or row away
        if (Math.abs(startingRow - endingRow) > 1 || Math.abs(startingColumn - endingColumn) > 1) {
            return -1;
        }
        //if the column is out of bounds
        if (endingRow < 0 || endingRow > 5) {
            return -1;
        }
        //if the row is out of bounds
        if (endingColumn < 0 || endingColumn > 5) {
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
                    while (startingColumn > 1) {
                        startingColumn--;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }

                } else if (direction == Direction.Right) {
                    while (startingColumn < 6) {
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
                    while (startingRow > 1) {
                        startingRow--;
                        if (this.getBoardGrid()[startingRow][startingColumn] != '+') {
                            hitPiece = true;
                            break;
                        }
                    }
                } else if (direction == Direction.Down) {
                    while (startingRow < 6) {
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

        return this.doesLoopLeadToCapture(startingColumn, startingRow, endingRow, endingColumn, nextDirection, nextGridDirection);
    } /* end of doesLoopLeadToCapture */


    /**
     * Applies game logic to the proposed passed in move to determine if the
     * capture passed in is valid or not.
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

        boolean outerLoopAccess;

        int passedColumn;

        int passedRow;

        boolean sameColumn;

        boolean sameRow;

        if (!isIntersectionOccupied(startingRow, startingColumn) || !isIntersectionOccupied(endingRow, endingColumn)) {
            return -1;
        }

        //Determine if the piece at the starting location is yours
        if (this.getSideOfPiece(startingRow, startingColumn) != this.turn) {
            return -1;
        }

        //Determine if the piece at the end location is theirs
        if (this.getSideOfPiece(endingRow, endingColumn) == this.turn) {
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
        if ((startingRow == 2 || startingRow == 5) || (startingColumn == 2 || startingColumn == 5)) {
            if ((endingRow == 2 || endingRow == 5) || (endingColumn == 2 || endingColumn == 5)) {
                innerLoopAccess = true;
            }
        }

        //Determine outer loop access
        if ((startingRow == 3 || startingRow == 4) || (startingColumn == 3 || startingColumn == 4)) {
            if ((endingRow == 3 || endingRow == 4) || (endingColumn == 3 || endingColumn == 4)) {
                outerLoopAccess = true;
            }
        }

        if (!innerLoopAccess && !outerLoopAccess) {
            return -1;
        }

        if (!sameColumn || (sameColumn && startingRow < endingRow)) {

            //Start the loop one move up to avoid hitting the capturing piece in the algorithm.
            if (startingRow == 1) {
                passedRow = startingColumn;
                passedColumn = startingRow;
            } else {
                passedRow = startingRow - 1;
                passedColumn = startingColumn;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, Direction.Up, GridDirection.Column)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        if (!sameColumn || (sameColumn && startingRow > endingRow)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingRow == 6) {
                passedRow = startingColumn;
                passedColumn = startingRow;
            } else {
                passedRow = startingRow + 1;
                passedColumn = startingColumn;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, Direction.Down, GridDirection.Column)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        if (!sameRow || (sameRow && startingColumn > endingColumn)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingColumn == 6) {
                passedRow = startingColumn;
                passedColumn = startingRow;
            } else {
                passedRow = startingRow;
                passedColumn = startingColumn + 1;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, Direction.Right, GridDirection.Row)) {
                for (BoardPiece piece : this.boardPieces) {
                    if (piece.getRow() == startingRow && piece.getColumn() == startingColumn) {
                        return piece.getId();
                    }
                }

                return -1;
            }
        }

        if (!sameRow || (sameRow && startingColumn < endingColumn)) {

            //Start the loop one move down to avoid hitting the capturing piece in the algorithm.
            if (startingColumn == 1) {
                passedRow = startingColumn;
                passedColumn = startingRow;
            } else {
                passedRow = startingRow;
                passedColumn = startingColumn - 1;
            }

            if (this.doesLoopLeadToCapture(passedRow, passedColumn, endingRow, endingColumn, Direction.Left, GridDirection.Row)) {
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

}
