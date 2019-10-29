package com.github.andreylitvintsev.gameoflife.view;

import com.github.andreylitvintsev.gameoflife.controller.CellsController;

import javax.swing.*;
import java.awt.*;


public class ScrollableCellFieldPanel extends JScrollPane {
    private CellFieldPanel cellFieldPanel;

    public ScrollableCellFieldPanel(CellsController cellsController) {
        cellFieldPanel = new CellFieldPanel(cellsController);
        setViewportView(cellFieldPanel);
        viewToCenter();
    }

    public void viewToCenter() {
        int x = cellFieldPanel.getFullWidth() / 2 - getWidth() / 2;
        int y = cellFieldPanel.getFullHeight() / 2 - getHeight() / 2;
        getViewport().setViewPosition(new Point(x, y));
    }

    public CellFieldPanel getCellFieldPanel() {
        return cellFieldPanel;
    }

}
