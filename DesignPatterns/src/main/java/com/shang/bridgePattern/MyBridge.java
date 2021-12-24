package com.shang.bridgePattern;

public class MyBridge extends Bridge{
    @Override
    public void method(){
        getSource().method();
    }
}
