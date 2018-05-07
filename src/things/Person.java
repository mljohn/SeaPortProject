/**
 * File: Person
 * Author: Michelle John
 * Date: 06 May 2018
 * Purpose: Project Setup
 */
package things;

import java.util.Comparator;

/**
 * Class that extends {@link Thing} and represents a person.
 */
public class Person extends Thing {
  
  private String skill;
  
  /**
   * Default constructor.
   */
  public Person() {}
  
  /**
   * Constructor.
   * 
   * @param name the name
   * @param index the index
   * @param parent the parent
   * @param skill the skill of the person
   */
  public Person(String name, int index, int parent, String skill) {
    super(name, index, parent);
    this.skill = skill;
  }

  /**
   * @return the person's skill
   */
  public String getSkill() {
    return skill;
  }

  /**
   * @param skill the person's skill
   */
  public void setSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nSkill: "
        + skill
        + "\n";
  }

  @Override
  public int compareTo(Thing o) {
    Person person = (Person) o;
    return Comparator.comparing(Person::getName)
        .compare(this, person);
  }
}
