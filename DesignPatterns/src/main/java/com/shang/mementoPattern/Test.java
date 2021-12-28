package com.shang.mementoPattern;

public class Test {
    public static void main(String[] args) {

        // 创建原始类
        Original ori = new Original("egg");

        // 创建备忘录
        Storage storage = new Storage(ori.createMemento());

        // 修改原始类的状态
        System.out.println("初始化状态为：" + ori.getValue());
        ori.setValue("niu");
        System.out.println("修改后的状态为：" + ori.getValue());

        // 回复原始类的状态
        ori.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + ori.getValue());
    }
}
