package com.dependency_injection.music.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RockMusic implements Music {

    @Override
    public String getLyrics() {
        return "Hello, how low?";
    }
}
