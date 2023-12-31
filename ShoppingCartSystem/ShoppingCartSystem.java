import java.util.Scanner;
import java.util.ArrayList;
class Product 
{
	private String name;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity)
	{
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
}

class CartManagement
{
	ArrayList<Product> productList = new ArrayList<>();
	public void addToCart(Product product)
	{
		productList.add(product);
	}
	
	public void removeFromCart(String removeName)
	{
		for (Product p:productList)
		{
			if (p.getName().equals(removeName.trim()))
			{
				productList.remove(p);
				System.out.println("Product removed successfully.");
			}
			else
			{
				System.out.println("Product is not in the cart.");
			}
		}
		
	}

	public double calculateCost()
	{
		double totalCost=0.0;
		for (Product p:productList)
		{
			totalCost=totalCost+(p.getPrice()*p.getQuantity());
		}

		return totalCost;
	}

	public void displayCart()
	{
		for (Product p:productList)
		{
			System.out.println("Product Name: "+p.getName());
			System.out.println("Product price: "+p.getPrice());
			System.out.println("Product Quantity: "+p.getQuantity());

		}
	}
}

public class ShoppingCartSystem
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		CartManagement cart = new CartManagement();
		System.out.println("********************Welcome to Shopping Cart System**********************");
		
		while (true)
		{
			System.out.println("1.Add product");
			System.out.println("2.Remove product");
			System.out.println("3.View cart");
			System.out.println("Exit");
			System.out.println("Enter you choice(1/2/3/4)");

				int choice = scan.nextInt();
				scan.nextLine();
			switch (choice)
			{
			case 1:
				System.out.print("Enter product name: ");
				String name=scan.nextLine();
				System.out.print("Enter prouct price :");
				double price=scan.nextDouble();
				System.out.print("Enter product quantity:");
				int quantity=scan.nextInt();
				Product product = new Product(name, price, quantity);
				cart.addToCart(product);
				System.out.println("Product added successfully.");
				scan.nextLine();
			break;
		
			case 2:
				System.out.print("Enter product name to remove");
				String removeName=scan.nextLine();
				cart.removeFromCart(removeName);
			break;

			case 3:
				System.out.println("Shopping cart content: ");
				cart.displayCart();
			break;

			case 4:
				 System.out.println("Exiting the program.");
                 scan.close();
                 System.exit(0);
			break;
            default:
		         System.out.println("Invalid option. Please choose a valid option.");
				
			}
		}
		

	}
}