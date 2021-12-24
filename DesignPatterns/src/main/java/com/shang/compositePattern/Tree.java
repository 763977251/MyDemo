package com.shang.compositePattern;

public class Tree {
    TreeNode root = null;

    public Tree(String name){
        root = new TreeNode(name);
    }
}
