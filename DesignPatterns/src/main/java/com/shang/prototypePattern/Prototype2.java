package com.shang.prototypePattern;

public class Prototype2 implements Cloneable{

    public Object clone() throws CloneNotSupportedException {
        Prototype2 prototype = (Prototype2) super.clone();
        return prototype;
    }
}
