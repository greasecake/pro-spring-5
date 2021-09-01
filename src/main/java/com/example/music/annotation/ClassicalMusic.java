package com.example.music.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClassicalMusic implements Music {

    @Override
    public String getLyrics() {
        return "Cantate domino";
    }
}

