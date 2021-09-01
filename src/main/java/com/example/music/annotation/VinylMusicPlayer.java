package com.example.music.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class VinylMusicPlayer implements MusicPlayer {
    private final Music music;

    @Autowired
    public VinylMusicPlayer(
            @Qualifier("classicalMusic") Music music) {
        this.music = music;
    }

    @Override
    public Music getMusic() {
        return music;
    }

    @Override
    public void playMusic() {
        StringBuilder noisyMusic = new StringBuilder();
        music.getLyrics().chars().forEach(c -> {
            noisyMusic.append((Math.random() < 0.75) ? (char) c : ".");
        });
        System.out.println(noisyMusic);
    }
}
