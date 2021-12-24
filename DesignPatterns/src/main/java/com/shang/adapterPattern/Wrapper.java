package com.shang.adapterPattern;

public class Wrapper implements TargetAble{

    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
