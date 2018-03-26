/**
 * File: SeaPortFrame
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package guielements;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Custom implementation of {@link JFrame} for this application.
 */
public class SeaPortFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  /** 
   * Constructor.
   * 
   * @param title the title of the frame
   * @param width the starting width of the frame
   * @param height the starting height of the frame
   */
  public SeaPortFrame(String title, int width, int height) {
    super(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5, 5));
  }
  
  /**
   * Displays the frame.
   */
  public void display() {
    setVisible(true);
  }
}
