import java.util.Scanner;
import java.util.ArrayList;
class Book 
{
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;

	public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markBorrowed() {
        isAvailable = false;
    }

    public void markReturned() {
        isAvailable = true;
    }
}


class Library
{
	ArrayList<Book> booklist = new ArrayList<>();
	
	public void addBooks(Book book)
	{
		booklist.add(book);
	}

	public void displayAvailableBooks()
	{
		System.out.println("Available Books: ");
		for (Book book:booklist)
		{
			if (book.isAvailable())
			{
				 System.out.println("Title: " + book.getTitle());
				 System.out.println("Author: " + book.getAuthor());
                 System.out.println("ISBN: " + book.getISBN() + "\n");
			}
		}
	}

	public Book findBookByISBN(String ISBN)
	{
		for (Book book:booklist)
		{
			if (book.getISBN().equalsIgnoreCase(ISBN))
			{
				return book;
			}
		}
		return null;
	}
}

public class LibraryManagementSystem
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("*********************Welcome to Library Management System***********************");
		Library library = new Library();

		library.addBooks(new Book("Book1","Author1","ISBN1"));
		library.addBooks(new Book("Book2","Author2","ISBN2"));
		library.addBooks(new Book("Book3","Author3","ISBN3"));
		library.addBooks(new Book("Book4","Author4","ISBN4"));
		library.addBooks(new Book("Book5","Author5","ISBN5"));
		
	
		while (true)
		{
			try
			{
				System.out.println("1.Borrow a book");
				System.out.println("2.Return a book");
				System.out.println("3.View Available books");
				System.out.println("4.Exit");
				System.out.println("Enter your choice(1/2/3/4)");
				
				int choice = scan.nextInt();
				scan.nextLine();
				switch (choice)
				{
				case 1:
					System.out.print("Enter ISBN of book you want to borrow: ");
					String borrowISBN = scan.nextLine();
					Book borrowBook = library.findBookByISBN(borrowISBN);
					if (borrowBook!=null && borrowBook.isAvailable())
					{
						borrowBook.markBorrowed();
						System.out.println("You have borrowed the book "+borrowBook.getTitle());
					}
					else
					{
						System.out.println("The book is not available for borrowing.");

					}

				break;

				case 2:
					System.out.print("Enter ISBN of book you want to return: ");
					String returnISBN = scan.nextLine();
					Book returnBook = library.findBookByISBN(returnISBN);
					if (returnBook!=null && !returnBook.isAvailable())
					{
						returnBook.markReturned();
						System.out.println("You have returned the book "+returnBook.getTitle());
					}
					else
					{
						System.out.println("The book is not borrowed or does not exist in the inventory.");

					}
					break;
				case 3:
					library.displayAvailableBooks();
				break;

				case 4:
					System.out.println("Exiting Library Management System.");
					scan.close();
					System.exit(0);

				break;

				default:
					System.out.println("Invalid choice. Please enter valid option");
				break;
				}
			
			}
			catch (Exception e)
			{
				System.out.println("INVALID INPUT!!!!..	Enter correct input..");
				scan.next();
			}

		}
	}
}
