/**
 * File: CargoShip
 * Author: Michelle John
 * Date: 22 April 2018
 * Purpose: Project Setup
 */
package things.ships;

import java.util.List;

import main.PortTime;
import things.Job;

/**
 * Class that extends {@link Ship} and represents a Cargo Ship.
 */
public class CargoShip extends Ship {
  
  private double cargoValue;
  private double cargoVolume;
  private double cargoWeight;

  /** 
   * Default constructor.
   */
  public CargoShip() {}
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param weight the ship's weight
   * @param length the ship's length
   * @param width the ship's width
   * @param draft the ship's draft
   * @param cargoWeight the cargo's weight
   * @param cargoVolume the cargo's volume
   * @param cargoValue the cargo's value
   */
  public CargoShip(String name, int index, int parent, double weight, double length, double width, double draft, 
      double cargoWeight, double cargoVolume, double cargoValue) {
    super(name, index, parent, weight, length, width, draft);
    this.cargoValue = cargoValue;
    this.cargoVolume = cargoVolume;
    this. cargoWeight = cargoWeight;
  }
  
  
  /** 
   * Constructor. 
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param arrivalTime the arrival time
   * @param dockTime the time in dock
   * @param draft the draft of the ship
   * @param length the length of the ship
   * @param weight the weight of the ship
   * @param width the width of the ship
   * @param cargoValue the value of the cargo
   * @param cargoVolume the volume of the cargo
   * @param cargoWeight the weight of the cargo
   */
  public CargoShip(String name, int index, int parent, PortTime arrivalTime, PortTime dockTime, double draft, 
      double length, double weight, double width, List<Job> jobs, double cargoValue, double cargoVolume, 
      double cargoWeight) {
    super(name, index, parent, arrivalTime, dockTime, draft, length, weight, width, jobs);
    this.cargoValue = cargoValue;
    this.cargoVolume = cargoVolume;
    this.cargoWeight = cargoWeight;
  }

  
  /**
   * @return the value of the cargo
   */
  public double getCargoValue() {
    return cargoValue;
  }

  /**
   * @param cargoValue the value of the cargo
   */
  public void setCargoValue(double cargoValue) {
    this.cargoValue = cargoValue;
  }

  /**
   * @return the volume of the cargo
   */
  public double getCargoVolume() {
    return cargoVolume;
  }

  /**
   * @param cargoVolume the voluem of the cargo
   */
  public void setCargoVolume(double cargoVolume) {
    this.cargoVolume = cargoVolume;
  }

  /**
   * @return the weight of the cargo
   */
  public double getCargoWeight() {
    return cargoWeight;
  }

  /**
   * @param cargoWeight the weight of the cargo
   */
  public void setCargoWeight(double cargoWeight) {
    this.cargoWeight = cargoWeight;
  }
  
  @Override
  public String toString() {
    return super.toString()
        + "\nCargo Value: "
        + cargoValue
        + "\nCargo Volume: "
        + cargoVolume
        + "\nCargo Weight: "
        + cargoWeight
        +"\n";
  }
}
