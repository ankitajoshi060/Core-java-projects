import java.util.Scanner;
import java.util.InputMismatchException;

class Calculator{

	public double addition(double num1, double num2){
		return num1+num2;
	}

	public double substraction(double num1, double num2){
		return num1-num2;
	}

	public double multiplication(double num1, double num2){
		return num1*num2;
	}

	public double division(double num1, double num2){
		return num1/num2;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Calculator c = new Calculator();
		System.out.println("=====================================================");
		System.out.println("********Welcome to Basic Calculator***********");
		System.out.println("=====================================================");

		
		while (true)
		{
			try
			{
				System.out.println("Select the Operation");
				System.out.println("1. Addition(+)");
				System.out.println("2. Substraction(-)");
				System.out.println("3. Multiplication(*)");
				System.out.println("4. Division(/)");
				System.out.println("5. Exit");
				System.out.println("Enter your choice(1/2/3/4/5)");

				int choice=scanner.nextInt();
				if(choice == 5)
				{
					System.out.println("Calculator Exiting");
					break;
				}

				System.out.println("Enter the first number ");
                double number1 = scanner.nextDouble();
				System.out.println("Enter the second number ");
                double number2 = scanner.nextDouble();

				switch(choice){
					case 1:System.out.println("Result: "+c.addition(number1, number2));
						   System.out.println("=====================================================");
					break;
					case 2:System.out.println("Result: "+c.substraction(number1, number2));
						   System.out.println("=====================================================");
					break;
					case 3:System.out.println("Result: "+c.multiplication(number1, number2));
						   System.out.println("=====================================================");
					break;
					case 4:
						if (number2!=0)
						{
							System.out.println("Result: "+c.division(number1, number2));
							System.out.println("=====================================================");
						}
						else
						{
							System.out.println("!!!!Error:Dividing by zero is not allowed");
							System.out.println("=====================================================");
						}
					break;
					default:
						System.out.println("Invalid choice. Select the valid operation.");
						System.out.println("=====================================================");
				}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid input. Please enter a valid number");
			System.out.println("=====================================================");
			scanner.next();
		}
	}


}
}