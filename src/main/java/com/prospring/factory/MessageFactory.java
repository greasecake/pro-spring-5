package com.prospring.factory;

import com.prospring.directinstantiation.MessageProvider;
import com.prospring.directinstantiation.MessageRenderer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MessageFactory {
    private static final MessageFactory instance;

    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageFactory() {
        Properties properties = new Properties();
        try {
            InputStream is = MessageFactory.class.getResourceAsStream("/message.properties");
            properties.load(is);
            String rendererClassName = properties.getProperty("renderer.class");
            String providerClassName = properties.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClassName).newInstance();
            provider = (MessageProvider) Class.forName(providerClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageFactory();
    }

    public static MessageFactory getInstance() {
        return instance;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
