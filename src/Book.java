
// -----------------------------------------------------
// Assignment #3 COMP 249 Section S
// Part: 1
// Written by:  Anne Ehresmann - 27858906, and Seth Cole - 27795580
// -----------------------------------------------------
public class Book {

	private long isbn;

	private String title, authorsName;
	private int issueYear, numPages;
	private double price;
	
	public Book(){
		isbn = 00;
		title = null;
		issueYear = 00;
		authorsName = null;
		price = 00;
		numPages = 00;
		
	}
	
	public Book(String s){
		String[] att = s.split(" ");
		if(att.length == 6){
		isbn = Long.parseLong(att[0]);
		title = att[1];
		issueYear = Integer.parseInt(att[2]);
		authorsName = att[3];
		price = Double.parseDouble(att[4]);
		numPages = Integer.parseInt(att[5]);
		}
		else{
			System.out.println("Your string was incorrectly formatted! Setting attributes to default values...");
		
				isbn = 00;
				title = null;
				issueYear = 00;
				authorsName = null;
				price = 00;
				numPages = 00;
		}
		}
	
	public String toString(){
		return isbn + " " + title + " " + issueYear + " " + authorsName + " " + price +" " + numPages;
	}
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorsName() {
		return authorsName;
	}

	public void setAuthorsName(String authorsName) {
		this.authorsName = authorsName;
	}

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorsName == null) {
			if (other.authorsName != null)
				return false;
		} else if (!authorsName.equals(other.authorsName))
			return false;
		if (isbn != other.isbn)
			return false;
		if (issueYear != other.issueYear)
			return false;
		if (numPages != other.numPages)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
		
	}
	

