package com.prospring.factory;

import com.prospring.directinstantiation.MessageProvider;
import com.prospring.directinstantiation.MessageRenderer;

public class Main {
    public static void main(String[] args) {
        MessageRenderer renderer = MessageFactory.getInstance().getRenderer();
        MessageProvider provider = MessageFactory.getInstance().getProvider();
        renderer.setProvider(provider);
        renderer.render();
    }
}
