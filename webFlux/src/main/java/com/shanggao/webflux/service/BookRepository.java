package com.shanggao.webflux.service;

import com.shanggao.webflux.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author 10699518
 * @Description: TODO
 */
public interface BookRepository {
    Flux<Book> findAll();
    Mono<Book> findById(String id);
    Mono<Book> save(Book book);
    Mono<Void> deleteById(String id);
}
