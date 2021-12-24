package com.shang.adapterPattern;

public class Adapter extends Source implements TargetAble {
    @Override
    public void method2() {
        System.out.println("targetTable method");
    }
}
