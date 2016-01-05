package by.zztop.model;

import by.zztop.CellsModelInterface;


public class CellsModel implements CellsModelInterface {
    private boolean[][] matrixOfCells;
    /* TODO: ОДНОВРЕМЕННО проверять, а только потом переходить к следующему поколению (просканировал создал, просканировал создал)
    * можно создавать еще одну модель внутри контроллера и менять ей основную*/
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
        switch (positionOfCell(column, row)) {
            case MIDDLE:
                for (int i = row - 1; i <= row + 1; ++i) // middle
                    for (int j = column - 1; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case TOP_LEFT:
                for (int i = row; i <= row + 1; ++i) // left_top
                    for (int j = column; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case TOP:
                for (int i = row; i <= row + 1; ++i) // top
                    for (int j = column - 1; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case TOP_RIGHT:
                for (int i = row; i <= row + 1; ++i) // right_top
                    for (int j = column - 1; j <= column; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case RIGHT:
                for (int i = row - 1; i <= row + 1; ++i) // right
                    for (int j = column - 1; j <= column; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case BOTTOM_RIGHT:
                for (int i = row - 1; i <= row; ++i) // right_bottom
                    for (int j = column - 1; j <= column; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case BOTTOM:
                for (int i = row - 1; i <= row; ++i) // bottom
                    for (int j = column - 1; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case BOTTOM_LEFT:
                for (int i = row - 1; i <= row; ++i) // left_bottom
                    for (int j = column; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;

            case LEFT:
                for (int i = row - 1; i <= row + 1; ++i) // left
                    for (int j = column; j <= column + 1; ++j)
                        count += matrixOfCells[i][j] ? 1 : 0;
                break;
        }
        return matrixOfCells[row][column] ? count - 1 : count;
    }

    private CellsPosition positionOfCell(int column, int row) {
        if(column == 0 && row == 0)
            return CellsPosition.TOP_LEFT;
        else if(column == matrixOfCells[0].length - 1 && row == 0)
            return CellsPosition.TOP_RIGHT;
        else if(column == matrixOfCells[0].length - 1 && row == matrixOfCells.length - 1)
            return CellsPosition.BOTTOM_RIGHT;
        else if(column == 0 && row == matrixOfCells.length - 1)
            return CellsPosition.BOTTOM_LEFT;
        else if(column == 0 && (row != 0 || row != matrixOfCells.length - 1))
            return CellsPosition.LEFT;
        else if(column == matrixOfCells[0].length - 1 && (row!=0 || row != matrixOfCells.length - 1))
            return CellsPosition.RIGHT;
        else if(row == 0 && (column !=0 || column != matrixOfCells[0].length - 1 ))
            return CellsPosition.TOP;
        else if(row == matrixOfCells.length - 1 && (column !=0 || column != matrixOfCells[0].length - 1 ))
            return CellsPosition.BOTTOM;
        else
            return CellsPosition.MIDDLE;
    }
}
