package com.shang.decoratorPattern;

public class Decorator implements Sourceable{

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before");
        source.method();
        System.out.println("after");
    }
}
