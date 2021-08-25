package com.prospring.directinstantiation;

public interface MessageRenderer {
    void setProvider(MessageProvider messageProvider);
    MessageProvider getProvider();
    void render();
}
