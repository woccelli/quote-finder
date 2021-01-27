package com.example.moviequotes.service;

import com.example.moviequotes.dao.QuoteDao;
import com.example.moviequotes.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteDao quoteDao;

    @Autowired
    public QuoteService(@Qualifier("citedelapeur") QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    public List<Quote> getQuotes() {
        return quoteDao.getQuotes();
    }

    public List<Quote> getQuotesFromString(String innerContent) {
        return quoteDao.getQuotesFromString(innerContent);
    }
}
