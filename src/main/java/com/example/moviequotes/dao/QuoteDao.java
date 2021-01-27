package com.example.moviequotes.dao;

import com.example.moviequotes.model.Quote;

import java.util.List;

public interface QuoteDao {
    void setQuotes();
    List<Quote> getQuotes();
    List<Quote> getQuotesFromString(String innerContent);
}
