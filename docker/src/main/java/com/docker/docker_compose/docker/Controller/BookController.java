package com.docker.docker_compose.docker.Controller;


import com.docker.docker_compose.docker.DTO.BookDTO;
import com.docker.docker_compose.docker.Service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    private ResponseEntity<List<BookDTO>> getAllBooks()
    {
        List<BookDTO> bookDTO = bookService.getBooks();

        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<String> createBooks(@RequestBody BookDTO bookDTO)
    {
        String mssg = bookService.createBook(bookDTO);

        return new ResponseEntity<>(mssg,HttpStatus.CREATED);
    }
}
