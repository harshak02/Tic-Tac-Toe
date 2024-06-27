import java.util.ArrayList;
import java.util.List;
import PlayerPackage.*;
import SymbolPackage.*;
import BoardPackage.*;
import GamePackage.*;


public class Main {
    public static void main(String[] args) {
        // Initialize players
        Player player1 = new Player("Player 1", 1);
        Player player2 = new Player("Player 2", 2);

        // Initialize symbols
        Symbol xSymbol = new X(1);
        Symbol oSymbol = new O(2);
        xSymbol.setPlayer(player1);
        oSymbol.setPlayer(player2);

        List<Symbol> symbols = new ArrayList<>();
        symbols.add(xSymbol);
        symbols.add(oSymbol);

        // Initialize board
        Board3x3 board = new Board3x3();

        // Initialize and start game
        Game game = new Game(2, board, symbols);
        game.gameFunction();
    }
}
