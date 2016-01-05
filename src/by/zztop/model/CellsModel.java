package by.zztop.model;

import by.zztop.CellsModelInterface;


public class CellsModel implements CellsModelInterface {

    private boolean[][] matrixOfCells;
    public CellsModel(int width, int hight) {
        matrixOfCells = new boolean[hight][width]; // 45 60
    }

    @Override
    public boolean itsAlive(int column, int row) {
        return matrixOfCells[row][column];
    }

    @Override
    public boolean itsHasThreeNeighbors(int column, int row) {
        return countOfNeighbors(column, row) == 3;
    }

    @Override
    public boolean itsHasTwoNeighbors(int column, int row) {
        return countOfNeighbors(column, row) == 2;
    }

    @Override
    public void setStatusOfCell(int column, int row) {
        matrixOfCells[row][column] = !matrixOfCells[row][column];
    }

    @Override
    public int rows() {
        return matrixOfCells.length;
    }

    @Override
    public int columns() {
        return matrixOfCells[0].length;
    }

    private int countOfNeighbors(int column, int row){
        int count = 0;

        int x1 = column == 0 ? column : column - 1;
        int y1 = row == 0 ? row : row - 1;
        int x2 = column == matrixOfCells[0].length - 1 ? column : column + 1;
        int y2 = row == matrixOfCells.length - 1 ? row : row + 1;

        for(int i = x1; i <= x2; ++i){
            for(int j = y1; j <= y2; ++j){
                count += matrixOfCells[j][i] ? 1 : 0;
            }
        }

        return matrixOfCells[row][column] ? count - 1 : count;
    }

}
