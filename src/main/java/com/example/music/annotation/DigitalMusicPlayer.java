package com.example.music.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DigitalMusicPlayer implements MusicPlayer {
    private final Music music;

    @Autowired
    public DigitalMusicPlayer(
            @Qualifier("rockMusic") Music music) {
        this.music = music;
    }

    @Override
    public Music getMusic() {
        return music;
    }

    @Override
    public void playMusic() {
        System.out.println(music.getLyrics());
    }
}
