/**
 * File: Ship
 * Author: Michelle John
 * Date: 06 May 2018
 * Purpose: Project Setup
 */
package things.ships;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.PortTime;
import things.Job;
import things.Thing;

/**
 * Class that extends {@link Thing} and represents a Ship.
 * <p>
 * Known implementations:
 * <ul>
 * <li>{@link CargoShip}</li>
 * <li>{@link PassengerShip}</li>
 * </ul>
 */
public class Ship extends Thing {
  
  private PortTime arrivalTime;
  private PortTime dockTime;
  private double draft;
  private double length;
  private double weight;
  private double width;
  private List<Job> jobs;

  /**
   * Default constructor.
   */
  public Ship() {}
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param weight the ship's weight
   * @param length the the ship's length
   * @param width the ship's width
   * @param draft the ship's draft
   */
  public Ship(String name, int index, int parent, double weight, double length, double width, double draft) {
    super(name, index, parent);
    this.arrivalTime = new PortTime(0);
    this.dockTime = new PortTime(0);
    this.weight = weight;
    this.length = length;
    this.width = width;
    this.draft = draft;
  }
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param arrivalTime the ship's arrival time
   * @param dockTime the ship's time in dock
   * @param draft the ship's draft
   * @param length the ship's length
   * @param weight the ship's weight
   * @param width the ship's width
   * @param jobs the {@link List} of {@link Job}s associated with this Ship
   */
  public Ship(String name, int index, int parent, PortTime arrivalTime, PortTime dockTime, double draft, 
      double length, double weight, double width, List<Job> jobs) {
    super(name, index, parent);
    this.arrivalTime = arrivalTime;
    this.dockTime = dockTime;
    this.draft = draft;
    this.length = length;
    this.weight = weight;
    this.width = width;
    this.jobs = jobs;
    Collections.sort(this.jobs);
  }
  
  /**
   * @return the ship's arrival time
   */
  public PortTime getArrivalTime() {
    return arrivalTime;
  }

  /**
   * @param arrivalTime the ship's arrival time
   */
  public void setArrivalTime(PortTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  /**
   * @return the ship's time in dock
   */
  public PortTime getDockTime() {
    return dockTime;
  }

  /**
   * @param dockTime the ship's time in dock
   */
  public void setDockTime(PortTime dockTime) {
    this.dockTime = dockTime;
  }

  /**
   * @return the ship's draft
   */
  double getDraft() {
    return draft;
  }

  /**
   * @param draft the ship's draft
   */
  public void setDraft(double draft) {
    this.draft = draft;
  }

  /**
   * @return the ship's length
   */
  double getLength() {
    return length;
  }

  /**
   * @param length the ship's length
   */
  public void setLength(double length) {
    this.length = length;
  }

  /**
   * @return the ship's weight
   */
  double getWeight() {
    return weight;
  }

  /**
   * @param weight the ship's weight
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * @return the ship's width
   */
  public double getWidth() {
    return width;
  }

  /**
   * @param width the ship's width
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * @return the {@link List} of {@link Job}s associated with this Ship
   */
  public List<Job> getJobs() {
    return jobs;
  }

  /**
   * @param jobs the {@link List} of {@link Job}s associated with this Ship
   */
  public void setJobs(List<Job> jobs) {
    this.jobs = jobs;
    Collections.sort(this.jobs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString())
        .append("\nArrival Time: ")
        .append(arrivalTime.toString())
        .append("\nDock Time: ")
        .append(dockTime.toString())
        .append("\nDraft: ")
        .append(draft)
        .append("\nLength: ")
        .append(length)
        .append("\nWeight: ")
        .append(weight)
        .append("\nWidth: ")
        .append(width)
        .append("\nJobs: ")
        .append("\n");

    if (jobs == null) {
      sb.append("No Jobs.");
    } else {
      jobs.forEach(job -> sb.append("\t").append(job).append("\n"));
    }
    return sb.toString();
  }

  @Override
  public int compareTo(Thing o) {
    Ship ship = (Ship) o;
    return Comparator.comparing(Ship::getWeight)
        .thenComparing(Ship::getLength)
        .thenComparing(Ship::getDraft)
        .compare(this, ship);
  }
}
