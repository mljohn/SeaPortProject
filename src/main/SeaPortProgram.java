/**
 * File: SeaPortProgram
 * Author: Michelle John
 * Date: 23 April 2018
 * Purpose: Project Setup
 */
package main;

import guielements.SeaPortFrame;
import guielements.SeaPortTextArea;
import things.World;
import things.ships.Ship;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This application models a sea port. The user can choose a data file to import, which is then scanned
 * and a seaport model is created. The model is displayed and the user can search for specific elements
 * of the modeled seaport.
 */
public class SeaPortProgram {
  
  private World world = new World();

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
    JPanel sortButtonPanel = new JPanel();
    SeaPortTextArea textArea = new SeaPortTextArea(false);
    JScrollPane textScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JButton fileDialogButton = new JButton("ChooseFile");
    JButton sortShipsButton = new JButton("Sort Ships");
    JButton showTreeButton = new JButton("Show Tree");
    JFileChooser chooser = new JFileChooser(".");


    buttonPanel.add(fileDialogButton);
    textPanel.add(textScrollPane, createConstraints(0, 0));

    fileDialogButton.addActionListener(event -> {
      int returnValue = chooser.showOpenDialog(frame);
      if (returnValue == JFileChooser.APPROVE_OPTION) {
        List<String[]> fileContents = world.readFile(chooser.getSelectedFile());
        StringBuilder contents = new StringBuilder();
        fileContents.forEach(line -> {
          for (String s : line) {
            contents.append(s);
            contents.append(" ");
          }
          contents.append("\n");
        });
        textArea.setText(contents.toString());
        frame.add(sortButtonPanel, BorderLayout.SOUTH);
        frame.display();
      }
    });
    sortShipsButton.addActionListener(event -> {
      List<Ship> shipList = new ArrayList<>();
      world.getPorts().forEach(port -> shipList.addAll(port.getShips()));
      shipList.sort(Ship::compareTo);
      StringBuilder ships = new StringBuilder();
      shipList.forEach(ships::append);
      textArea.setText(ships.toString());
      textPanel.removeAll();
      textPanel.add(textScrollPane, createConstraints(0, 0));
      frame.display();
      frame.repaint();
        }
    );

    showTreeButton.addActionListener(event -> {
      DefaultMutableTreeNode top = new DefaultMutableTreeNode("World");
      createNodes(top);
      JTree tree = new JTree(top);

      JScrollPane treeScrollPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      textPanel.removeAll();
      textPanel.add(treeScrollPane, createConstraints(0, 0));
      frame.display();
      frame.repaint();
    });

    sortButtonPanel.add(sortShipsButton);
    sortButtonPanel.add(showTreeButton);
    
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

  private void createNodes(DefaultMutableTreeNode top) {
    world.getPorts().forEach(port -> {
      DefaultMutableTreeNode portNode = new DefaultMutableTreeNode(port.getName());
      port.getDocks().forEach(dock -> {
        DefaultMutableTreeNode dockNode = new DefaultMutableTreeNode(dock.getName());
        if (dock.getShip() != null) {
          DefaultMutableTreeNode shipNode = new DefaultMutableTreeNode(dock.getShip().getName());
          dock.getShip().getJobs().forEach(job -> shipNode.add(new DefaultMutableTreeNode(job.getName())));
          dockNode.add(shipNode);
        }
        portNode.add(dockNode);
      });
      port.getPersons().forEach(person -> portNode.add(new DefaultMutableTreeNode(person.getName())));
      top.add(portNode);
    });
  }
}
