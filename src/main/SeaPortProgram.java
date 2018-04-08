/**
 * File: SeaPortProgram
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import guielements.SeaPortFrame;
import guielements.SeaPortTextArea;
import things.World;

/**
 * This application models a sea port. The user can choose a data file to import, which is then scanned
 * and a seaport model is created. The model is displayed and the user can search for specific elements
 * of the modeled seaport.
 */
public class SeaPortProgram {
  
  World world = new World();

  /**
   * Entry point into the application. Builds the GUI.
   * 
   * @param args the arguments set at start
   */
  public static void main(String[] args) {
    
    SeaPortProgram program = new SeaPortProgram();
    program.startGui();
  }
  
  /**
   * Builds the GUI.
   */
  private void startGui() {
    
    SeaPortFrame frame = new SeaPortFrame("Sea Port Program", 500, 300);
    JPanel buttonPanel = new JPanel();
    JPanel textPanel = new JPanel(new GridBagLayout());
    SeaPortTextArea textArea = new SeaPortTextArea(false);
    JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JButton fileDialogButton = new JButton("ChooseFile");
    JFileChooser chooser = new JFileChooser(".");

    buttonPanel.add(fileDialogButton);
    textPanel.add(scrollPane, createConstraints(0, 0));

    fileDialogButton.addActionListener(event -> {
      int returnValue = chooser.showOpenDialog(frame);
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        world.readFile(chooser.getSelectedFile());
      }

    });
    
    frame.add(buttonPanel, BorderLayout.NORTH);
    frame.add(textPanel, BorderLayout.CENTER);
    
    frame.display();
    
  }
  
  /**
   * Creates the {@link GridBagConstraints}.
   * 
   * @param x the x-axis location
   * @param y the y-axis location
   * @return the {@link GridBagConstraints}
   */
  private GridBagConstraints createConstraints(int x, int y) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(3, 3, 3, 3);
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.CENTER;
    return gbc;
  }
}
