public class Book {
	//private fields
	private String title;
	private String author;
	private int yearOfPublication;
	private String publisher;
	private int numberOfPages;
	
	/**
	 * Constructs a Book with the specified title, author, year of publication, publisher, 
	 * and number of pages.
	 * 
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param yearOfPublication the year of publication
	 * @param publisher the publisher
	 * @param numberOfPages the number of pages
	 * @throws IllegalArgumentException If yearOfPublication is negative or more than 2024, or 
	 * numberOfPages is negative
	 */

	public Book(String title, String author, int yearOfPublication, 
			String publisher, int numberOfPages) 
	{
		// throws exception if year is negative or in future
		if (yearOfPublication < 0 || yearOfPublication > 2024) 
		{
			throw new IllegalArgumentException("Year of Publication cannot be negative or "
					+ "greather than the current year");
		}
		// throws exception if number of pages is less than 0
		if (numberOfPages < 0)
		{
			throw new IllegalArgumentException("Number of Pages cannot be less than "
					+ "or equal to 0");
		}
		// assigns each parameter to its field
		this.title = title;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		
	}
	
	/**
	 * Returns the title of the book
	 * 
	 * @return the title of the book
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * Sets the title of the book.
	 * @param title the new title of the book
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Returns the author of the book
	 * 
	 * @return the author of the book
	 */
	public String getAuthor() 
	{
		return author;
	}

	/**
	 * Sets the author of the book.
	 * 
	 * @param author the new author of the book
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Returns the year of publication of the book
	 * 
	 * @return the year of publication of the book
	 */
	public int getYearOfPublication() 
	{
		return yearOfPublication;
	}

	/**
	 * Sets the year of publication of the book if the year is not negative or in the future.
	 * 
	 * @param yearOfPublication the new year of publication
	 * @throws IllegalArgumentException If yearOfPublication is negative or more than 2024
	 */
	public void setYearOfPublication(int yearOfPublication) 
	{
		// throws exception if new year of publication is negative or in the future
		if (yearOfPublication < 0 || yearOfPublication > 2024)
		{
			throw new IllegalArgumentException("Year of publication cannot be negative or "
					+ "more than 2024");
		}
		this.yearOfPublication = yearOfPublication;
	}

	/**
	 * Returns the publisher of the book
	 * 
	 * @return the publisher of the book
	 */
	public String getPublisher() 
	{
		return publisher;
	}
	
	/**
	 * Sets the publisher of the book.
	 * 
	 * @param publisher the new publisher of the book
	 */
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	/**
	 * Returns the number of pages in the book.
	 * 
	 * @return the number of pages in the book
	 */
	public int getNumberOfPages() 
	{
	    return numberOfPages;
	}
	
	/**
	 * Sets the number of pages of the book.
	 * 
	 * @param numberOfPages the new number of pages
	 * @throws IllegalArgumentException if numberOfPages is negative
	 */
	public void setNumberOfPages(int numberOfPages) 
	{
		// throws exception if new number of pages is negative
		if (numberOfPages < 0)
		{
			throw new IllegalArgumentException("Number of Pages cannot be negative");
		}
		this.numberOfPages = numberOfPages;
	}
}
