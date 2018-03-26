/**
 * File: World
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package things;

import java.util.List;

import main.PortTime;

/**
 * Class that extends {@link Thing} and represents a {@link List} of {@link SeaPort}s.
 */
public class World extends Thing {
  
  private List<SeaPort> ports;
  private PortTime time;

  /**
   * Default constructor.
   */
  public World() {}
  
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   */
  public World(String name, int index, int parent) {
    super(name, index, parent);
  }
  
  /**
   * Constructor.
   * 
   * @param index the index
   * @param name the name
   * @param parent the parent
   * @param ports the {@link List} of {@link SeaPort}s
   * @param time the {@link PortTime}
   */
  public World(String name, int index, int parent, List<SeaPort> ports, PortTime time) {
    super(name, index, parent);
    this.ports = ports;
    this.time = time;
  }

  /**
   * @return the {@link List} of {@link SeaPort}s
   */
  public List<SeaPort> getPorts() {
    return ports;
  }

  /**
   * @param ports the {@link List} of {@link SeaPort}s
   */
  public void setPorts(List<SeaPort> ports) {
    this.ports = ports;
  }

  /**
   * @return the {@link PortTime}
   */
  public PortTime getPortTime() {
    return time;
  }
  
  /**
   * @param time the {@link PortTime}
   */
  public void setPortTime(PortTime time) {
    this.time = time;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append("\nPorts:");
    ports.forEach(port -> sb.append("\n\t" + port));
    sb.append("\n\nPort Time: ").append(time);
    return sb.toString();
  }
}
