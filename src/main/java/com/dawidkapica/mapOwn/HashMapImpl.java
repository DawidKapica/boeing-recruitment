package com.dawidkapica.mapOwn;

import java.util.List;

public class HashMapImpl<T, E> {

    private HashMapBucket<T, E>[] buckets;

    private static final int bucketSize = 100;

    public HashMapImpl() {
        buckets = new HashMapBucket[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new HashMapBucket<>();
        }
    }

    public void put(T key, E value) {
        int index = getBucket(key).indexOf(new Duple<>(key, value));
        if (index != -1)
            getBucket(key).remove(index);

        getBucket(key).add(new Duple<>(key, value));
    }

    public E get(T key) {
        Duple<T, E> duple = getBucket(key).stream().filter(d -> d.getKey().equals(key)).findFirst().orElse(null);
        return duple != null ? duple.getValue() : null;
    }

    public boolean remove(T key) {
        Duple dupleToRm = getBucket(key).stream().filter(duple -> duple.getKey().equals(key)).findFirst().orElse(null);
        if (dupleToRm != null) {
            getBucket(key).remove(dupleToRm);
            return true;
        }
        return false;
    }

    // package modifier for tests
    List<Duple<T, E>> getBucket(T key) {
        int indexOfBucket = getIndexOfBucket(key);
        return buckets[indexOfBucket].getBucket();
    }

    private int getIndexOfBucket(T key) {
        int hashCodeForKey = Math.abs(key.hashCode());
        return hashCodeForKey % bucketSize;
    }
}
