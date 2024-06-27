package GamePackage;

import java.util.Scanner;
import SymbolPackage.Symbol;

public class GameController {
    private final Game game;
    private final Scanner scanner = new Scanner(System.in);

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        while (true) {
            printBoard();
            String currentSymbolPlayerName = game.symbols.get(game.currentSymbol).getPlayer().getName();
            System.out.println(currentSymbolPlayerName + "'s turn");
            System.out.println("Enter the row and column you want to place your symbol (row column): ");
            int inputRow = scanner.nextInt();
            int inputColumn = scanner.nextInt();

            if (inputRow < 0 || inputRow >= game.board.getColumns() || inputColumn < 0 || inputColumn >= game.board.getColumns()) {
                System.out.println("Invalid position. Try again.");
                continue;
            }

            if (game.board.getList().get(inputRow).get(inputColumn).isOccupied()) {
                System.out.println("Position already occupied. Try again.");
                continue;
            }

            game.board.getList().get(inputRow).get(inputColumn).setSymbol(game.symbols.get(game.currentSymbol));

            if (game.isGameOver()) {
                printBoard();
                if (game.isWinner != null) {
                    System.out.println("The winner is " + game.isWinner.getPlayer().getName());
                } else {
                    System.out.println("The game ended in a draw.");
                }
                game.resetBoard();
                return;
            }

            game.currentSymbol = (game.currentSymbol + 1) % game.numberOfPlayers;
        }
    }

    private void printBoard() {
        int columns = game.board.getColumns();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = game.board.getList().get(i).get(j).getSymbol();
                System.out.print(symbol != null ? symbol.getSymbol() : " ");
                if (j < columns - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < columns - 1) {
                System.out.println("---------");
            }
        }
    }
}