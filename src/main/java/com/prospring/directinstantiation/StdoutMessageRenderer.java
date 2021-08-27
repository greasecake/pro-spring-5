package com.prospring.directinstantiation;

import org.springframework.beans.factory.annotation.Lookup;

public class StdoutMessageRenderer implements MessageRenderer {
    public MessageProvider provider;

    public StdoutMessageRenderer() {}

    public StdoutMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void setProvider(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public MessageProvider getProvider() {
        return provider;
    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }
}
