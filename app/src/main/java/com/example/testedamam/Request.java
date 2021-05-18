package com.example.testedamam;

import java.net.URLEncoder;

public class Request {
    String search_text;
    String app_id;
    String app_key;

    public Request(String text) {
        this.search_text = text;
    }

    public String formDataToString() {
        //q=rice&app_id=&app_key=
        return "q="+ URLEncoder.encode(search_text) +"&app_id="+app_id+"&app_key="+app_key;
    }
}
