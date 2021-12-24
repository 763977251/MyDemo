package com.shang.compositePattern;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        Tree tree = new Tree("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");

        b.add(c);
        tree.root.add(b);
        System.out.println("build the tree finished!");

    }
}
