package com.shang.biuilderPattern;

import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    public void test(){
        Builder builder = new Builder();
        builder.produceMailSender(3);
    }
}
