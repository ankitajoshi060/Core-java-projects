import java.util.Scanner;

class InsufficientBalanceException extends Exception
{
	public InsufficientBalanceException() {
        super("Insufficient balance in the account");
    }

    public InsufficientBalanceException(String message) {
        super(message);
	}
}


class BankAccount
{
	private long accountNo;
	private double balance;
	private String accountHolderName;
	
	public BankAccount(long accountNo, double balance, String accountHolderName)
	{
		this.accountNo=accountNo;
		this.balance=balance;
		this.accountHolderName=accountHolderName;
	}

	public long getAccountNo()
	{
		return accountNo;
	}
	public double getBalance()
	{
		return balance;
	}
	public String getAccountHolderName()
	{
		return accountHolderName;
	}

	public void setAccountNo(long accountNo)
	{
		this.accountNo=accountNo;
	}

	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public void setAccountHolderName(String accountHolderName)
	{
		this.accountHolderName=accountHolderName;
	}

	public double deposite(double amount, double balance)
	{
		return balance+amount;
	}

	public double withdraw(double amount, double balance) throws InsufficientBalanceException 
	{
		if(balance<amount)
		{
			throw new InsufficientBalanceException();
		}
		else
		{
			return balance-amount;
		}
	}

	public void display(double balance)
	{
		System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNo);
		System.out.println("Your total balance = "+balance);
	}

}

class  Bank
{
	public static void main(String[] args) 
	{
			Scanner scan= new Scanner(System.in);
			System.out.println("================================================================");
			System.out.println("********************Welcom to KJSB Bank*************************");
			System.out.println("================================================================");
			double currentBalance=0.0;
			String name="";
			double amount=0.0;
			while(true)
			{
				System.out.println("Enter your name");
				name=scan.nextLine();
				if(!name.isEmpty() && name.matches("^[A-Za-z ]+$"))
				{
					break;
				}
				else
				{
					System.out.println("Invalid input. Please Enter valid name");
				}
			}

			System.out.println("Enter your AccountNo");
			long accountNo=scan.nextLong();
			
			BankAccount account= new BankAccount(accountNo,currentBalance,name);
			
			while (true)
			{
				System.out.println("1.Deposite");
				System.out.println("2.Withdraw");
				System.out.println("3.Display Balance");
				System.out.println("4.Exit");
				System.out.println("Enter your choice(1/2/3/4)");

				int choice=scan.nextInt();
				switch (choice)
				{
				case 1:
					while (true)
					{
						System.out.println("Enter amount");
						amount=scan.nextDouble();
						if (amount>0)
						{
							currentBalance=account.deposite(amount,currentBalance);
							System.out.println("Deposited Successfully! Your current balance is "+currentBalance);
							System.out.println("==================================================================");
							break;
						}
						else
						{
							System.out.println("Invalid deposit amount. Please enter a positive value.");
						}
					}				
					break;

				case 2:
					try
					{
						while (true)
						{
							System.out.println("Enter amount");
							amount=scan.nextDouble();
							if(amount>0)
							{
								currentBalance=account.withdraw(amount,currentBalance);
								System.out.println("Withdraw Successfully! Your current balance is "+ currentBalance);
								System.out.println("==================================================================");
								break;
							}
							else
							{
								System.out.println("Invalid withdraw amount. Please enter a positive value.");
							}
							
							
						}
						
						
					}
					catch (InsufficientBalanceException e)
					{
						System.out.println("Error: "+e.getMessage());
						System.out.println("==================================================================");
					}

					break;

				case 3:
					System.out.println("================================================================");
					account.display(currentBalance);
					System.out.println("================================================================");

				break;

				case 4:
					System.out.println("================================================================");
					System.out.println("Thank you for using our banking services!");
					System.out.println("================================================================");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Input. Please enter valid input!");
				
				}
			}
			

		
	}
}
