package com.shang.adapterPattern;

import org.junit.jupiter.api.Test;

public class AdapterTest {
    @Test
    public void test() {
        TargetAble targetTable = new Adapter();
        targetTable.method1();
        targetTable.method2();
    }

    @Test
    public void test2() {
        Source source = new Source();
        TargetAble targetTable = new Wrapper(source);
        targetTable.method1();
        targetTable.method2();
    }

    @Test
    public void test3(){
        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();
        sourceSub1.method1();
        sourceSub1.method2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}
