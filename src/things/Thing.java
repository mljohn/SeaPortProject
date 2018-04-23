/**
 * File: Thing
 * Author: Michelle John
 * Date: 22 April 2018
 * Purpose: Project Setup
 */
package things;

import things.ships.Ship;

/**
 * Class that implements {@link Comparable} and represents a Think that is part of the Sea Port.
 * <p>
 * Known implementations:
 * <ul>
 * <li>{@link Dock}</li>
 * <li>{@link Job}</li>
 * <li>{@link Person}</li>
 * <li>{@link SeaPort}</li>
 * <li>{@link Ship}</li>
 * <li>{@link World}</li>
 * </ul>
 */
public class Thing implements Comparable<Thing> {
  
  private String name;
  private int index;
  private int parent;
  
  /**
   * Default constructor.
   */
  public Thing() {}
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   */
  public Thing(String name, int index, int parent) {
    this.name = name;
    this.index = index;
    this.parent = parent;
  }
  
  /**
   * @return the index
   */
  public int getIndex() {
    return index;
  }
  
  /**
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  
  /**
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * @return the parent
   */
  public int getParent() {
    return parent;
  }
  
  /**
   * @param parent the parent
   */
  public void setParent(int parent) {
    this.parent = parent;
  }
  
  @Override
  public String toString() {
    return "\nIndex: "
        + index
        + "\nName: "
        + name
        + "\nParent: "
        + parent;
  }

  @Override
  public int compareTo(Thing o) {
    // TODO Auto-generated method stub
    return 0;
  }
}
