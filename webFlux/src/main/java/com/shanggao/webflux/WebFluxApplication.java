package com.shanggao.webflux;

import com.shanggao.webflux.service.BookHandler;
import com.shanggao.webflux.service.BookRepository;
import com.shanggao.webflux.service.InMemoryBookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);


    }

    @Bean
    public BookRepository bookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    public BookHandler bookHandler(BookRepository bookRepository) {
        return new BookHandler(bookRepository);
    }
}
