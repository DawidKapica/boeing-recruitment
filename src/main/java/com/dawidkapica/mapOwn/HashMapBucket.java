package com.dawidkapica.mapOwn;

import java.util.ArrayList;
import java.util.List;

public class HashMapBucket<T, E> {

    private List<Duple<T, E>> bucket;

    public HashMapBucket() {
        bucket = new ArrayList<>();
    }

    public List<Duple<T, E>> getBucket() {
        return bucket;
    }
}
