package com.prospring.directinstantiation;

public class Main {
    public static void main(String[] args) {
        MessageRenderer renderer = new StdoutMessageRenderer(new HelloWorldMessageProvider());
        renderer.render();
    }
}
