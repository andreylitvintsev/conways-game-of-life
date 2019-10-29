package com.github.andreylitvintsev.gameoflife.view;

import com.github.andreylitvintsev.gameoflife.controller.CellsController;
import com.github.andreylitvintsev.gameoflife.model.CellsModel;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private ScrollableCellFieldPanel scrollableCellFieldPanel = new ScrollableCellFieldPanel(new CellsController(new CellsModel(1000, 1000)));
    private JToolBar toolBar = new JToolBar("Управление");
    private Timer timerOfLife = new Timer(100, e -> scrollableCellFieldPanel.getCellFieldPanel().toNextGeneration());

    private JButton playPauseButton = new JButton("Play");
    private JButton nextGenerationButton = new JButton("Next generation");
    private JButton clearCellFieldButton = new JButton("Clear");
    private JButton toCenterOfCellField = new JButton("To center");
    private JButton aboutProgramButton = new JButton("About...");

    public MainFrame(String title) throws HeadlessException {
        super(title);

        add(scrollableCellFieldPanel, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        addButtonsInToolBar();
        offFocusableOfButtons();
        setToolTipsOnButtons();
        addListenersOnButtons();

        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
    }

    private void addButtonsInToolBar() {
        toolBar.add(playPauseButton);
        toolBar.add(nextGenerationButton);
        toolBar.add(clearCellFieldButton);
        toolBar.add(toCenterOfCellField);
        toolBar.add(aboutProgramButton);
    }

    private void setToolTipsOnButtons() {
        playPauseButton.setToolTipText("Play/pause life");
        nextGenerationButton.setToolTipText("Go to a next generation");
        clearCellFieldButton.setToolTipText("Clear all field");
        toCenterOfCellField.setToolTipText("Move to center of cell of field");
        aboutProgramButton.setToolTipText("Information about this program");
    }

    private void addListenersOnButtons() {
        playPauseButton.addActionListener(e -> {
            if (!timerOfLife.isRunning()) {
                playPauseButton.setText("Pause");
                timerOfLife.start();
                nextGenerationButton.setEnabled(false);
            } else {
                playPauseButton.setText("Play");
                timerOfLife.stop();
                nextGenerationButton.setEnabled(true);
            }
        });
        nextGenerationButton.addActionListener(e -> scrollableCellFieldPanel.getCellFieldPanel().toNextGeneration());
        clearCellFieldButton.addActionListener(e -> scrollableCellFieldPanel.getCellFieldPanel().clearField());
        toCenterOfCellField.addActionListener(e -> scrollableCellFieldPanel.viewToCenter());
    }

    private void offFocusableOfButtons() {
        for (Component button : toolBar.getComponents())
            button.setFocusable(false);
    }

}
