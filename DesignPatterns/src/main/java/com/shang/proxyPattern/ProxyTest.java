package com.shang.proxyPattern;

import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void test(){
        Sourceable proxy = new Proxy();
        proxy.method();
    }
}
