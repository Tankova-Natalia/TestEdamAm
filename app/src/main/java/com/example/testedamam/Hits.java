package com.example.testedamam;

import java.util.Arrays;

public class Hits {
    String q;
    Hit[] hits;

    @Override
    public String toString() {
        return "Hits{" +
                "q='" + q + '\'' +
                ", hits=" + Arrays.toString(hits) +
                '}';
    }
}

