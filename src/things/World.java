/**
 * File: World
 * Author: Michelle John
 * Date: 22 April 2018
 * Purpose: Project Setup
 */
package things;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import main.PortTime;
import things.ships.CargoShip;
import things.ships.PassengerShip;
import things.ships.Ship;

/**
 * Class that extends {@link Thing} and represents a {@link List} of {@link SeaPort}s.
 */
public class World extends Thing {
  
  private List<SeaPort> ports = new ArrayList<>();
  private Map<Integer, SeaPort> portsMap = new HashMap<>();
  private Map<Integer, Dock> docksMap = new HashMap<>();
  private Map<Integer, Ship> passengerShipsMap = new HashMap<>();
  private Map<Integer, Ship> cargoShipsMap = new HashMap<>();
  private Map<Integer, Person> personsMap = new HashMap<>();
  private Map<Integer, Job> jobsMap = new HashMap<>();
  private PortTime time;

  private final ExecutorService executorService = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

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

  public List<String[]> readFile(File file){
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

    createObjects(fileContents);
    return fileContents;
  }

  private void createObjects(List<String[]> objectsToCreate) {
    List<Dock> docks = new ArrayList<>();
    List<Ship> passengerShip = new ArrayList<>();
    List<Ship> cargoShip = new ArrayList<>();
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
          passengerShip.add(new PassengerShip(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), Double.valueOf(obj[4]),
              Double.valueOf(obj[5]), Double.valueOf(obj[6]), Double.valueOf(obj[7]), Integer.valueOf(obj[8]),
              Integer.valueOf(obj[9]), Integer.valueOf(obj[10])));
          break;
        case "cship" :
          cargoShip.add(new CargoShip(obj[1], Integer.valueOf(obj[2]), Integer.valueOf(obj[3]), Double.valueOf(obj[4]),
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

    passengerShip.forEach(ship -> {
      List<Job> jobList = new ArrayList<>();
      jobs.forEach(job -> {
        if (ship.getIndex() == job.getParent()) {
          jobList.add(job);
        }
      });
      ship.setJobs(jobList);
    });

    cargoShip.forEach(ship -> {
      List<Job> jobList = new ArrayList<>();
      jobs.forEach(job -> {
        if (ship.getIndex() == job.getParent()) {
          jobList.add(job);
        }
      });
      ship.setJobs(jobList);
    });

    docks.forEach(dock -> {
      cargoShip.forEach(ship -> {
        if (dock.getIndex() == ship.getParent()) {
          dock.setShip(ship);
        }
      });
      passengerShip.forEach(ship -> {
        if (dock.getIndex() == ship.getParent()) {
          dock.setShip(ship);
        }
      });
    });

    ports.forEach(port -> {
      List<Dock> dockList = new ArrayList<>();
      List<Ship> shipList = new ArrayList<>();
      List<Person> personList = new ArrayList<>();
      docks.forEach(dock -> {
        if (port.getIndex() == dock.getParent()) {
          dockList.add(dock);
        }
      });
      cargoShip.forEach(ship -> {
        if (port.getIndex() == ship.getParent()) {
          shipList.add(ship);
        }
      });
      passengerShip.forEach(ship -> {
        if (port.getIndex() == ship.getParent()) {
          shipList.add(ship);
        }
      });
      persons.forEach(person -> {
        if (port.getIndex() == person.getParent()) {
          personList.add(person);
        }
      });
      Collections.sort(dockList);
      Collections.sort(shipList);
      Collections.sort(personList);
      port.setDocks(dockList);
      port.setShips(shipList);
      port.setPersons(personList);
    });

    Collections.sort(ports);
    Collections.sort(docks);
    Collections.sort(passengerShip);
    Collections.sort(cargoShip);
    Collections.sort(persons);
    Collections.sort(jobs);

    ports.forEach(port -> portsMap.put(port.getIndex(), port));
    docks.forEach(dock -> docksMap.put(dock.getIndex(), dock));
    passengerShip.forEach(ship -> passengerShipsMap.put(ship.getIndex(), ship));
    cargoShip.forEach(ship -> cargoShipsMap.put(ship.getIndex(), ship));
    persons.forEach(person -> personsMap.put(person.getIndex(), person));
    jobs.forEach(job -> jobsMap.put(job.getIndex(), job));
  }

  public void startJobs() {
    ports.forEach(port -> port.getShips().forEach(ship -> ship.getJobs().forEach(executorService::execute)));
  }

  public void pauseJobs() {

  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append("\nPorts:");
    ports.forEach(port -> sb.append("\n\t").append(port));
    sb.append("\n\nPort Time: ").append(time);
    return sb.toString();
  }
}
