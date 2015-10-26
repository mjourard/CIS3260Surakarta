/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package surakarta;

import java.util.Scanner;

/**
 * The class responsible for displaying the game board to the users.
 * @author Matt Jourard
 */
public class View {
    /**
     * Displays the current state of the board and all it's pieces. Then prompts the user to "move" or "capture". Selecting
     * these options will trigger the respective "validateMove" or "validateCapture" methods.
     * Once all this is done the user is shown an "end of game" prompt where if chosen triggers.
     * @param bg
     * @param bp 
     */
    public static void showBoard(char[][] bg) {
        String answer; //The user's resonse in a String object.
        
        int boardHeight; //The number of rows in the char array that represents the actual board to be displayed.
        
        int boardRowIndex; //The index that of the row in the displayBoard that is currently being printed.
        
        int boardWidth; //The number of columns in the char array that represents the actual board to be displayed.
        
        boolean captureMode; //A boolean to indicate whether the user has decided to move this turn or capture an opposing piece. True if the user decided to capture, false if they decided to move.
        
        int column; //The column currently being printed out.
        
        int dataRow; //The index of the row that is being checked in the passed in char array.
                
        char[][] displayBoard; //A #D char array that will represent every single cell that will printed out to the user.
        
        String[] stringDisplayBoard;
        
        int index; //An index for looping through the Board_piece array.
        
        int row; //The row currently being printed out.
        
        Scanner userInput;                               
        
        String temp;
        
        boardHeight = 29;
        boardWidth = 30;
        boardRowIndex = 0;        
               
        dataRow = 0;
        
        displayBoard = new char[boardHeight][boardWidth];
        
        stringDisplayBoard = new String[29];                
                       
        
        stringDisplayBoard[boardRowIndex] = " ____________    ____________ ";
        boardRowIndex++; //set to 1
                
        stringDisplayBoard[boardRowIndex] = "|            |  |            |";
        boardRowIndex++; //set to 2
                
        stringDisplayBoard[boardRowIndex] = "|   ______   |  |   ______   |";
        boardRowIndex++; //set to 3
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";
        boardRowIndex++; //set to 4
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 5
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 6
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 7
                
        stringDisplayBoard[boardRowIndex] = "|  |   " + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] + "   |  |";        
        boardRowIndex++; //set to 8
        dataRow++; //set to 1
                
        stringDisplayBoard[boardRowIndex] = "|  |   |  |  |  |  |  |   |  |";        
        boardRowIndex++; //set to 9
                
        stringDisplayBoard[boardRowIndex] = "|  |   |  |  |  |  |  |   |  |";        
        boardRowIndex++; //set to 10
                
        stringDisplayBoard[boardRowIndex] = "|   ---" + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] + "---   |";        
        boardRowIndex++; //set to 11        
        dataRow++; //set to 2
                
        stringDisplayBoard[boardRowIndex] = "|      |  |  |  |  |  |      |";        
        boardRowIndex++; //set to 12
                
        stringDisplayBoard[boardRowIndex] = "|      |  |  |  |  |  |      |";        
        boardRowIndex++; //set to 13
        
        
        stringDisplayBoard[boardRowIndex] = " ------"  + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] +  "------ ";        
        boardRowIndex++; //set to 14
        dataRow++; //set to 3
        
        
        stringDisplayBoard[boardRowIndex] = "       |  |  |  |  |  |       ";        
        boardRowIndex++; //set to 15
                
        stringDisplayBoard[boardRowIndex] = "       |  |  |  |  |  |       ";        
        boardRowIndex++; //set to 16
                
        stringDisplayBoard[boardRowIndex] = " ------" + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] + "------ ";        
        boardRowIndex++; //set to 17
        dataRow++; //set to 4
                
        stringDisplayBoard[boardRowIndex] = "|      |  |  |  |  |  |      |";        
        boardRowIndex++; //set to 18
                
        stringDisplayBoard[boardRowIndex] = "|      |  |  |  |  |  |      |";        
        boardRowIndex++; //set to 19
        
        
        stringDisplayBoard[boardRowIndex] = "|   ---" + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] + "---   |";        
        boardRowIndex++; //set to 20
        dataRow++; // set to 5
        
        
        stringDisplayBoard[boardRowIndex] = "|  |   |  |  |  |  |  |   |  |";        
        boardRowIndex++; //set to 21
                
        stringDisplayBoard[boardRowIndex] = "|  |   |  |  |  |  |  |   |  |";        
        boardRowIndex++; //set to 22
        
        
        stringDisplayBoard[boardRowIndex] = "|  |   " + bg[dataRow][0] + "--" + bg[dataRow][1] + "--" + bg[dataRow][2] + "--" + bg[dataRow][3] + "--" + bg[dataRow][4] + "--" + bg[dataRow][5] + "   |  |";       
        boardRowIndex++; //set to 23        
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 24
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 25
                
        stringDisplayBoard[boardRowIndex] = "|  |      |  |  |  |      |  |";        
        boardRowIndex++; //set to 26
                
        stringDisplayBoard[boardRowIndex] = "|  |______|  |  |  |______|  |";        
        boardRowIndex++; //set to 27
                
        stringDisplayBoard[boardRowIndex] = "|            |  |            |";        
        boardRowIndex++; //set to 28
                
        stringDisplayBoard[boardRowIndex] = "|____________|  |____________|";        
        boardRowIndex++; //set to 29                        
        
        column = 0;
        
        row = 0;
        
        dataRow = 1;
        
        System.out.println("       A  B  C  D  E  F       ");
        
        for (row = 0; row < boardHeight; row++) {
            System.out.print(stringDisplayBoard[row]);
            if (row+1 > 7 && row+1 < 24) {
                if ( (row+1 - 2) % 3 == 0) {
                    System.out.print(" " + Integer.toString(dataRow));
                    dataRow++;
                }
            }             
            System.out.println("");            
        }
        
        /*for (row = 0; row < boardHeight; row++) {
            for (column = 0; column < boardWidth; column++) {
                System.out.print(displayBoard[row][column]);
            }
            if (row+1 > 7 && row+1 < 24) {
                if ( (row+1 - 2) % 3 == 0) {
                    System.out.print(" " + Integer.toString(dataRow));
                    dataRow++;
                }
            }             
            System.out.println("");            
        }*/
        
        
        
    }
    
    /**
     * A method used to insert a String object into the passed in displayBoard using the boardRowIndex.
     * @param displayBoard - The board to be printed out and displayed.
     * @param line - The string of characters that will be inserted into the displayBoard.
     * @param boardWidth - The number of elements in the 2nd dimension of displayBoard. Used to ensure the length matches the length of 'line'.
     * @param boardRowIndex - The index to be used for the 1st dimension of displayBoard.
     */
    private static void putStringInBoard(char[][] displayBoard, String line, int boardWidth, int boardRowIndex) {
        int i;
        
        if (boardWidth < line.length() ) {
            throw new IllegalArgumentException("Argument line exceeds the width of the board. boardWidth = " + Integer.toString(boardWidth) + ", line length = " + Integer.toString(line.length()));
        }
        
        if (boardRowIndex < 0) {
            throw new IllegalArgumentException("Argument boardRowIndex must be greater than 0.");
        }
        
        
        for (i = 0; i < line.length(); i++) {
            displayBoard[boardRowIndex][i] = line.charAt(i);
        }        
    }
    
    /**
     * 
     * @param p
     * @param number
     * @param tg 
     */
    public static void displayScore(Player[] p, int number, int tg) {
        
    }
    
    /**
     * 
     * @return 
     */
    public static int isTurnMoveOrCapture(Side turn) {
        
        Scanner userInput;
        
        String answer;
        
        userInput = new Scanner(System.in);
        
        answer = "";
        //Ask the user if they want to move or capture
        while (answer.length() != 1) {
            if (turn == Side.Pebbles) {
                System.out.println(Side.Pebbles.toString() + " player, would you like to (M)ove or (C)apture?");
            } else {
                System.out.println(Side.Shells.toString() + " player, would you like to (M)ove or (C)apture?");
            }
            
            answer = userInput.nextLine().toUpperCase();
            
            if (answer.length() != 1) {
                System.out.println("Invalid input, only one character is required to enter. Press 'M' to move or 'C' to capture.");
            } else if (!answer.equals("M") && !answer.equals("C")) {
                System.out.println("Invalid input, press 'M' to Move one of your pieces, or 'C' to Capture one of the opponent's pieces with your piece.");
                answer = "";
            }
        }
        
        if (answer.equals("M")) {
            return 0;
        } else {
            return 1;
        }        
    }
    
    public static int[] getTurnCoordinates() {
        String answer;
        
        int[] returnIntArray;
        
        Scanner userInput;
        
        userInput = new Scanner(System.in);
        
        answer = "";
        
        returnIntArray = new int[4];
        
        while (answer.length() != 2) {            
            System.out.println("Enter the current coordinates of the piece you'd like to move. E.g. A1, B6 or E3");
            
            answer = userInput.next().toUpperCase();
            
            if (answer.length() != 2) {
                System.out.println("Invalid input. Ensure you're only entering two characters. The first will be a letter, either A,B,C,D,E or F. The second will be a number from 1 to 6.");
            } else if ( (answer.charAt(0) < 'A' || answer.charAt(0) > 'F') || (answer.charAt(1) < '1' || answer.charAt(1) > '6') ){                
                System.out.println("Illegal character(s). Ensure the first is either A,B,C,D,E or F. Ensure the second is either 1,2,3,4,5 or 6.");                                    
                answer = "";
            }
        }
        
        returnIntArray[1] = answer.charAt(0) - 'A';
        
        returnIntArray[0] = answer.charAt(1) - '1';
        
        answer = "";
        
        while (answer.length() != 2) {            
            System.out.println("Enter the current coordinates you'd like your piece to move to/capture at. E.g. A1, B6 or E3");
            
            answer = userInput.next().toUpperCase();
            
            if (answer.length() != 2) {
                System.out.println("Invalid input. Ensure you're only entering two characters. The first will be a letter, either A,B,C,D,E or F. The second will be a number from 1 to 6.");
            } else if ( (answer.charAt(0) < 'A' || answer.charAt(0) > 'F') || (answer.charAt(1) < '1' || answer.charAt(1) > '6') ){                
                System.out.println("Illegal character(s). Ensure the first is either A,B,C,D,E or F. Ensure the second is either 1,2,3,4,5 or 6.");                                    
                answer = "";
            }
        }
        
        returnIntArray[3] = answer.charAt(0) - 'A';
        
        returnIntArray[2] = answer.charAt(1) - '1';
        
        return returnIntArray;
    }
    
    public static void tellPlayerMoveInvalid(InvalidMoveReason reason) {
        switch (reason) {
            case EndCoordinatesOccupied:
                System.out.println("The move you have attempted to make was invalid because the end coordinates were already occupied with another piece. Please try again.");
                break;
            case NoPieceSelected:
                System.out.println("The move you have attempted to make was invalid because there was no piece at the starting coordinates specified. Please try again.");
                break;
            case EndCoordinatesOutOfRange:
                System.out.println("The move you have attempted to make was invalid because the end coordinates specified were out of range of the starting coordinates. Please try again.");
                break;
            case OpponentsPieceSelected:
                System.out.println("The move you have attempted to make was invalid because the piece you selected to move did not belong to you.");
            default:
                System.err.println("An enumeration not supported was passed in. Exit the program.");                
        }
        
    }
    
    public static void tellPlayerCaptureInvalid(InvalidCaptureReason reason) {
        switch (reason) {
            case OpponentsPieceSelectedWithStartCoordinates:
                System.out.println("The capture you have attempted to make was invalid because the start coordinates contain an opposing piece. Please try again.");
                break;
            case NoPieceSelected:
                System.out.println("The capture you have attempted to make was invalid because there was no piece at the starting coordinates specified. Please try again.");
                break;
            case FriendlyPieceSelectedWithEndCoordinates:
                System.out.println("The capture you have attempted to make was invalid because the end coordinates specified contain a friendly piece. Please try again.");
                break;
            case NoOpponentsPieceSelected:
                System.out.println("The capture you have attempted to make was invalid because there was no opponent's piece at the ending coordinates specified.");
                break;
            case CaptureDoesNotInvolveLoop:
                System.out.println("The capture you have attempted to make was invalid because no loop is taken by the capturing piece. Please try again.");
                break;
            case NoLoopSequenceAvailableToReachEndCoordinates:
                System.out.println("The capture you have attempted to make was invalid because No loop sequence allows the piece at the starting coordinates to hit the piece at the end coordinates. Please try again.");
                break;
            case HitsOtherPieceBeforeReachingEndCoordinates:
                System.out.println("No sequence of loops was found that did not make contact with another piece before hitting the coordinates entered.");
            default:
                System.err.println("An enumeration not supported was passed in. Exit the program.");                                                               
        }        
    }
    
    
    public static void main(String[] args) {
        char[][] boardGame;                
        
        boardGame = new char[][]  { {'P','P','P','P','P','P'}, 
                                    {'P','P','P','P','P','P'},                                      
                                    {'+','+','+','+','+','+'}, 
                                    {'+','+','+','+','+','+'}, 
                                    {'S','S','S','S','S','S'}, 
                                    {'S','S','S','S','S','S'} };
        
        System.out.println("Calling 'Show_Board'");
        showBoard(boardGame);
    }
}
