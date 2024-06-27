package BoxPackage;
import SymbolPackage.Symbol;

public class Box {
    protected int x;
    protected int y;
    protected boolean occupied;
    protected Symbol symbol;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupied = false;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.occupied = true;
    }

    public void removeSymbol() {
        this.symbol = null;
        this.occupied = false;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return occupied;
    }

}