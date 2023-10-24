package com.shanggao.webflux.service;

import com.shanggao.webflux.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author 10699518
 * @Description: TODO
 */
public class BookHandler {
    private final BookRepository bookRepository;

    public BookHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<ServerResponse> getAllBooks(ServerRequest request) {
        return ServerResponse.ok().body(bookRepository.findAll(), Book.class);
    }

    public Mono<ServerResponse> getBookById(ServerRequest request) {
        return bookRepository.findById(request.pathVariable("id"))
                .flatMap(book -> ServerResponse.ok().body(BodyInserters.fromValue(book)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> saveBook(ServerRequest request) {
        Mono<Book> bookMono = request.bodyToMono(Book.class);
        return bookMono.flatMap(book ->
                ServerResponse.status(HttpStatus.CREATED).body(bookRepository.save(book), Book.class));
    }

    public Mono<ServerResponse> deleteBookById(ServerRequest request) {
        return bookRepository.deleteById(request.pathVariable("id"))
                .then(ServerResponse.noContent().build());
    }
}
