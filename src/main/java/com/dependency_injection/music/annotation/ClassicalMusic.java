package com.dependency_injection.music.annotation;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class ClassicalMusic implements Music {

    @Override
    public String getLyrics() {
        return "Cantate domino";
    }
}

