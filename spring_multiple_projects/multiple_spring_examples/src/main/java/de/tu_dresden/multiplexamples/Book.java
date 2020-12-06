package de.tu_dresden.multiplexamples;

public class Book {
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	long id; 
	String name;
	String author;
}
