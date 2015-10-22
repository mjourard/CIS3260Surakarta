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
    private int boardGridTotalRow;
    private int boardGridTotalColumn;
    //Player array storing both instances of the players
    private Player[] player;
    private BoardPiece[] boardPiece;
    private Side turn;
    private int gameNumber;
    private int totalGames;
    
    public void setTotalShells(int s){
        totalShells = s;
    }
    
    public void setTotalPebbles(int p){
        totalPebbles = p;
    }
    
    public void setBoardGrid(char[][] bg){
        boardGrid = bg;
    }
    
    private void setBoardGridTotalRow(int r){
        boardGridTotalRow = r;
    }
    
    private void setBoardGridTotalColumn(int c){
        boardGridTotalColumn = c;
    }
    
    public int getTotalShells(){
        return totalShells;
    }
    
    public int getTotalPebbles(){
        return totalPebbles;
    }
    
    public char[][] getBoardGrid(){
        return boardGrid;
    }
    
    public int getBoardGridTotalRow(){
        return boardGridTotalRow;
    }
    
    public int getBoardGridTotalColumn(){
        return boardGridTotalColumn;
    }
    
    public void resetBoardState(){
        setBoardGridTotalRow(TOTALROW);
        setBoardGridTotalColumn(TOTALCOLUMN);
        boardGrid = new char[boardGridTotalRow][boardGridTotalColumn];
        initializeBoardPieces();
    }

    public void initializeBoardPieces(){

        boardPiece = new BoardPiece[TOTALPIECES];
        
        int bpCounter = 0;
        for(int i = 0; i < boardGridTotalRow; i++){
            boardPiece[bpCounter].setId(bpCounter);
            boardPiece[bpCounter].setIcon("s");
            boardPiece[bpCounter].setBoardPieceLocationX(i);
            boardPiece[bpCounter].setBoardPieceLocationY(0);
            bpCounter++;
        }
        for(int i = 0; i < boardGridTotalRow; i++){
            boardPiece[bpCounter].setId(bpCounter);
            boardPiece[bpCounter].setIcon("s");
            boardPiece[bpCounter].setBoardPieceLocationX(i);
            boardPiece[bpCounter].setBoardPieceLocationY(1);
            bpCounter++;
        }
        for(int i = 0; i < boardGridTotalRow; i++){
            boardPiece[bpCounter].setId(bpCounter);
            boardPiece[bpCounter].setIcon("p");
            boardPiece[bpCounter].setBoardPieceLocationX(i);
            boardPiece[bpCounter].setBoardPieceLocationY(4);
            bpCounter++;
        }
        for(int i = 0; i < boardGridTotalRow; i++){
            boardPiece[bpCounter].setId(bpCounter);
            boardPiece[bpCounter].setIcon("p");
            boardPiece[bpCounter].setBoardPieceLocationX(i);
            boardPiece[bpCounter].setBoardPieceLocationY(5);
            bpCounter++;
        }
    }
    
    
    public void displayBoard(){
        View.Show_Board(boardGrid, boardPiece);
    }
    
    public void passToNextPlayer(){
        displayBoard();
    }
    
    public void validateMove(){
        int chosenPiece;
        int xLoc;
        int yLoc;
        int xTarget;
        int yTarget;
        
        xLoc = boardPiece[chosen_piece].getBoardPieceLocationX();
        yLoc = boardPiece[chosen_piece].getBoardPieceLocationY();
    }
}
