package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    @Test
    public void testAdd(){
        int a = 5;
        int b = 6;
        System.out.println(a+b);
    }
}
