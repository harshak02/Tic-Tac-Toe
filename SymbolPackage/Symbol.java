package SymbolPackage;
import PlayerPackage.Player;

public class Symbol implements SymbolGetters {
    protected char ch;
    protected Player player;
    protected int id;

    public Symbol(char ch, int id) {
        this.ch = ch;
        this.id = id;
    }

    @Override
    public char getSymbol() {
        return ch;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public int getId() {
        return id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}