package com.shang.singletonPattern;

/**
 * 双检锁方式实现单例模式
 * <p>
 * instance实例的volatile必不可少，volatile关键字可以防止jvm指令重排优化
 * 因为 singleton = new Singleton() 这句话可以分为三步：
 *      1. 为 singleton 分配内存空间；
 *      2. 初始化 singleton；
 *      3. 将 singleton 指向分配的内存空间。
 *      但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。 指令重排在单线程下不会出现问题，但是在多线程下会导致一个线程获得一个未初始化的实例。
 *      例如：线程T1执行了1和3，此时T2调用 getInstance() 后发现 singleton 不为空，因此返回 singleton， 但是此时的 singleton 还没有被初始化。
 *      使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
 * </p>
 * @author 10699518
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 防止反序列化创建多个不同实例
     */
    public Object readResolve() { //防止反序列化创建多个实例
        return instance;
    }
}
