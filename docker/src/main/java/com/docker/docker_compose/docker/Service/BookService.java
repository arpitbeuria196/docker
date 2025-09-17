package com.docker.docker_compose.docker.Service;


import com.docker.docker_compose.docker.DTO.BookDTO;
import com.docker.docker_compose.docker.Entity.Book;
import com.docker.docker_compose.docker.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public List<BookDTO> getBooks() {
        return bookRepository.findAll().stream()
                .map(b -> modelMapper.map(b, BookDTO.class))
                .toList();
    }

    public  String createBook(BookDTO book)
    {
        Optional<Book> book1 = Optional.empty();
        if (book.getId() != null) {
            book1 = bookRepository.findById(book.getId());
        }

        if (book1.isPresent()) {
            throw new RuntimeException("Book Already Exists");
        }

        Book entity=   modelMapper.map(book,Book.class);



       Book saved = bookRepository.save(entity);

        return "Saved Successfully in DB";

    }

}
