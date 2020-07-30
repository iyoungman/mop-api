package com.iyoungman.mop.api.core.redis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.io.Serializable;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-28.
 */

@SpringBootTest
@Transactional
public class RedisConnectionTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    @DisplayName("Redis Connection 확인")
    public void connectionTest() {
        boolean result = redisUtils.isConnected();

        assertTrue("test", result);
    }

    @Test
    @DisplayName("Redis Save 확인")
    public void saveTest() {
        String key = "testkey";

        redisUtils.toCache(key, new TestObject("one", "two"));

        TestObject test = (TestObject) redisUtils.fromCache(key);
        assertEquals("one", test.getOne());
        assertEquals("two", test.getTwo());
    }

    @Getter
    class TestObject implements Serializable {

        private String one;

        private String two;

        public TestObject(String one, String two) {
            this.one = one;
            this.two = two;
        }
    }
}
