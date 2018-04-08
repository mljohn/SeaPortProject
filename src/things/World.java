/**
 * File: World
 * Author: Michelle John
 * Date: 25 March 2018
 * Purpose: Project Setup
 */
package things;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import main.PortTime;
import things.ships.CargoShip;
import things.ships.PassengerShip;
import things.ships.Ship;

/**
 * Class that extends {@link Thing} and represents a {@link List} of {@link SeaPort}s.
 */
public class World extends Thing {
  
  private Map<Integer, SeaPort> ports;
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
  public World(String name, int index, int parent, Map<Integer, SeaPort> ports, PortTime time) {
    super(name, index, parent);
    this.ports = ports;
    this.time = time;
  }

  /**
   * @return the {@link List} of {@link SeaPort}s
   */
  public Map<Integer, SeaPort> getPorts() {
    return ports;
  }

  /**
   * @param ports the {@link List} of {@link SeaPort}s
   */
  public void setPorts(Map<Integer, SeaPort> ports) {
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

  public void readFile(File file){
    Path path = Paths.get(file.getAbsolutePath());
    List<String[]> fileContents = new ArrayList<>();
    try {
      fileContents = Files.readAllLines(path)
          .stream()
          .map(String::trim)
          .filter(line -> !line.startsWith("//"))
          .filter(line -> !line.isEmpty())
          .map(line -> line.split("\\s+"))
          .collect(Collectors.toList());
    } catch (IOException ex) {
      //do nothing
    }

    fileContents.forEach(line -> {
      for (String s : line) {
        System.err.print(s + " ");
      }
      System.err.println();
    });

    createObjects(fileContents);
  }

  private void createObjects(List<String[]> objectsToCreate) {
    List<SeaPort> ports = new ArrayList<>();
    List<Dock> docks = new ArrayList<>();
    List<Ship> cShip = new ArrayList<>();
    List<Ship> pShip = new ArrayList<>();
    List<Person> persons = new ArrayList<>();
    List<Job> jobs = new ArrayList<>();
    objectsToCreate.forEach(obj -> {
      switch (obj[0]) {
        case "port" :
          ports.add(new SeaPort(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3])));
          break;
        case "dock" :
          docks.add(new Dock(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3])));
          break;
        case "pship" :
          pShip.add(new PassengerShip(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), Double.valueOf(obj[4]),
              Double.valueOf(obj[5]), Double.valueOf(obj[6]), Double.valueOf(obj[7]), Integer.valueOf(obj[8]),
              Integer.valueOf(obj[9]), Integer.valueOf(obj[10])));
          break;
        case "cship" :
          cShip.add(new CargoShip(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), Double.valueOf(obj[4]),
              Double.valueOf(obj[5]), Double.valueOf(obj[6]), Double.valueOf(obj[7]), Double.valueOf(obj[8]),
              Double.valueOf(obj[9]), Double.valueOf(obj[10])));
          break;
        case "person" :
          persons.add(new Person(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), obj[4]));
          break;
        case "job" :
          List<String> requirements = new ArrayList<>();
          for (int i = 5; i < obj.length; i++) {
            requirements.add(obj[i]);
          }
          jobs.add(new Job(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), Double.valueOf(obj[4]),
              requirements));
      }
    });
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append("\nPorts:");
    ports.forEach((number, port) -> sb.append("\n\t" + port));
    sb.append("\n\nPort Time: ").append(time);
    return sb.toString();
  }
}
