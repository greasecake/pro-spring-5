package com.example.music.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.music.annotation");

        MusicPlayer digitalMusicPlayer1 = context.getBean("digitalMusicPlayer", MusicPlayer.class);
        digitalMusicPlayer1.playMusic();
        System.out.println(digitalMusicPlayer1.getMusic());

        MusicPlayer digitalMusicPlayer2 = context.getBean("digitalMusicPlayer", MusicPlayer.class);
        digitalMusicPlayer2.playMusic();
        System.out.println(digitalMusicPlayer2.getMusic());

        System.out.println("---");

        MusicPlayer vinylMusicPlayer1 = context.getBean("vinylMusicPlayer", MusicPlayer.class);
        vinylMusicPlayer1.playMusic();
        System.out.println(vinylMusicPlayer1.getMusic());

        MusicPlayer vinylMusicPlayer2 = context.getBean("vinylMusicPlayer", MusicPlayer.class);
        vinylMusicPlayer2.playMusic();
        System.out.println(vinylMusicPlayer2.getMusic());
    }
}
