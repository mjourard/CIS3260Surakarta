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
    public void Show_Board(char[][] bg, Board_piece[] bp) {
        String answer; //The user's resonse in a String object.
        
        int boardHeight; //The number of rows in the char array that represents the actual board to be displayed.
        
        int boardRowIndex; //The index that of the row in the displayBoard that is currently being printed.
        
        int boardWidth; //The number of columns in the char array that represents the actual board to be displayed.
        
        boolean captureMode; //A boolean to indicate whether the user has decided to move this turn or capture an opposing piece. True if the user decided to capture, false if they decided to move.
        
        int column; //The column currently being printed out.
        
        int dataRow; //The index of the row that is being checked in the passed in char array.
                
        char[][] displayBoard; //A #D char array that will represent every single cell that will printed out to the user.
        
        int index; //An index for looping through the Board_piece array.
        
        int row; //The row currently being printed out.
        
        Scanner userInput;
                
        
        for (index = 0; index < bp.length; index++) {
            bg[bp[index].getBoard_piece_location_y()][bp[index].getBoard_piece_location_x()] = bp[index].getIcon();
        }
        
        String temp;
        
        boardHeight = 29;
        boardWidth = 30;
        boardRowIndex = 0;        
               
        dataRow = 0;
        
        displayBoard = new char[boardHeight][boardWidth];
                       
        temp = " ____________    ____________ ";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 1
        
        temp = "|            |  |            |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 2
        
        temp = "|   ______   |  |   ______   |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 3
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 4
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 5
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 6
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 7
        
        temp = "|  |   " + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 8
        dataRow++; //set to 1
        
        temp = "|  |   |  |  |  |  |  |   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 9
        
        temp = "|  |   |  |  |  |  |  |   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 10
        
        temp = "|   ---" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "---   |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 11        
        dataRow++; //set to 2
        
        temp = "|      |  |  |  |  |  |      |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 12
        
        temp = "|      |  |  |  |  |  |      |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 13
        
        temp = " ------"  + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] +  "------ ";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 14
        dataRow++; //set to 3
        
        temp = "       |  |  |  |  |  |       ";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 15
        
        temp = "       |  |  |  |  |  |       ";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 16
        
        temp = " ------" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "------ ";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 17
        dataRow++; //set to 4
        
        temp = "|      |  |  |  |  |  |      |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 18
        
        temp = "|      |  |  |  |  |  |      |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 19
        
        temp = "|   ---" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "---   |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 20
        dataRow++; // set to 5
        
        temp = "|  |   |  |  |  |  |  |   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 21
        
        temp = "|  |   |  |  |  |  |  |   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 22
        
        temp = "|  |   " + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "--" + bg[dataRow][0] + "   |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 23        
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 24
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 25
        
        temp = "|  |      |  |  |  |      |  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 26
        
        temp = "|  |______|  |  |  |______|  |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 27
        
        temp = "|            |  |            |";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 28
        
        temp = "|____________|  |____________|";
        putStringInBoard(displayBoard, temp, boardWidth, boardRowIndex);
        boardRowIndex++; //set to 29                        
        
        column = 0;
        
        row = 0;
        
        dataRow = 1;
        
        System.out.println("       A  B  C  D  E  F       ");
        
        for (row = 0; row < boardHeight; row++) {
            for (column = 0; column < boardWidth; column++) {
                System.out.print(displayBoard[row][column]);
            }
            if (row > 7 && row < 21) {
                if ( (row - 2) % 3 == 0) {
                    System.out.println(" " + Integer.toString(dataRow + 1));
                    dataRow++;
                }
            }
            
        }
        
        
        userInput = new Scanner(System.in);
        
        answer = "";
        //Ask the user if they want to move or capture
        while (answer.length() != 1) {
            System.out.println("Would you like to (M)ove or (C)apture?");
            answer = userInput.nextLine().toUpperCase();
            
            if (answer.length() != 1) {
                System.out.println("Invalid input, only one character is required to enter. Press 'M' to move or 'C' to capture.");
            } else if (!answer.equals("M") && !answer.equals("C")) {
                System.out.println("Invalid input, press 'M' to Move one of your pieces, or 'C' to Capture one of the opponent's pieces with your piece.");
                answer = "";
            }
        }
        
        //Ask user what piece they'd like to move/capture with
        if (answer.equals("M")) {
            captureMode = false;            
        } else {
            captureMode = true;            
        }
               
        while (answer.length() != 2) {
            if (captureMode) {
                System.out.println("Enter the current coordinates of the piece you'd like to move. E.g. A1, B6 or E3");
            } else {
                System.out.println("Enter the current coordinates of the piece you'd like to capture with. E.g. A1, B6 or E3");
            }
            
            answer = userInput.next().toUpperCase();
            
            if (answer.length() != 2) {
                System.out.println("Invalid input. Ensure you're only entering two characters. The first will be a letter, either A,B,C,D,E or F. The second will be a number from 1 to 6.");
            } else if ( (answer.charAt(0) < 'A' || answer.charAt(0) > 'F') || (answer.charAt(1) < '1' || answer.charAt(1) > '6') ){                
                System.out.println("Illegal character(s). Ensure the first is either A,B,C,D,E or F. Ensure the second is either 1,2,3,4,5 or 6.");                                    
                answer = "";
            }
        }
        
        
    }
    
    /**
     * A method used to insert a String object into the passed in displayBoard using the boardRowIndex.
     * @param displayBoard - The board to be printed out and displayed.
     * @param line - The string of characters that will be inserted into the displayBoard.
     * @param boardWidth - The number of elements in the 2nd dimension of displayBoard. Used to ensure the length matches the length of 'line'.
     * @param boardRowIndex - The index to be used for the 1st dimension of displayBoard.
     */
    private void putStringInBoard(char[][] displayBoard, String line, int boardWidth, int boardRowIndex) {
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
    public void Display_Score(Player[] p, int number, int tg) {
        
    }
    
    public static void main(String[] args) {
        char[][] boardGame;
        Board_piece[] boardPiece;
        View self;
        
        boardGame = new char[][]  { {'P','P','P','P','P','P'}, 
                                    {'P','P','P','P','P','P'},                                      
                                    {'+','+','+','+','+','+'}, 
                                    {'+','+','+','+','+','+'}, 
                                    {'S','S','S','S','S','S'}, 
                                    {'S','S','S','S','S','S'} };
        
        boardPiece = new Board_piece[5];
        
        self = new View();
        
        System.out.println("Calling 'Show_Board'");
        self.Show_Board(boardGame, boardPiece);
    }
}
