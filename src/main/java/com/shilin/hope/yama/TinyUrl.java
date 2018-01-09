package com.shilin.hope.yama;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private char[] base36 = new char[36];

    public TinyUrl() {
        for (int i = 0; i < 10; i++) {
            base36[i] = (char) ('0' + i);
        }
        for (int i = 0; i < 26; i++) {
            base36[i + 10] = (char) ('a' + i);
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        int decimal = longToShort.size();
        StringBuilder sb = new StringBuilder();
        while (decimal != 0) {
            sb.insert(0, base36[decimal % 36]);
            decimal = decimal / 36;
        }
        shortToLong.put(sb.toString(), longUrl);
        longToShort.put(longUrl, sb.toString());
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}
