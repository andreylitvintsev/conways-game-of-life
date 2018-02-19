package com.github.andreylitvintsev.gameoflife;

import javax.swing.*;

import com.github.andreylitvintsev.gameoflife.view.MainFrame;


public class Main {

    public static void main(String[] args) {
        setUIStyle();
        MainFrame mainFrame = new MainFrame("Conway's Game of Life");
        mainFrame.setIconImage(new ImageIcon(Main.class.getResource("resources/icon.png")).getImage());
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
