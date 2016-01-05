package by.zztop;

public interface CellsModelInterface {

    boolean itsAlive(int column, int row);

    boolean itsHasThreeNeighbors(int column, int row);

    boolean itsHasTwoNeighbors(int column, int row);

    void setStatusOfCell(int column, int row);

    int rows();

    int columns();

}
