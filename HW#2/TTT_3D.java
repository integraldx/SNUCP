import java.util.*;
import java.io.*;

class TTT_3D {
    static TTTGame game = new TTTGame();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println();
            printGameBoard();

            System.out.print("Enter Input for Player " + game.getCurrentPlayerState().toString() + ": ");
            String input = scanner.nextLine();
            String[] inputSplit = input.split(" ");
            if(inputSplit.length != 3){
                invalidInputPrint();
                continue;
            }
            int x, y, z;
            try{
                y = 3 - Integer.parseInt(inputSplit[2]);
                x = Integer.parseInt(inputSplit[1]) - 1;
            }
            catch(NumberFormatException e){
                invalidInputPrint();
                continue;
            }
            if(inputSplit[0].equals("T")){
                z = 0;
            }
            else if (inputSplit[0].equals("M")){
                z = 1;

            }
            else if (inputSplit[0].equals("B")){
                z = 2;

            }
            else {
                invalidInputPrint();
                continue;
            }

            if(x < 0 || x > 2 || y < 0 || y > 2 || !game.tryAssignPlayerToken(z, y, x)){
                invalidInputPrint();
                continue;
            }

            switch(game.evaluateGameState(z, y, x)){
                case X:
                    printGameBoard();
                    System.out.println("Player 1 win!");
                    return;
                case O:
                    printGameBoard();
                    System.out.println("Player 2 win!");
                    return;
                case S:
                    printGameBoard();
                    System.out.println("Stalemate!");
                    return;
                default :
                    continue;
            }
        }
    }

    public static void invalidInputPrint(){
        System.out.println("Invalid Input! Try again.");
    }
    
    public static void printGameBoard(){
        System.out.println("Top:");
        printGameBoardPlane(0);

        System.out.println("Mid:");
        printGameBoardPlane(1);

        System.out.println("Bot:");
        printGameBoardPlane(2);
    }

    public static void printGameBoardPlane(int z){
        System.out.println("+---+---+---+");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                var state = game.getBoardStateAt(z, i, j);
                switch(state){
                    case E:
                        System.out.print(" ");
                        break;
                    case U:
                        System.out.print("-");
                        break;
                    default:
                        System.out.print(state.toString());
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }
}

class TTTGame {
    public enum BoardState {E, U, O, X};
    public enum GameState {N, O, X, S};
    public enum PlayerState {O, X};
    private BoardState[][][] gameBoard = new BoardState[3][3][3];
    private GameState gameState = GameState.N;
    private PlayerState playerState = PlayerState.X;
    private int counter = 0;
    public TTTGame() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    gameBoard[i][j][k] = BoardState.E;
                }
            }
        }
        gameBoard[1][1][1] = BoardState.U;

        
    }

    public boolean tryAssignPlayerToken(int z, int y, int x){
        if(gameBoard[z][y][x] != BoardState.E){
            return false;
        }
        switch (playerState){
            case X:
                gameBoard[z][y][x] = BoardState.X;
                playerState = PlayerState.O;
                counter++;
                break;
            case O:
                gameBoard[z][y][x] = BoardState.O;
                playerState = PlayerState.X;
                counter++;
                break;
        }
        return true;
    }

    public BoardState getBoardStateAt(int z, int y, int x){
        return gameBoard[z][y][x];
    }

    public GameState evaluateGameState(int z, int y, int x){
        BoardState toCheck;
        if(playerState == PlayerState.X){
            toCheck = BoardState.O;
        }
        else {
            toCheck = BoardState.X;
        }

        boolean isWin = false;

        // place for evaluation code
        isWin = sideCheck(z, y, x) || cornerCheck(z, y, x);

        if (counter == 26 && !isWin){
            gameState = GameState.S;
        }
        else if (isWin){
            if(toCheck == BoardState.X){
                gameState = GameState.X;
            }
            else{
                gameState = GameState.O;
            }
        }
        return gameState;
    }

    private boolean sideCheck(int z, int y, int x) {
        var toCheck = gameBoard[z][y][x];

        int counter = 0;
        for(int i = 0; i < 3; i++){
            if(gameBoard[z][y][i] == toCheck){
                counter++;
            }
            
        }
        if (counter == 3){
            return true;
        }
        
        counter = 0;
        for(int i = 0; i < 3; i++){
            if(gameBoard[z][i][x] == toCheck){
                counter++;
            }
        }
        if(counter == 3){
            return true;
        }

        counter = 0;
        for(int i = 0; i < 3; i++){
            if(gameBoard[i][y][x] == toCheck){
                 counter++;
            }
        }
        if(counter == 3){
            return true;
        }

        return false;
    }

    private boolean cornerCheck(int z, int y, int x) {
        var toCheck = gameBoard[z][y][x];
        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[i][i][x] == toCheck){
                    counter++;
                }
            }
            if(counter == 3){
                return true;
            }
        }
        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[i][2 - i][x] == toCheck){
                    counter++;
                }
            }
            if(counter == 3){
                return true;
            }
        }

        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[i][y][i] == toCheck){
                    counter++;
                }
            }

            if(counter == 3){
                return true;
            }
        }
        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[i][y][2 - i] == toCheck){
                    counter++;
                }
            }

            if(counter == 3){
                return true;
            }
        }
        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[z][i][i] == toCheck){
                    counter++;
                }
            }
            
            if(counter == 3){
                return true;
            }
        }
        {
            int counter = 0;
            for(int i = 0; i < 3; i++){
                if(gameBoard[z][i][2 - i] == toCheck){
                    counter++;
                }
            }

            if(counter == 3){
                return true;
            }
        }
            
        return false;
    }

    public PlayerState getCurrentPlayerState(){
        return playerState;
    }
}