package com.shang.factoryPattern;

/**
 * 简单工厂方法
 * @author 10699518
 */
public class SenderFactory {
    public <T extends Sender> T produce(Class<T> c) {
        if (c == null) {
            return null;
        }
        T result;
        try {
            result = c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
