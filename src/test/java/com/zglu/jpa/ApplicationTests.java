package com.zglu.jpa;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

/**
 * @author zglu
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        String test = "test";
        Assert.notNull(test, "test must not be null!");
        log.info(test);
    }

}
