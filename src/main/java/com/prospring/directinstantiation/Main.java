package com.prospring.directinstantiation;

public class Main {
    public static void main(String[] args) {
        MessageProvider provider = new HelloWorldMessageProvider();
        MessageRenderer renderer = new StdoutMessageRenderer();
        renderer.setProvider(provider);
        renderer.render();
    }
}
