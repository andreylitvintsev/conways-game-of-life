package by.zztop;


import by.zztop.controller.CellsController;
import by.zztop.model.CellsModel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        setUIStyle();
        new MainFrame("Conway's Game of Life").setVisible(true);
    }

    static private void setUIStyle(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
