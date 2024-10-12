import java.util.ArrayList;

/**
 * Tests methods of Book and Library classes.
 */
public class LibraryTester {
	/**
	 * PROVIDED TESTER METHOD: example test method for testing the getTitle method.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testGetTitle() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		return "1984".equals(book.getTitle());
	}

	/**
	 * PROVIDED TESTER METHOD: example test method for testing the setTitle method.
	 *
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testSetTitle() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		book.setTitle("Animal Farm");
		return "Animal Farm".equals(book.getTitle());
	}

	/**
	 * test method for testing the getAuthor method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testGetAuthor() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		return "George Orwell".equals(book.getAuthor());
	}

	/**
	 * test method for testing the setAuthor method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testSetAuthor() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		book.setAuthor("James Madison");
		return "James Madison".equals(book.getAuthor());  }

	/**
	 * test method for testing the getYearOfPublication method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testGetYearOfPublication() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		return 1949 == book.getYearOfPublication();  }

	/**
	 * test method for testing the setYearOfPublication method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testSetYearOfPublication() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		book.setYearOfPublication(1979);
		return 1979 == book.getYearOfPublication();  }

	/**
	 * test method for testing the getPublisher method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testGetPublisher() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		return "Secker & Warburg".equals(book.getPublisher());
	}

	/**
	 * test method for testing the setPublisher method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testSetPublisher() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		book.setPublisher("Wall Street");
		return "Wall Street".equals(book.getPublisher());  }

	/**
	 * test method for testing the getNumberOfPages method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testGetNumberOfPages() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		return 328 == book.getNumberOfPages();  }

	/**
	 * test method for testing the setNumberOfPages method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testSetNumberOfPages() {
		Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
		book.setNumberOfPages(296);
		return 296 == book.getNumberOfPages();  }

	/**
	 * PROVIDED TESTER METHOD: Retrieves the total number of books in the library.
	 * 
	 * @return the total number of books
	 */
	public static boolean testGetTotalBooks() {
		Library library = new Library();
		library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
		library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

		int expected = 2;
		int result = library.getTotalBooks();

		ArrayList<Book> expectedA = new ArrayList<>(); // adds same objects
		expectedA.add(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
		expectedA.add(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

		if (expected != result) { // checks if total is the same as expected
			return false;
		}
		return compareBooks(expectedA, library.getAllBooks());
	}


	/**
	 * PROVIDED TESTER METHOD: example test method for adding a single book to the library.
	 * 
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testAddBook() {
		Library library = new Library();
		Book book = new Book("Test Book", "Test Author", 2023, "Publisher X", 100);
		library.addBook(book);

		ArrayList<Book> expected = new ArrayList<>();
		expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
		return compareBooks(expected, library.getAllBooks()); // checks if added 
	}


	/**
	 * test method for adding multiple books to the library.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testAddMultipleBooks() {
		Library library = new Library();
		Book book1 = new Book("Test Book 1", "Test Author 1", 2010, "Publisher X", 100);
		Book book2 = new Book("Test Book 2", "Test Author 2", 2019, "Publisher Y", 100);
		library.addBook(book1);
		library.addBook(book2);

		// checks if multiple books are added
		ArrayList<Book> expected = new ArrayList<>();
		expected.add(new Book("Test Book 1", "Test Author 1", 2010, "Publisher X", 100));
		expected.add(new Book("Test Book 2", "Test Author 2", 2019, "Publisher Y", 100));
		return compareBooks(expected, library.getAllBooks());

	}

	/**
	 * PROVIDED TESTER METHOD: example test method for removing a book by title from the library.
	 * 
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testRemoveBookByTitle() {
		Library library = new Library();
		library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
		boolean result = library.removeBookByTitle("Test Book");

		// checking result from removeBookByTitle("Test Book")
		if (result != true) {
			return false;
		}
		// checking resulted number of books
		if (library.getTotalBooks() != 0) {
			return false;
		}
		ArrayList<Book> expected = new ArrayList<>();
		// checking resulted library
		if (!compareBooks(expected, library.getAllBooks())) {
			return false;
		}
		return true;
	}

	/**
	 * test method for removing one book from the library with many books.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testRemoveOneOfManyBooks() {
		Library library = new Library();
		ArrayList<Book> expected = new ArrayList<>();
		Book book1 = new Book("Test Book 1", "Test Author 1", 2010, "Publisher X", 100);
		Book book2 = new Book("Test Book 2", "Test Author 2", 2019, "Publisher Y", 100);
		Book book3 = new Book("Test Book 3", "Test Author 3", 2017, "Publisher Z", 100);
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		expected.add(book1);
		expected.add(book3);


		boolean result = library.removeBookByTitle("Test Book 2");

		// checking result from removeBookByTitle("Test Book")
		if (result != true) {
			return false;
		}
		// checking resulted number of books
		if (library.getTotalBooks() != 2) {
			return false;
		}

		// checking resulted library
		if (!compareBooks(expected, library.getAllBooks())) {
			return false;
		}
		return true;

	}

	/**
	 * test method for the findBooksByAuthour method.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testFindBooksByAuthor() {
		Library library = new Library();
		ArrayList<Book> expected = new ArrayList<>();
		Book book1 = new Book("Test Book 1", "Test Author 1", 2010, "Publisher X", 100);
		Book book2 = new Book("Test Book 2", "Test Author 2", 2019, "Publisher Y", 100);
		Book book3 = new Book("Test Book 3", "Test Author 3", 2017, "Publisher Z", 100);
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		expected.add(book3);

		ArrayList<Book> actual = library.findBooksByAuthor("Test Author 3");

		// checks if array returned is same as expected
		if (!compareBooks(expected,actual))
		{
			return false;
		}

		return true;


	}

	/**
	 * test method for finding books with other authors.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testFindBooksByMultipleAuthors() {
		Library library = new Library();
		ArrayList<Book> expected1 = new ArrayList<>();
		ArrayList<Book> expected2 = new ArrayList<>();

		Book book1 = new Book("Test Book 1", "Test Author 1", 2010, "Publisher X", 100);
		Book book2 = new Book("Test Book 2", "Test Author 1", 2019, "Publisher Y", 100);
		Book book3 = new Book("Test Book 3", "Test Author 3", 2017, "Publisher Z", 100);
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		expected1.add(book3);
		expected2.add(book1);
		expected2.add(book2);


		// checks if array returned is the same as expected for different authors
		if (!compareBooks(expected1,library.findBooksByAuthor("Test Author 3")))
		{
			return false;
		}
		if (!compareBooks(expected2,library.findBooksByAuthor("Test Author 1")))
		{
			return false;
		}

		return true;	
	}


	/**
	 * test method for updating the book title of a book using its previous title.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testUpdateBookTitle() {
		Library library = new Library();
		library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
		boolean result1 = library.updateBookTitle("Test Book", "New Book");
		boolean expectedResult1 = true;

		// checks if book updated
		if(!(result1 == expectedResult1))
		{
			return false;
		}

		// checks if book that does not exist is updated
		boolean result2 = library.updateBookTitle("Book", "New Book");
		boolean expectedResult2 = false;
		if(!(result2 == expectedResult2))
		{
			return false;
		}
		return true;
	}

	/**
	 * test method for updating the titles of multiple books of the library.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testUpdateMultipleBookTitles() {
		Library library = new Library();
		library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
		library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

		// checks if multiple books updated
		if(!library.updateBookTitle("Book 1","New Book"))
		{
			return false;
		}
		if(!library.updateBookTitle("Book 2","New Book 2"))
		{
			return false;
		}

		// checks if a book is updated when falsely used
		if(library.updateBookTitle("Book", "New Book"))
		{
			return false;
		}
		return true;

	}

	/**
	 * test method for updating the author using its title to the library.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testUpdateBookAuthor() {
		Library library = new Library();
		library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
		library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

		// checks if author is updated
		if(!library.updateBookAuthor("Book 1","New Author"))
		{
			return false;
		}

		// checks if author is updated on a book that does not exist
		if(library.updateBookAuthor("Book","New Author"))
		{
			return false;
		}
		return true;
	}

	/**
	 * test method for updating multiple book's authors of the library.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testUpdateMultipleBookAuthors() {
		Library library = new Library();
		library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
		library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

		// checks if author is updated on multiple books
		if(!library.updateBookAuthor("Book 1","New Author"))
		{
			return false;
		}
		if(!library.updateBookAuthor("Book 2","New Author 2"))
		{
			return false;
		}
		// checks if author is updates on a book that does not exist
		if(library.updateBookAuthor("Book","New Author"))
		{
			return false;
		}
		return true;	
	}

	/**
	 * test method for checking if a book that does not exist is removed.
	 * @return true if the test passes, false otherwise
	 */
	public static boolean testRemoveNonExistentBook() {
		Library library = new Library();
		ArrayList<Book> expected = new ArrayList<>();
		Book book = new Book("Test Book", "Test Author", 2023, "Publisher X", 100);
		library.addBook(book);
		expected.add(book);
		boolean result = library.removeBookByTitle("Test");

		// checking result from removeBookByTitle("Test Book")
		if (result != false) {
			return false;
		}
		// checking resulted number of books
		if (library.getTotalBooks() != 1) {
			return false;
		}
		// checking resulted library
		if (!compareBooks(expected, library.getAllBooks())) {
			return false;
		}
		return true;
	}

	/**
	 * Compares two lists of books for equality.
	 * 
	 * @param expected the expected list of books
	 * @param result   the list of books to compare
	 * @return true if both lists contain the same books, false otherwise
	 */
	private static boolean compareBooks(ArrayList<Book> expected, ArrayList<Book> result) {
		if (expected.size() != result.size()) {
			return false;
		}
		for (int i = 0; i < expected.size(); i++) {
			Book expectedBook = expected.get(i);
			Book resultBook = result.get(i);
			if (!expectedBook.getTitle().equals(resultBook.getTitle())
					|| !expectedBook.getAuthor().equals(resultBook.getAuthor())
					|| !(expectedBook.getPublisher().equals(resultBook.getPublisher()))
					|| !(expectedBook.getNumberOfPages() == resultBook.getNumberOfPages())
					|| !(expectedBook.getYearOfPublication() == resultBook.getYearOfPublication())) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// test two functions in book.class
		System.out.println("Test getTitle: " + testGetTitle());
		System.out.println("Test setTitle: " + testSetTitle());
		System.out.println("Test getAuthor: " + testGetAuthor());
		System.out.println("Test setAuthor: " + testSetAuthor());
		System.out.println("Test getYearOfPublication: " + testGetYearOfPublication());
		System.out.println("Test setYearOfPublication: " + testSetYearOfPublication());
		System.out.println("Test getPublisher: " + testGetPublisher());
		System.out.println("Test setPublisher: " + testSetPublisher());
		System.out.println("Test getNumberOfPages: " + testGetNumberOfPages());
		System.out.println("Test setNumberOfPages: " + testSetNumberOfPages());
		System.out.println("Test getTotalBooks: " + testGetTotalBooks());
		System.out.println("Test addBook: " + testAddBook());
		System.out.println("Test addMultipleBooks: " + testAddMultipleBooks());
		System.out.println("Test removeBookByTitle: " + testRemoveBookByTitle());
		System.out.println("Test removeOneOfManyBooks: " + testRemoveOneOfManyBooks());
		System.out.println("Test findBooksByAuthor: " + testFindBooksByAuthor());
		System.out.println("Test findBooksByMultipleAuthors: " + testFindBooksByMultipleAuthors());
		System.out.println("Test updateBookTitle: " + testUpdateBookTitle());
		System.out.println("Test updateMultipleBookTitles: " + testUpdateMultipleBookTitles());
		System.out.println("Test updateBookAuthor: " + testUpdateBookAuthor());
		System.out.println("Test updateMultipleBookAuthors: " + testUpdateMultipleBookAuthors());
		System.out.println("Test removeNonExistentBook: " + testRemoveNonExistentBook());

	}
}
