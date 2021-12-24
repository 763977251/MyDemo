package com.shang.decoratorPattern;

import org.junit.jupiter.api.Test;

public class DecoratorTest {
    @Test
    public void test(){
        Decorator decorator = new Decorator(new Source());
        decorator.method();
    }
}
