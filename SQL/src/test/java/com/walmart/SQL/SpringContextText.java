package com.walmart.SQL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SqlApplication.class)
public class SpringContextText {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
