package by.zztop;

import javax.swing.*;

import by.zztop.view.MainFrame;


public class Main {

    public static void main(String[] args) {
        setUIStyle();
        MainFrame mainFrame = new MainFrame("Conway's Game of Life");
        mainFrame.setVisible(true);
    }

    static private void setUIStyle(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
