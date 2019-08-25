package com.example.readinglist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.readinglist.dto.Book;
import com.example.readinglist.dto.Reader;

public interface ReadingListRepository extends JpaRepository<Book, Long>{
	
	List<Book> findByReader(Reader reader);

}
