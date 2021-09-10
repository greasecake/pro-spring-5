package com.dependency_injection.music.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DigitalMusicPlayer implements MusicPlayer {
    @Autowired
    @Qualifier("rockMusic")
    private Music music;

    public DigitalMusicPlayer() {}

    @Autowired
    public DigitalMusicPlayer(
            @Qualifier("rockMusic") Music music) {
        this.music = music;
    }

    @Autowired
    @Qualifier("rockMusic")
    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    @Lookup("rockMusic")
    public Music getMusic() {
        return music;
    }

    @Override
    public void playMusic() {
        System.out.println(music.getLyrics());
    }
}
