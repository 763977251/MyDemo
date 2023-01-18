package com.shang.singletonPattern;

/**
 * 静态内部类方式实现单例模式
 *
 * @author 10699518
 */
public class Singleton2 {

    private Singleton2() {
    }

    /**
     * 不调用方法的时候，实例未创建。
     * 调用方法的时候才创建实例，线程安全
     */
    public static Singleton2 getInstance() {
        return SingletonFactory.INSTANCE;
    }

    private static class SingletonFactory {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    /**
     * 防止反序列化创建多个不同实例
     */
    public Object readResolve() {
        return SingletonFactory.INSTANCE;
    }
}
