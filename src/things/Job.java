/**
 * File: Job
 * Author: Michelle John
 * Date: 22 April 2018
 * Purpose: Project Setup
 */
package things;

import guielements.SeaPortFrame;
import guielements.SeaPortTextArea;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

/**
 * Class that extends {#link {@link Thing} and represents a Job.
 */
public class Job extends Thing implements Runnable {
  
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

  @Override
  public int compareTo(Thing o) {
    Job job = (Job) o;
    return Comparator.comparing(Job::getName)
        .compare(this, job);
  }

  @Override
  public void run() {
    SeaPortFrame jobFrame = new SeaPortFrame("Running Job", 250, 200);
    JPanel jobPanel = new JPanel();
    SeaPortTextArea jobTextArea = new SeaPortTextArea(false);
    jobTextArea.setText("Performing Jobs");
    jobPanel.add(jobTextArea, BorderLayout.CENTER);
    jobFrame.add(jobPanel, BorderLayout.CENTER);
    jobFrame.display();
  }
}
