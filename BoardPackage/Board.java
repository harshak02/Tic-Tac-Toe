package BoardPackage;
import java.util.ArrayList;
import java.util.List;
import BoxPackage.*;

public class Board {
    protected List<List<Box>> list;
    protected int columns;

    public Board(int columns) {
        this.columns = columns;
        this.list = new ArrayList<>(this.columns);

        for (int i = 0; i < this.columns; i++) {
            this.list.add(new ArrayList<>());
            for (int j = 0; j < this.columns; j++) {
                this.list.get(i).add(new Box(i, j));
            }
        }
    }

    public List<List<Box>> getList() {
        return list;
    }

    public int getColumns() {
        return columns;
    }
}

