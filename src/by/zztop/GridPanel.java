package by.zztop;

import by.zztop.controller.CellsController;
import by.zztop.model.CellsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GridPanel extends JPanel {
    public static final Color gridColor = new Color(30, 30, 30);
    public static final Color backgroundColor = new Color(26, 26, 26);
    public static final Color cellColor = new Color(255, 147,0);
    public static final int gridWidth = 10;
    public static final int gridHeight = 10;

    private CellsController cellsController = new CellsController(new CellsModel(60, 45));

    public GridPanel() {
        setBackground(backgroundColor);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                cellsController.getCellsModel().setStatusOfCell(e.getX() / 10, e.getY() / 10);
                repaint();
            }
        });
        setBackground(backgroundColor);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCells(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(gridColor);

        for(int w = 0; w < getWidth(); w += gridWidth)
            g.drawLine(w, 0, w, getHeight());

        for(int h = 0; h < getHeight(); h+= gridHeight)
            g.drawLine(0, h, getWidth(), h);
    }

    private void drawCells(Graphics g) {
        g.setColor(cellColor);
        for(int i = 0; i < cellsController.getCellsModel().rows(); ++i)
            for(int j = 0; j < cellsController.getCellsModel().columns(); ++j)
                if(cellsController.getCellsModel().itsAlive(j, i)) g.fillRect(j * gridWidth, i * gridHeight, gridWidth, gridHeight);
    }

    //---------
    public void nextGeneration(){
        cellsController.nextGeneration();
        repaint();
    }
}
