/**
 * File: PassengerShip
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package things.ships;

import java.util.List;

import main.PortTime;
import things.Job;

/**
 * Class that extends {@link Ship} and represents a Passenger Ship.
 */
public class PassengerShip extends Ship {
  
  private int numberOfOccupiedRooms;
  private int numberOfPassengers;
  private int numberOfRooms;

  /**
   * Default constructor.
   */
  public PassengerShip() {}
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param weight the weight
   * @param length the length
   * @param width the width
   * @param draft the draft
   * @param numberOfPassengers the number of passengers
   * @param numberOfRooms the total number of rooms
   * @param numberOfOccupiedRooms the number of occupied rooms
   */
  public PassengerShip(String name, int index, int parent, double weight, double length, double width, double draft, 
      int numberOfPassengers, int numberOfRooms, int numberOfOccupiedRooms) {
    super(name, index, parent, weight, length, width, draft);
    this.numberOfOccupiedRooms = numberOfOccupiedRooms;
    this.numberOfPassengers = numberOfPassengers;
    this.numberOfRooms = numberOfRooms;
  }
  
  
  /**
   * Constructor. 
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param arrivalTime the arrival time of the ship
   * @param dockTime the ship's time in dock
   * @param draft the draft of the ship
   * @param length the length of the ship
   * @param weight the weight of the ship
   * @param width the width of the ship
   * @param numberOfOccupiedRooms the number of rooms occupied
   * @param numberOfPassengers the number of ship's passengers
   * @param numberOfRooms the total number of rooms in the ship
   */
  public PassengerShip(int index, String name, int parent, PortTime arrivalTime, PortTime dockTime, double draft, 
      double length, double weight, double width, List<Job> jobs, int numberOfOccupiedRooms, int numberOfPassengers, 
      int numberOfRooms) {
    super(name, index, parent, arrivalTime, dockTime, draft, length, weight, width, jobs);
    this.numberOfOccupiedRooms = numberOfOccupiedRooms;
    this.numberOfPassengers = numberOfPassengers;
    this.numberOfRooms = numberOfRooms;
  }

  /**
   * @return the number of rooms currently occupied
   */
  public int getNumberOfOccupiedRooms() {
    return numberOfOccupiedRooms;
  }

  /**
   * @param numberOfOccupiedRooms the number of rooms currently occupied
   */
  public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
    this.numberOfOccupiedRooms = numberOfOccupiedRooms;
  }

  /**
   * @return the number of ship's passengers
   */
  public int getNumberOfPassengers() {
    return numberOfPassengers;
  }

  /**
   * @param numberOfPassengers the number of ship's passengers
   */
  public void setNumberOfPassengers(int numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }

  /**
   * @return the total number of rooms in the ship
   */
  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  /**
   * @param numberOfRooms the total number of rooms in the ship
   */
  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }
  
  @Override
  public String toString() {
    return new StringBuilder(super.toString())
        .append("\nNumber of Occupied Rooms: ")
        .append(numberOfOccupiedRooms)
        .append("\nNumber of Passengers: ")
        .append(numberOfPassengers)
        .append("\nNumber of Rooms: ")
        .append(numberOfRooms)
        .append("\n")
        .toString();
  }
}
