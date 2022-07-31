package program;

import literaryelements.LiteraryElement;
import literaryelements.Book;
import literaryelements.Magazine;
import literaryelements.Periodicity;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {

	private static final Logger Log = LoggerFactory.getLogger(Program.class);

	private static final String FILE_PATH = "./archiveDisk.txt";

	private Map<String, LiteraryElement> archive;

	public Program() {
		this.archive = new HashMap<String, LiteraryElement>();
	}

	public void addElement(LiteraryElement newElement) {
		archive.put(newElement.getIsbnCode(), newElement);
		Log.info("Elemento aggiunto in archivio. ISBN: {} - Anno Pubblicazione: {}", newElement.getIsbnCode(),
				newElement.getYearOfPublication());
	}

	public void removeElement(String isbnCode) {
		LiteraryElement removeElement = archive.remove(isbnCode);
		if (removeElement != null)
			Log.info("Elemento rimosso dall'archivio. ISBN: {} - Anno Pubblicazione: {}", removeElement.getIsbnCode(),
					removeElement.getYearOfPublication());

	}

	public LiteraryElement searchByIsbn(String isbnCode) {
		return archive.get(isbnCode);
	}

	public List<LiteraryElement> searchByYearOfPublication(Integer yearOfPublication) {
		return archive.values().stream().filter(elem -> yearOfPublication.equals(elem.getYearOfPublication()))
				.collect(Collectors.toList());
	}

	public List<Book> searchByAuthor(String author) {
		return archive.values().stream().filter(elem -> elem instanceof Book).map(elem -> (Book) elem)
				.filter(elem -> author.equalsIgnoreCase(elem.getAuthor())).collect(Collectors.toList());
	}

	public void saveCatalog() {
		String catalogToText = "";
		for (LiteraryElement catalog : archive.values()) {
			catalogToText += (catalog.toString() + ";");
		}
		File catalogFile = new File(FILE_PATH);
		try {
			FileUtils.writeStringToFile(catalogFile, catalogToText, StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadCatalog() throws IOException {
		this.archive.clear();

		File file = new File(FILE_PATH);

		String readString = FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1);
		String[] catalog = readString.split(";");
		for (String element : catalog) {
			System.out.println(element);
		}

	}

	public static void main(String[] args) {
		Program catalog = new Program();
		Book b1 = new Book("A123F7", "Harry Potter e la pietra filosofale", 1998, 293, "Joanne Rowling", "Fantasy");
		Book b2 = new Book("F5JS45", "Harry Potter e e la camera dei segreti", 1998, 324, "Joanne Rowling", "Fantasy");
		Book b3 = new Book("C26A15", "Il caso Alaska Sanders", 2022, 624, "Joel Dicker", "Thriller");
		Magazine m1 = new Magazine("1C1412", "BBC", 2021, 178, Periodicity.WEEKLY);
		Magazine m2 = new Magazine("Z41F9", "Il giornale", 2022, 74, Periodicity.WEEKLY);
		catalog.addElement(b1);
		catalog.addElement(b2);
		catalog.addElement(b3);
		catalog.addElement(m1);
		catalog.addElement(m2);
		System.out.println(catalog.searchByAuthor("Joanne Rowling"));
		System.out.println(catalog.searchByIsbn("Z41F9"));
		try {
			catalog.saveCatalog();
			catalog.uploadCatalog();

		} catch (IOException e) {
			Log.error("Errore durante la lettura/scrittura", e);
		}

	}

}
