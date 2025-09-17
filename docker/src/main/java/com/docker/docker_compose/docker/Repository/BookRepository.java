package com.docker.docker_compose.docker.Repository;

import com.docker.docker_compose.docker.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
