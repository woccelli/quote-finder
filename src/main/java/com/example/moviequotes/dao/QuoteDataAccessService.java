package com.example.moviequotes.dao;

import com.example.moviequotes.model.Quote;
import com.example.moviequotes.datasource.cite_de_la_peur;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.io.IOException;
import java.util.regex.Pattern;

@Repository("citedelapeur")
public class QuoteDataAccessService implements QuoteDao {
    private static List<Quote> DB = new ArrayList<>();

    @PostConstruct
    public void setQuotes()  {
        Document doc = Jsoup.parse(cite_de_la_peur.script);
        Elements quoteElems = doc.select("div > div > p");
        for (Element qElement : quoteElems) {
            Quote quote = new Quote(UUID.randomUUID(), qElement.toString());
            DB.add(quote);
        }
    }


    @Override
    public List<Quote> getQuotes() {
        return DB;
    }

    @Override
    public List<Quote> getQuotesFromString(String innerContent) {
        List<Quote> res = new ArrayList<>();
        for (Quote q : DB) {
           // if (q.getContent().contains(innerContent)) {
            if (Pattern.compile(Pattern.quote(innerContent), Pattern.CASE_INSENSITIVE).matcher(q.getContent()).find()) {
                res.add(q);
            }
        }
        return res;
    }
}
