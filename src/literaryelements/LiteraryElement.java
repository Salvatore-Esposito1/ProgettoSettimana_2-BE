package literaryelements;

import java.util.Objects;

public abstract class LiteraryElement {
	protected String isbnCode;
	protected String title;
	protected Integer yearOfPublication;
	protected Integer pageNumber;

	public LiteraryElement(String isbnCode, String title, Integer yearOfPublication, Integer pageNumber) {
		this.isbnCode = isbnCode;
		this.title = title;
		this.yearOfPublication = yearOfPublication;
		this.pageNumber = pageNumber;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LiteraryElement && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbnCode);
	}

}
