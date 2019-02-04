
package employeeApp

public class Main
{
  private static void workWithData()
  {
    HealthPlan h1 = new HealthPlan("No Dying");
    HealthPlan h2 = new HealthPlan("Sometimes Dying");
    
    Company c1 = new Company("Company A", 100);
    Company c2 = new Company("Company B", 100);

    Employee emp1 = new Employee("John", "Doe", 45000, c1.id, h1.getId());
    Employee emp2 = new Employee("Jane", "Doe", 50000, c1.id, h2.getId());
    Employee emp3 = new Employee("Doug", "Judy", 20000, c2.id, h2.getId());

    System.out.println("*** Query Data***");
    System.out.println(c1);
  }
  public static void main(String[] args) 
  {
    workWithData();
  }
}