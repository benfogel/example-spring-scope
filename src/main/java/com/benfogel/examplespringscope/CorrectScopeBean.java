package com.benfogel.examplespringscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CorrectScopeBean {

    private String requestId;

    public String run(String requestId) throws InterruptedException {
        this.requestId = requestId;

        Thread.sleep(5000);

        return this.requestId;
    }
}
