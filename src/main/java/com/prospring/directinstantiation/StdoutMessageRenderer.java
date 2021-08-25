package com.prospring.directinstantiation;

public class StdoutMessageRenderer implements MessageRenderer {
    public MessageProvider provider;

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
