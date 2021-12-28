package com.shang.iteratorPattern;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
