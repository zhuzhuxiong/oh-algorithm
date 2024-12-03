package com.labula.linked.lru;

import java.util.LinkedHashMap;

/**
 *
 * @author zz
 */
public class No1Code146 {

    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public No1Code146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return cache.get(key);
    }

    private void makeRecent(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        if (cache.size() >= capacity) {
            Integer oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    }

    public int getPractice(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        recentPrac(key);
        return cache.get(key);
    }

    private void recentPrac(int key) {
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public void putPractice(int key, int value) {
        if (cache.containsKey(key)) {
            recentPrac(key);
            cache.put(key, value);
            return;
        }
        if (cache.size() == capacity) {
            Integer old = cache.keySet().iterator().next();
            cache.remove(old);
        }
        cache.put(key, value);
    }
}
