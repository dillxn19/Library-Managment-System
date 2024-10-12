
import java.util.ArrayList;

/**
 * Represents a library that manages a collection of books.
 * 
 */
public class Library {
	
	// private field
	private ArrayList<Book> books;
	
	/**
	 * Constructs an empty library. This constructor initializes the 'books' list 
	 * so that books can be added later.
	 */
	public Library()
	{
		books = new ArrayList<Book>();
	}
	
	/**
	 * Adds a book to the library. This method adds the provided book to the 'books' arraylist 
	 * in a chronological order from the oldest to the newest.
	 * 
	 * @param book the book to be added
	 */
	public void addBook(Book book)
	{
		
		for (int i = 0; i < books.size(); i++) // loops through books in library
		{
			// adds it chronologically, finding index position
			if (book.getYearOfPublication() < books.get(i).getYearOfPublication())
			{
				books.add(i,book);
				return;
			}
		}
		
		books.add(book); // adds the book if array is empty or book is most recent
		
	}
	
	
	/**
	 * Removes a book from the library by its title. This method searches the 'books' 
	 * list for a book with the specified title and removes it.
	 * 
	 * @param title the title of the book to remove
	 * @return true if the book was removed, false otherwise
	 */
	public boolean removeBookByTitle(String title)
	{
		for (int i = 0; i < books.size(); i++) // loops through array to find book with title
		{
			if (books.get(i).getTitle().equalsIgnoreCase(title))
			{
				books.remove(i); // if found removed
				return true;
			}
		}
		return false; // if not found
	}
	
	
	/**
	 * Finds books by a specific author. This method searches the 'books' list for books written
	 * by the specified author.
	 * 
	 * @param author the author whose books are to be found
	 * @return a list of books by the specified author
	 */
	public ArrayList<Book> findBooksByAuthor(String author)
	{
		// new array to add books with the author name
		ArrayList <Book> authorList = new ArrayList <Book>();  
		for (int i = 0; i < books.size(); i++)
		{
			if (books.get(i).getAuthor().equalsIgnoreCase(author))
			{
				authorList.add(books.get(i)); // adds to new array if author is same
			}
		}
		return authorList; // returns array of books with specific author
	}
	
	/**
	 * Retrieves the total number of books in the library. This method returns the size of 
	 * the 'books' list, which represents the total number of books.
	 * 
	 * @return the total number of books
	 */
	public int getTotalBooks()
	{
		return books.size();
	}
	
	
	/**
	 * Updates the title of a book. This method searches for a book with the specified old title 
	 * and updates it to the new title.
	 * 
	 * @param oldTitle the current title of the book
	 * @param newTitle the new title to assign
	 * @return true if the title was updated, false otherwise
	 */
	public boolean updateBookTitle(String oldTitle, String newTitle)
	{
		for (int i = 0; i < books.size(); i++) // loops through books in library
		{
			if (books.get(i).getTitle().equalsIgnoreCase(oldTitle))
			{
				books.get(i).setTitle(newTitle); // updates title of book 
				return true;
			}
		}
		return false;
	}

	/**
	 * Updates the author of a book. This method searches for a book with the specified
	 * title and updates its author.
	 * 
	 * @param title the title of the book whose author is to be updated
	 * @param newAuthor the new author to assign
	 * @return true if the author was updated, false otherwise
	 */
	public boolean updateBookAuthor(String title, String newAuthor)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (books.get(i).getTitle().equalsIgnoreCase(title))
			{
				books.get(i).setAuthor(newAuthor); // updates author of the book that match title
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a list of all books in the library. This method creates and returns a new 
	 * list that contains all the books in the library.
	 * 
	 * @return a list containing all books in the library

	 */
	public ArrayList<Book> getAllBooks()
	{
		return books;
	}

	/**
	 * Prints all books in the library. This method prints the title and author 
	 * of each book in the library to the console.
	 */
	public void printAllBooks()
	{
		// loops through all books to print its title and author side by side
		for (int i = 0; i < books.size(); i++)
		{
			System.out.println("Title: " + books.get(i).getTitle() + ", Author: " 
		+ books.get(i).getAuthor());
		}
	}
}
