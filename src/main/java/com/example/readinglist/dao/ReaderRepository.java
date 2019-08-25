package com.example.readinglist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.readinglist.dto.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>{

}
