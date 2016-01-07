package by.zztop.view;

import by.zztop.controller.CellsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GridPanel extends JPanel {
    private Color gridColor = new Color(30, 30, 30);
    private Color backgroundColor = new Color(26, 26, 26);
    private Color cellColor = new Color(255, 147,0);
    private int sizeOfCell = 10;

    private CellsController cellsController;


    public GridPanel(CellsController cellsController) {
        this.cellsController = cellsController;
        setBackground(backgroundColor);
        setAlignmentX(JComponent.WIDTH);

        setPreferredSize(new Dimension(cellsController.getCellsModel().columns() * sizeOfCell, cellsController.getCellsModel().rows() * sizeOfCell));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                cellsController.getCellsModel().setStatusOfCell(e.getX() / 10, e.getY() / 10);
                repaint();
            }
        });
    }

    public void setCellsController(CellsController cellsController) {
        this.cellsController = cellsController;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setCellColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    public void setSizeOfCell(int sizeOfCell) {
        this.sizeOfCell = sizeOfCell;
    }


    public CellsController getCellsController() {
        return cellsController;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getCellColor() {
        return cellColor;
    }

    public int getSizeOfCell() {
        return sizeOfCell;
    }

    public int getFullWidth() {
        return sizeOfCell * cellsController.getCellsModel().columns();
    }

    public int getFullHeight() {
        return sizeOfCell * cellsController.getCellsModel().rows();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCells(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(gridColor);

        for(int w = 0; w <= cellsController.getCellsModel().columns() * sizeOfCell; w += sizeOfCell)
            g.drawLine(w, 0, w, cellsController.getCellsModel().columns() * sizeOfCell);

        for(int h = 0; h <= cellsController.getCellsModel().rows() * sizeOfCell; h += sizeOfCell)
            g.drawLine(0, h, cellsController.getCellsModel().rows() * sizeOfCell, h);
    }

    private void drawCells(Graphics g) {
        g.setColor(cellColor);
        for(int i = 0; i < cellsController.getCellsModel().rows(); ++i)
            for(int j = 0; j < cellsController.getCellsModel().columns(); ++j)
                if(cellsController.getCellsModel().itsAlive(j, i)) g.fillRect(j * sizeOfCell, i * sizeOfCell, sizeOfCell, sizeOfCell);
    }
}
