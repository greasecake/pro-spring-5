package com.prospring.annotations;

import com.prospring.directinstantiation.HelloWorldMessageProvider;
import com.prospring.directinstantiation.MessageProvider;
import com.prospring.directinstantiation.MessageRenderer;
import com.prospring.directinstantiation.StdoutMessageRenderer;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    @Scope("singleton")
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StdoutMessageRenderer();
        renderer.setProvider(provider());
        return renderer;
    }
}
