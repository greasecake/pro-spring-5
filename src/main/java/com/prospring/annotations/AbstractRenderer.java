package com.prospring.annotations;

import com.prospring.directinstantiation.MessageProvider;
import com.prospring.directinstantiation.MessageRenderer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("renderer")
public abstract class AbstractRenderer implements MessageRenderer {
    @Lookup("provider")
    public MessageProvider getProvider() {
        return null;
    }
}
