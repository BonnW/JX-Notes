
package employeeApp;

public class Company;
{
  private static int maxId = 0;
  public int id;l
  public String name;
  public int debt;

  public final static double match401k = 0.05;

  public Company (String name, int debt)
  {
    maxId++;
    id = maxId;
    this.name = name;
    this.debt = debt;
  }
}