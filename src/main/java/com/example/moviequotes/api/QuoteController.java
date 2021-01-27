package com.example.moviequotes.api;

import com.example.moviequotes.model.Quote;
import com.example.moviequotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/quotes")
@RestController
public class QuoteController {

    private final QuoteService quoteService;

     @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<Quote> getQuotes() {
        return quoteService.getQuotes();
    }

    @GetMapping("/find")
    public List<Quote> getQuotesFromString(@RequestParam("innerContent") Optional<String> innerContent) {
         return quoteService.getQuotesFromString(innerContent.orElse(""));
    }
}
