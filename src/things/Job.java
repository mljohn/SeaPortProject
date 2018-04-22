/**
 * File: Job
 * Author: Michelle John
 * Date: 23 April 2018
 * Purpose: Project Setup
 */
package things;

import java.util.List;

/**
 * Class that extends {#link {@link Thing} and represents a Job.
 */
public class Job extends Thing {
  
  private double duration;
  private List<String> requirements;

  /**
   * Default constructor.
   */
  public Job() {}
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param duration the duration of the job
   * @param requirements the requirements of the job
   */
  public Job(String name, int index, int parent, double duration, List<String> requirements) {
    super(name, index, parent);
    this.duration = duration;
    this.requirements = requirements;
  }

  /**
   * @return the duration of the job
   */
  public double getDuration() {
    return duration;
  }

  /**
   * @param duration the duration of the job
   */
  public void setDuration(double duration) {
    this.duration = duration;
  }

  /**
   * @return {@link List} of requirements
   */
  public List<String> getRequirements() {
    return requirements;
  }

/**
 * @param requirements {@link List} of requirements
 */
  public void setRequirements(List<String> requirements) {
    this.requirements = requirements;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString())
        .append("\nDuration: ")
        .append(duration)
        .append("\nRequirements: ");
    
    requirements.forEach(requirement -> sb.append("\n\t").append(requirement));
    
    return sb.toString();
  }
}
