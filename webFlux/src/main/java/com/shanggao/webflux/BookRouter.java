package com.shanggao.webflux;

import com.shanggao.webflux.service.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @Author 10699518
 * @Description: TODO
 */

@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> route(BookHandler bookHandler) {
        return RouterFunctions
                .route(GET("/books").and(accept(MediaType.APPLICATION_JSON)), bookHandler::getAllBooks)
                .andRoute(GET("/books/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), bookHandler::getBookById)
                .andRoute(POST("/books").and(accept(MediaType.APPLICATION_JSON)), bookHandler::saveBook)
                .andRoute(DELETE("/books/{id}").and(accept(MediaType.APPLICATION_JSON)), bookHandler::deleteBookById);
    }
}
