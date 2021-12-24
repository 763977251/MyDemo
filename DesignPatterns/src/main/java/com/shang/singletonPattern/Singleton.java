package com.shang.singletonPattern;

public class Singleton {
    private static Singleton instance = null;

    private Singleton(){
    }

    public static Singleton getInstance() {
        if (instance == null){
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve(){ //防止反序列化创建多个实例
        return instance;
    }
}
