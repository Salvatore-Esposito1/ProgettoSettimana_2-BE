package literaryelements;

public class Magazine extends LiteraryElement {
	Periodicity periodicity;

	public Magazine(String isbnCode, String title, int yearOfPublication, int pageNumber, Periodicity periodicity) {
		super(isbnCode, title, yearOfPublication, pageNumber);
		this.periodicity = periodicity;
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine = [periodicita: " + periodicity + ", ISBN =" + isbnCode + ", Titolo: " + title
				+ ", Anno di pubblicazione: " + yearOfPublication + ", numero pagine: " + pageNumber + "]";
	}

}
