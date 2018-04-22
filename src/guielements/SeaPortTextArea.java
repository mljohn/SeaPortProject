/**
 * File: SeaPortTextArea
 * Author: Michelle John
 * Date: 23 April 2018
 * Purpose: Project Setup
 */
package guielements;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * Custom implementation of {@JTextArea} for this application.
 */
public class SeaPortTextArea extends JTextArea {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param editable if the text area is editable
   */
  public SeaPortTextArea(boolean editable) {
    super();
    setEditable(editable);
    setBackground(WHITE);
    setForeground(BLACK);
    setBorder(new LineBorder(BLACK));
  }
}
