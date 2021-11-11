package com.shang.demo.leetCodeTest;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(3);
        lruCache1.put(1,1);
        lruCache1.put(2,2);
        lruCache1.put(2,2);
        lruCache1.put(3,3);
        lruCache1.put(3,3);
        lruCache1.put(2,2);
        lruCache1.put(4,4);
        lruCache1.put(1,1);

    }
}
