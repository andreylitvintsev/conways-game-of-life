package by.zztop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{ // TODO: реализовать окно о программе (лучше сделать переносимый класс с изменяемыми параметрами)
    private JPanel mainPanel;
    private GridPanel gridPanel;
    private JButton startButton;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setContentPane(mainPanel);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        //----------------
        startButton.addActionListener(e -> {
            gridPanel.nextGeneration();
        });
    }

}
