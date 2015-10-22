/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Deon
 */

public class GameController {
    
    public static final int TOTALROW = 6;
    public static final int TOTALCOLUMN = 6;
    public static final int TOTALPIECES = 24;

    //int that stores total shells on board
    private int totalShells;
    //int that stores total pebbles on the board
    private int totalPebbles;
    //2D int array which stores total size of the board
    private char[][] boardGrid;
    //int that stores total rows of the boardGrid
    private int totalRows;
    //int that stores total columns of the boardGrid
    private int totalColumn;
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
    * primary constructor
    * sets the board grid rows and columns, updates current game and total games.
    */
    public GameController(int bgRow, int bgColumn, int g, int totalG){

        setBoardGridTotalRow(bgRow);
        setBoardGridTotalColumn(brColumn);
        gameNumber = g;
        totalGames = totalG;

    }

    /**
    * method setTotalShells
    * mutator method that sets the private variable totalShells
    * @param s - the integer to replace totalShells
    */
    public void setTotalShells(int s){
        totalShells = s;
    }
    
    /**
    * method setTotalPebbles
    * mutator method that sets the private variable totalPebbles
    * @param p - the integer to replace totalShells
    */
    public void setTotalPebbles(int p){
        totalPebbles = p;
    }
    
    /**
    * method setBoardGrid
    * mutator method that sets the private variable boardGrid
    * @param bg - the char array to replace boardGrid
    */
    public void setBoardGrid(char[][] bg){
        boardGrid = bg;
    }
    
    /**
    * method setBoardGridTotalRow
    * mutator method that sets the private variable totalRow
    * @param r - the integer to replace totalRow
    */
    private void setBoardGridTotalRow(int r){
        totalRow = r;
    }
    
    /**
    * method setBoardGridTotalColumn
    * mutator method that sets the private variable totalColumn
    * @param c - the integer to replace totalRow
    */
    private void setBoardGridTotalColumn(int c){
        totalColumn = c;
    }
    
    /**
    * method getTotalShells
    * accessor method that retreives the private variable totalShells
    * @return totalShells - returns the total number of shells in play
    */
    public int getTotalShells(){
        return totalShells;
    }
    
    /**
    * method getTotalPebbles
    * accessor method that retreives the private variable totalPebbles
    * @return totalPebbles - returns the total number of pebbles in play
    */
    public int getTotalPebbles(){
        return totalPebbles;
    }
    
    /**
    * method getTotalShells
    * accessor method that retreives the private variable boardGrid
    * @return boardGrid - returns the boardGrid array
    */
    public char[][] getBoardGrid(){
        return boardGrid;
    }
    
    /**
    * method getBoardGridTotalRow
    * accessor method that retreives the private variable totalRow
    * @return totalRow - returns the total number of rows on the board
    */
    public int getBoardGridTotalRow(){
        return totalRow;
    }
    
    /**
    * method getBoardGridTotalColumn
    * accessor method that retreives the private variable totalColumn
    * @return totalColumn - returns the total number of columns on the board
    */
    public int getBoardGridTotalColumn(){
        return totalColumn;
    }
    
    /**
    * method resetBoardState
    * this method initializes boardGrid as a new char array of size [totalRow][totalColumn]
    * sets every element in the boardGrid array to a pebble, blank space, or shell
    * initializes boardPieces as a new array of size [TOTALPIECES]
    * loops through the boardPieces array and makes each element its own unique piece
    */
    public void resetBoardState(){

        setBoardGridTotalRow(TOTALROW);
        setBoardGridTotalColumn(TOTALCOLUMN);
        boardGrid = new char[totalRow][totalColumn];

        for(int i= 0; i < totalRow; i++){
            for(int j = 0; j < totalColumn; j++){
                if(i < 2){
                    boardGrid[i][j] = 'P';
                }
                else if(i >= 2 && i < 4){
                    boardGrid[i][j] = '+';
                }
                else{
                    boardGrid[i][j] = 'S';
                }
            }
        }

        boardPieces = new BoardPieces[TOTALPIECES];
        
        int bpCounter = 0;
        for(int i = 0; i < totalRow; i++){
            boardPieces[bpCounter].setId(bpCounter);
            boardPieces[bpCounter].setIcon('S');
            boardPieces[bpCounter].setBoardPieceLocationX(i);
            boardPieces[bpCounter].setBoardPieceLocationY(0);
            bpCounter++;
        }
        for(int i = 0; i < totalRow; i++){
            boardPieces[bpCounter].setId(bpCounter);
            boardPieces[bpCounter].setIcon('S');
            boardPieces[bpCounter].setBoardPieceLocationX(i);
            boardPieces[bpCounter].setBoardPieceLocationY(1);
            bpCounter++;
        }
        for(int i = 0; i < totalRow; i++){
            boardPieces[bpCounter].setId(bpCounter);
            boardPieces[bpCounter].setIcon('P');
            boardPieces[bpCounter].setBoardPieceLocationX(i);
            boardPieces[bpCounter].setBoardPieceLocationY(4);
            bpCounter++;
        }
        for(int i = 0; i < totalRow; i++){
            boardPieces[bpCounter].setId(bpCounter);
            boardPieces[bpCounter].setIcon('P');
            boardPieces[bpCounter].setBoardPieceLocationX(i);
            boardPieces[bpCounter].setBoardPieceLocationY(5);
            bpCounter++;
        }

    }

    public void executePlayerTurn(){

        //integer that represents selection of move or capture
        int selection;
        //integer array that stores starting column, row and ending column, row for desired move
        int [] coords;
        //integer that stores the array element in boardPiece in the event that the desired move is valid
        int validation = -1;

        View.Show_Board(boardGrid, boardPieces);

        //while loop that checks for validation on the move/ capture
        while(validation == -1){
            selection = View.isTurnMoveOrCapture();
            coords = View.getTurnCoordinates();

            if(selection == 0){
                validation = validateMove(coords[0], coords[1], coords[2], coords[3]);
            }
            else{
                validation = validateCapture(coords[0], coords[1], coords[2], coords[3]);
            }
        }

        //performing the move once validated
        if(selection == 0){
            boardPieces[validation].setBoardPieceLocationX(coords[2]);
            boardPieces[validation].setBoardPieceLocationY(coords[3]);
            boardGrid[coords[0], coords[1]] = '+';
            if(boardPieces[validation].getSide() == shell)
                boardGrid[coords[2], coords[3]] = 'S';
            else
                boardGrid[coords[2], coords[3]] = 'P';
        }

        //performing the capture once validated
        else{

        }


    }

    public int validateMove(int startingX, int startingY, int endingX, int endingY){
        
        int chosenPiece, desired, xLoc, yLoc;

        chosenPiece = -1;
        desired = -1;

        for(int i = 0; i < boardPieces.length; i++){
            xLoc = boardPieces[i].getBoardPieceLocationX();
            yLoc = boardPieces[i].getBoardPieceLocationY();
            if(xLoc == startingX && yLoc == startingY)
                chosenPiece = i;
            if(xloc == endingX && yLoc == endingY)
                desired = i;
        }
        
        //if the desired spot is taken, or the chosen piece does not actually have a piece
        if(desired != -1 || chosenPiece == -1)
            return -1;
        //if the desired column or row is more than 1 column or row away
        if(Math.abs(startingX - endingX) > 1 || Math.abs(startingY - endingY) > 1)
            return -1;
        //if the column is out of bounds
        if(endingX < 0 || endingX > 5)
            return -1;
        //if the row is out of bounds
        if(endingY < 0 || endingY > 5)
            return -1;
        
        return chosenPiece;
    } 
    
    public boolean validateCapture(int startingX, int startingY, int endingX, int endingY){

        int chosenPiece, desired, xLoc, yLoc;

        chosenPiece = -1;
        captured = -1;

        for(int i = 0; i < boardPieces.length; i++){
            xLoc = boardPieces[i].getBoardPieceLocationX();
            yLoc = boardPieces[i].getBoardPieceLocationY();
            if(xLoc == startingX && yLoc == startingY)
                chosenPiece = i;
            if(xloc == endingX && yLoc == endingY)
                captured = i;
        }

        //if the desired spot is empty or the chosen piece does not actually have a piece
        if(captured == -1 || chosenPiece == -1)
            return -1;
        //if the side of the captured piece is the same as the side of the moving piece
        if(boardPieces[captured].getSide() == boardPieces[chosen].getSide())
            return -1;
        //if the column is out of bounds
        if(endingX < 0 || endingX > 5)
            return -1;
        //if the row is out of bounds
        if(endingY < 0 || endingY > 5)
            return -1;
        

    }

    /**
    * method isGameOver
    * method that determines whether the game is over based on the remaining pebbles and shells
    * @return - the method returns 0 or 1 depending on which player is the winner.
    *           if there is no immediate winner, the method returns -1
    */
    public int isGameOver(){
        
        //int that determines whether there is a winner.
        int winner = -1;

        //winner is pebbles player, and winner variable is set to the index of the pebbles player
        if(totalShells == 0){
            winner = shells;
        }

        //winner is shells player
        else if(totalPebbles == 0){
            winner = pebbles;
        }
        
        //if the game has a winner, update their score, display score, return their index
        if(winner != -1){
            player[winner].setScore(player[winner].getScore() + 1);
            View.displayScore(player, gameNumber, totalGames);
            return winner;
        }
        return -1;
    }

}
