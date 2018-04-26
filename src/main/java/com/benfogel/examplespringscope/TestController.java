package com.benfogel.examplespringscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
public class TestController {

    @Autowired
    private CorrectScopeBean correctScopeBean;

    @Autowired
    private IncorrectScopeBean incorrectScopeBean;

    @GetMapping("/correct")
    public String callCorrectScopeField(@RequestParam String requestId) throws InterruptedException {
        return correctScopeBean.run(requestId);
    }

    @GetMapping("/incorrect")
    public String callIncorrectScopeField(@RequestParam String requestId) throws InterruptedException {
        return incorrectScopeBean.run(requestId);
    }
}
