package by.zztop.controller;

import by.zztop.CellsModelInterface;
import by.zztop.model.CellsModel;

public class CellsController {

    private CellsModelInterface cellsModel;

    public CellsController(CellsModelInterface cellsModel){
        this.cellsModel = cellsModel;
    }

    public CellsModelInterface getCellsModel(){
        return cellsModel;
    }

    public void nextGeneration(){
        CellsModelInterface nextGenerationCellsModel = new CellsModel(cellsModel.columns(), cellsModel.rows());
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
