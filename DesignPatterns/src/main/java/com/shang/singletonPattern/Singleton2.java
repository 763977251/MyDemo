package com.shang.singletonPattern;

public class Singleton2 {

    private Singleton2(){
    }

    public static Singleton2 getInstance() {
        return SingletonFactory.instance;
    }

    private static class SingletonFactory {
        private static Singleton2 instance = new Singleton2();
    }

    public Object readResolve(){ //防止反序列化创建多个实例
        return SingletonFactory.instance;
    }
}
