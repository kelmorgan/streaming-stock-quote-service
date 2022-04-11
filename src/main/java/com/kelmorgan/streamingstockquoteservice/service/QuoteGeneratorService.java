package com.kelmorgan.streamingstockquoteservice.service;

import com.kelmorgan.streamingstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {

    Flux<Quote> fetchQuoteStream (Duration period);
}
