package by.zztop.view;

import by.zztop.controller.CellsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;


public class ScrollableGridPanel extends JScrollPane {
    private GridPanel gridPanel;

    public ScrollableGridPanel(CellsController cellsController) {
        gridPanel = new GridPanel(cellsController);
        setViewportView(gridPanel);

        addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
            @Override
            public void ancestorResized(HierarchyEvent e) {
                int x = gridPanel.getFullWidth() / 2 - getWidth() / 2;
                int y = gridPanel.getFullHeight() / 2 - getHeight() / 2;
                getViewport().setViewPosition(new Point(x, y));
            }
        });
    }


}
