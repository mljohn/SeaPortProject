/**
 * File: SeaPort
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package things;

import java.util.ArrayList;
import java.util.List;

import things.ships.Ship;

/**
 * Class that extends {@link Thing} and represents a Sea Port.
 */
public class SeaPort extends Thing {
  
  private List<Dock> docks = new ArrayList<>();
  private List<Ship> inWaitQueue = new ArrayList<>();
  private List<Ship> ships = new ArrayList<>();
  private List<Person> persons = new ArrayList<>();

  /**
   * Default constructor.
   */
  public SeaPort() {}
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   */
  public SeaPort(String name, int index, int parent) {
    super(name, index, parent);
  }
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param docks the {@link List} of {@link Dock}s associated with this SeaPort
   * @param inWaitQueue the {@link List} of {@link Ship}s waiting in queue
   * @param ships the {@link List} of {@link Ship}s in this SeaPort
   * @param persons the {@link List} of {@link Person}s working at this SeaPort
   */
  public SeaPort(String name, int index, int parent, List<Dock> docks, List<Ship> inWaitQueue, List<Ship> ships, 
      List<Person> persons) {
    super(name, index, parent);
    this.docks = docks;
    this.inWaitQueue = inWaitQueue;
    this.ships = ships;
    this.persons = persons;
  }
  
  /**
   * @return the {@link List} of {@link Dock}s associated with this SeaPort
   */
  public List<Dock> getDocks() {
    return docks;
  }

  /**
   * @param docks the {@link List} of {@link Dock}s associated with this SeaPort
   */
  public void setDocks(List<Dock> docks) {
    this.docks = docks;
  }

  /**
   * @return the {@link List} of {@link Ship}s waiting in queue
   */
  public List<Ship> getInWaitQueue() {
    return inWaitQueue;
  }

  /**
   * @param inWaitQueue the {@link List} of {@link Ship}s waiting in queue
   */
  public void setInWaitQueue(List<Ship> inWaitQueue) {
    this.inWaitQueue = inWaitQueue;
  }

  /**
   * @return the {@link List} of {@link Ship}s in this SeaPort
   */
  public List<Ship> getShips() {
    return ships;
  }

  /**
   * @param ships the {@link List} of {@link Ship}s in this SeaPort
   */
  public void setShips(List<Ship> ships) {
    this.ships = ships;
  }

  /**
   * @return the {@link List} of {@link Person}s working at this SeaPort
   */
  public List<Person> getPersons() {
    return persons;
  }

  /**
   * @param persons the {@link List} of {@link Person}s working at this SeaPort
   */
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append("\nDocks: ");
    docks.forEach(dock -> sb.append("\n\t" + dock));
    sb.append("\n\nShips in Queue: ");
    inWaitQueue.forEach(ship -> sb.append("\n\t" + ship));
    sb.append("\n\nShips in Port: ");
    ships.forEach(ship -> sb.append("\n\t" + ship));
    sb.append("\n\nPeople: ");
    persons.forEach(person -> sb.append("\n\t" + person));
    return sb.toString();
  }
}
