package com.benfogel.examplespringscope;

import org.springframework.stereotype.Component;

@Component
// Default scope is @Scope(scopeName="singleton")
public class IncorrectScopeBean {

    private String requestId;

    public String run(String requestId) throws InterruptedException {
        this.requestId = requestId;

        Thread.sleep(5000);

        return this.requestId;
    }
}
