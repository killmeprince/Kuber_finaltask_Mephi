package com.kmp.mephi.sentimentapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SentimentController {

    @GetMapping("/sentiment")
    public Map<String, String> analyze(@RequestParam String text) {
        String lower = text.toLowerCase(Locale.ROOT);

        String sentiment = "neutral";
        if (lower.contains("love") || lower.contains("good") || lower.contains("happy")) {
            sentiment = "positive";
        } else if (lower.contains("hate") || lower.contains("bad") || lower.contains("sad")) {
            sentiment = "negative";
        }

        Map<String, String> response = new HashMap<>();
        response.put("sentiment", sentiment);
        response.put("input", text);
        return response;
    }
}
