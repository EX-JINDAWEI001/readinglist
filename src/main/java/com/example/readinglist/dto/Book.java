package com.example.readinglist.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", reader=" + reader + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", description=" + description + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Reader reader;
	
	private String isbn;
	
	private String title;
	
	private String author;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Objects.equals(id, book.id) &&
				Objects.equals(reader, book.reader) &&
				Objects.equals(isbn, book.isbn) &&
				Objects.equals(title, book.title) &&
				Objects.equals(author, book.author) &&
				Objects.equals(description, book.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reader, isbn, title, author, description);
	}
}
