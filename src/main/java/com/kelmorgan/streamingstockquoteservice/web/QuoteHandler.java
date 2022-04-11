package com.kelmorgan.streamingstockquoteservice.web;

import com.kelmorgan.streamingstockquoteservice.model.Quote;
import com.kelmorgan.streamingstockquoteservice.service.QuoteGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_NDJSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuoteHandler {

    private final QuoteGeneratorService service;


    public Mono<ServerResponse> fetchQuotes(ServerRequest request){
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));

        return ok().contentType(APPLICATION_JSON)
                .body(service.fetchQuoteStream(Duration.ofMillis(100l))
                        .take(size), Quote.class);    }

    public Mono<ServerResponse> streamQuotes(ServerRequest request){
        return ok().contentType(APPLICATION_NDJSON)
                .body(service.fetchQuoteStream(Duration.ofMillis(100l)),Quote.class);

    }
}
