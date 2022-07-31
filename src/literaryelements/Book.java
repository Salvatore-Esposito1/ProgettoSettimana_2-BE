package literaryelements;

public class Book extends LiteraryElement {

	private String author;
	private String genre;

	public Book(String isbnCode, String title, int yearOfPublication, int pageNumber, String author, String genre) {
		super(isbnCode, title, yearOfPublication, pageNumber);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book = [Autore: " + author + ", Genere: " + genre + ", ISBN: " + isbnCode + ", Titolo: " + title
				+ ", Anno di pubblicazione: " + yearOfPublication + ", Numero pagine: " + pageNumber + "]";
	}

}
