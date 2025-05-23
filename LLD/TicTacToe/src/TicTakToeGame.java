import Model.Board;
import Model.Player;
import Model.PlayingPieceO;
import Model.PlayingPieceX;

import java.util.*;

public class TicTakToeGame {
    Deque<Player>players;
    Board gameBoard;
    public void InitializeGame(){
     players=new LinkedList<>();
        PlayingPieceX playingPieceX=new PlayingPieceX();
        Player player1=new Player("player1",playingPieceX);

        PlayingPieceO playingPieceO=new PlayingPieceO();
        Player player2=new Player("player2",playingPieceO);
        players.add(player1);
        players.add(player2);
        gameBoard=new Board(5);

    }
    public void startGame()
    {
        int size = gameBoard.size;
        int[][] board = new int[size][size];
        int[] rowSum = new int[size];
        int[] colSum = new int[size];
        int diagSum = 0;
        int antiDiagSum = 0;
        int totalMoves = 0;
        int maxMoves = size * size;

        Map<String, Integer> playerToValue = new HashMap<>();
        playerToValue.put("player1", 1);   // +1 for player1
        playerToValue.put("player2", -1);  // -1 for player2

        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            gameBoard.printBoard();
            Player playerTurn = players.poll();
            int value = playerToValue.get(playerTurn.name);

            int row = -1, col = -1;
            while (true) {
                System.out.print("Player: " + playerTurn.name + " Enter row,column: ");
                String s = inputScanner.nextLine();
                String[] values = s.split(",");
                row = Integer.parseInt(values[0].trim());
                col = Integer.parseInt(values[1].trim());

                if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != 0) {
                    System.out.println("Invalid move! Try again.");
                } else {
                    break;
                }
            }
            gameBoard.addPiece(playerTurn.getPlayingPiece(),row,col);
            board[row][col] = value;
            totalMoves++;

            rowSum[row] += value;
            colSum[col] += value;
            if (row == col) diagSum += value;
            if (row + col == size - 1) antiDiagSum += value;

            // Check for winner
            if (Math.abs(rowSum[row]) == size ||
                    Math.abs(colSum[col]) == size ||
                    Math.abs(diagSum) == size ||
                    Math.abs(antiDiagSum) == size) {
                System.out.println("Player " + playerTurn.name + " wins!");
                break;
            }

            if (totalMoves == maxMoves) {
                System.out.println("Game is a draw.");
                break;
            }

            players.add(playerTurn);
        }

        inputScanner.close();
    }
}
