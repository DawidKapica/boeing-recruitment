package com.dawidkapica.mapOwn;

import java.util.ArrayList;
import java.util.List;

public class HashMapImpl<T, E> {

    private final List<Duple<T, E>>[] buckets;

    private static final int bucketSize = 100;

    public HashMapImpl() {
        buckets = new List[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(T key, E value) {
        remove(key);
        getBucket(key).add(new Duple<>(key, value));
    }

    public E get(T key) {
        return getBucket(key).stream().filter(d -> d.getKey().equals(key)).findFirst().map(Duple::getValue).orElse(null);
    }

    public boolean remove(T key) {
        return getBucket(key).removeIf(duple -> duple.getKey().equals(key));
    }

    // package modifier for tests
    List<Duple<T, E>> getBucket(T key) {
        return buckets[getIndexOfBucket(key)];
    }

    private int getIndexOfBucket(T key) {
        int hashCodeForKey = Math.abs(key.hashCode());
        return hashCodeForKey % bucketSize;
    }
}
