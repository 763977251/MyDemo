package com.shang.facadePattern;

import org.junit.jupiter.api.Test;

public class FacadeTest {
    @Test
    public void test() {
        Computer computer = new Computer();
        computer.startup();
        System.out.println("============");
        computer.shutdown();
    }
}
