package com.shang.visitorPattern;

public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
