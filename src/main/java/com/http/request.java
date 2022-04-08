package com.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class request {
public String response;


public HttpResponse<String> get() throws UnirestException {
    return Unirest.get("https://raw.githubusercontent.com/dwyl/english-words/master/words_dictionary.json")
            .asString();
}
}
