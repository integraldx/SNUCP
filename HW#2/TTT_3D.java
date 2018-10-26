import java.util.*;

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

            int x, y, z;
            if(inputSplit[0].equals("T")){
                y = Integer.parseInt(inputSplit[1]);
                x = Integer.parseInt(inputSplit[2]);
                z = 0;

            }
            else if (inputSplit[0].equals("M")){
                y = Integer.parseInt(inputSplit[1]);
                x = Integer.parseInt(inputSplit[2]);
                z = 1;

            }
            else if (inputSplit[0].equals("B")){
                y = Integer.parseInt(inputSplit[1]);
                x = Integer.parseInt(inputSplit[2]);
                z = 2;

            }
            else {
                System.out.println("Invailid Input!");
                continue;
            }

            if(x < 0 || x > 2 || y < 0 || y > 2 || !game.tryAssignPlayerToken(z, y, x)){
                System.out.println("Invalid Input!");
                continue;
            }

            switch(game.evaluateGameState(z, y, z)){
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
        //
        //
        //
        
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

    public PlayerState getCurrentPlayerState(){
        return playerState;
    }
}