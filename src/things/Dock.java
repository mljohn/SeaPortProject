/**
 * File: Dock
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package things;

import things.ships.Ship;

/**
 * Class the extends {@link Thing} and represents a Dock.
 */
public class Dock extends Thing {
  
  private Ship ship;

  /** 
   * Default constructor.
   */
  public Dock() {}
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param ship the ship that is docked
   */
  public Dock(String name, int index, int parent, Ship ship) {
    super(name, index, parent);
    this.ship = ship;
  }

  /**
   * Constructor.
   *
   * @param name the name
   * @param index the index
   * @param parent the parent
   */
  public Dock(String name, int index, int parent) {
    super(name, index, parent);
  }


  /**
   * @return the docked ship
   */
  public Ship getShip() {
    return ship;
  }
  
  /**
   * @param ship the docked ship
   */
  public void setShip(Ship ship) {
    this.ship = ship;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    if (ship == null) {
      sb.append("\nNo Ship");
    } else {
      sb.append(ship.toString());
    }
    return sb.toString();
  }
}
