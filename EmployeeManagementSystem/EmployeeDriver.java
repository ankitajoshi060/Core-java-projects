import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

class Employee 
{
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}
	public double getSalary(){
		return salary;
	}

	public void setId(double salary){
		this.salary=salary;
	}

	public String toString()
	{
		return"[Id:"+id+", Name:"+name+", Salary:"+salary+"]";
	}
}

public class EmployeeDriver
{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("=====================================================");
		System.out.println("********Welcome to Employee Management System********");
		System.out.println("=====================================================");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		HashSet<Integer> existingId = new HashSet<>();
		EmployeeDriver driver = new EmployeeDriver();

		while (true)
		{
			try
			{
				
				System.out.println("1.Add new Employee");
				System.out.println("2.Display Employee Information");
				System.out.println("3.Display all Employees");
				System.out.println("4.Exit");
				System.out.println("Enter your choice(1/2/3/4)");
				
				int choice = scan.nextInt();
				switch (choice)
				{
				case 1:
					int id=0;
					while(true){
						System.out.print("Enter employee Id: ");
						 id = scan.nextInt();
						if (existingId.contains(id)==false)
						{
							existingId.add(id);
							break;
							
						}
						else{
							System.out.println("Employee ID already exist. Please enter valid ID");
						}
						
					}
					scan.nextLine();

					String name=" ";
					while(true){
						System.out.print("Enter employee name: ");
						name = scan.nextLine();
						if (isValidName(name))
						{
							break;
						}
						else{
							System.out.println("Invalid input.Please enter valid name");
						}
					}
					System.out.print("Enter employee salary: ");
					double salary = scan.nextDouble();
					Employee newEmployee = new Employee(id, name, salary);
					employees.add(newEmployee);
					System.out.println("=====================================================");
					System.out.println("Employee added sucessfully!!!!!!");
					System.out.println("=====================================================");
					break;

				case 2:
					System.out.println("Enter employee Id");
					int findId = scan.nextInt();
					Employee findEmployee=driver.findEmployeeById(employees,findId);
					if (findEmployee!=null){
						System.out.println("Employee Information: "+ findEmployee);
					}
					else{
						System.out.println("Employee Not Found.");
					}
					break;

				case 3:
					System.out.println("=====================================================");
					System.out.println("List of All Employees:");
					for (Employee e: employees)
					{
						System.out.println(e);
					}
					break;
				
				case 4:
					System.out.println("=====================================================");
					System.out.println("Exiting the system");
					System.out.println("=====================================================");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice. Please try again");
				}

			}
			catch (Exception e)
			{
				System.out.println("INVALID INPUT!!!!..	Enter correct input..");
				scan.next();
			}
		}
	}

	public Employee findEmployeeById(ArrayList<Employee> employees, int id)
	{
		for (Employee e:employees)
		{
			if (e.getId()== id)
			{
				return e;
			}
		}
		return null;
	}

	public static boolean isValidName(String name)
	{
		return !name.isEmpty() && name.matches("^[A-Za-z ]+$");
	}

}
