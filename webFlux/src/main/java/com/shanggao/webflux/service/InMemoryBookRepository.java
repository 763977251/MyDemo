package com.shanggao.webflux.service;

import com.shanggao.webflux.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 10699518
 * @Description: TODO
 */
public class InMemoryBookRepository implements BookRepository{
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Flux<Book> findAll() {
        return Flux.fromIterable(books.values());
    }

    @Override
    public Mono<Book> findById(String id) {
        return Mono.justOrEmpty(books.get(id));
    }

    @Override
    public Mono<Book> save(Book book) {
        books.put(book.getId(), book);
        return Mono.just(book);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        books.remove(id);
        return Mono.empty();
    }
}
