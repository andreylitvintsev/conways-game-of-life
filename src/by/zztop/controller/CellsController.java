package by.zztop.controller;

import by.zztop.model.CellsModel;

public class CellsController{

    private CellsModel cellsModel;

    public CellsController(CellsModel cellsModel){
        this.cellsModel = cellsModel;
    }

    public CellsModel getCellsModel(){
        return cellsModel;
    }

    public void nextGeneration(){
        CellsModel nextGenerationCellsModel = new CellsModel(cellsModel.columns(), cellsModel.rows());
        for(int row = 0; row < cellsModel.rows(); ++row)
            for(int column = 0; column < cellsModel.columns(); ++column){
                if(!cellsModel.itsAlive(column, row) && cellsModel.itsHasThreeNeighbors(column, row)) // рождение
                    nextGenerationCellsModel.setStatusOfCell(column, row);
                if(cellsModel.itsAlive(column, row) && (cellsModel.itsHasThreeNeighbors(column,row) || cellsModel.itsHasTwoNeighbors(column,row))) // выживание
                    nextGenerationCellsModel.setStatusOfCell(column, row);
            }
        cellsModel = nextGenerationCellsModel;
    }


}
