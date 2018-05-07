/**
 * File: PortTime
 * Author: Michelle John
 * Date: 06 May 2018
 * Purpose: Project Setup
 */
package main;

/**
 * Class the represents the Port Time.
 */
public class PortTime {
  
  private int time;

  /**
   * Constructor.
   * 
   * @param time the port time
   */
  public PortTime(int time) {
    this.time = time;
  }

  /**
   * @return the port time
   */
  public int getTime() {
    return time;
  }

  /**
   * @param time the port time
   */
  public void setTime(int time) {
    this.time = time;
  }
  
  @Override
  public String toString() {
    return "Port time: " + time;
  }
}
