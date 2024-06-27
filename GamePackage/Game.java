package GamePackage;
import java.util.List;
import BoardPackage.Board;
import SymbolPackage.Symbol;

public class Game {
    protected int numberOfPlayers;
    protected List<Symbol> symbols;
    protected Board board;
    protected Symbol isWinner;
    protected int currentSymbol;

    public Game(int numberOfPlayers, Board board, List<Symbol> symbols) {
        this.numberOfPlayers = numberOfPlayers;
        this.board = board;
        this.symbols = symbols;
        this.currentSymbol = 0; // Initialize the current symbol index
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    void resetBoard() {
        for (int i = 0; i < board.getColumns(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                board.getList().get(i).get(j).removeSymbol();
            }
        }
    }

    boolean isGameOver() {
        int cols = board.getColumns();

        // Row check
        for (int i = 0; i < cols; i++) {
            boolean rowOver = true;
            Symbol firstSymbol = board.getList().get(i).get(0).getSymbol();
            if (firstSymbol == null) {
                continue;
            }
            for (int j = 1; j < cols; j++) {
                if (board.getList().get(i).get(j).getSymbol() == null || board.getList().get(i).get(j).getSymbol().getSymbol() != firstSymbol.getSymbol()) {
                    rowOver = false;
                    break;
                }
            }
            if (rowOver) {
                isWinner = firstSymbol;
                return true;
            }
        }

        // Column check
        for (int i = 0; i < cols; i++) {
            boolean columnOver = true;
            Symbol firstSymbol = board.getList().get(0).get(i).getSymbol();
            if (firstSymbol == null) {
                continue;
            }
            for (int j = 1; j < cols; j++) {
                if (board.getList().get(j).get(i).getSymbol() == null || board.getList().get(j).get(i).getSymbol().getSymbol() != firstSymbol.getSymbol()) {
                    columnOver = false;
                    break;
                }
            }
            if (columnOver) {
                isWinner = firstSymbol;
                return true;
            }
        }

        // Diagonal check
        boolean diagonalOver = true;
        Symbol firstSymbol = board.getList().get(0).get(0).getSymbol();
        if (firstSymbol != null) {
            for (int i = 1; i < cols; i++) {
                if (board.getList().get(i).get(i).getSymbol() == null || board.getList().get(i).get(i).getSymbol().getSymbol() != firstSymbol.getSymbol()) {
                    diagonalOver = false;
                    break;
                }
            }
            if (diagonalOver) {
                isWinner = firstSymbol;
                return true;
            }
        }

        // Anti-diagonal check
        diagonalOver = true;
        firstSymbol = board.getList().get(0).get(cols - 1).getSymbol();
        if (firstSymbol != null) {
            for (int i = 1; i < cols; i++) {
                if (board.getList().get(i).get(cols - 1 - i).getSymbol() == null || board.getList().get(i).get(cols - 1 - i).getSymbol().getSymbol() != firstSymbol.getSymbol()) {
                    diagonalOver = false;
                    break;
                }
            }
            if (diagonalOver) {
                isWinner = firstSymbol;
                return true;
            }
        }

        // Check for draw
        return isDraw();
    }

    boolean isDraw() {
        for (int i = 0; i < board.getColumns(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (!board.getList().get(i).get(j).isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }
}
