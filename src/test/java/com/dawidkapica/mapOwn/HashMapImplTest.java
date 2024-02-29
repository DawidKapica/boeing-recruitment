package com.dawidkapica.mapOwn;

import com.dawidkapica.mapOwn.util.StringObjectWithSameHC;
import org.junit.Assert;
import org.junit.Test;

public class HashMapImplTest {

    @Test
    public void putSingleValTest() {
        HashMapImpl<String, Integer> hashMap = new HashMapImpl<>();
        String key = "testKey";
        hashMap.put(key, 1);https://github.com/DawidKapica/boeing-recruitment

        Assert.assertEquals("expected size of bucket is different", 1, hashMap.getBucket(key).size());
        Assert.assertEquals(Integer.valueOf(1), hashMap.getBucket(key).getFirst().getValue());
    }

    @Test
    public void putTwoValTest() {
        HashMapImpl<String, Integer> hashMap = new HashMapImpl<>();
        String key1 = "testKey1";
        String key2 = "testKey2";
        hashMap.put(key1, 1);
        hashMap.put(key2, 2);

        Assert.assertEquals("expected size of bucket for first is different", 1, hashMap.getBucket(key1).size());
        Assert.assertEquals("expected size of bucket for second is different", 1, hashMap.getBucket(key2).size());

        Assert.assertEquals(Integer.valueOf(1), hashMap.getBucket(key1).getFirst().getValue());
        Assert.assertEquals(Integer.valueOf(2), hashMap.getBucket(key2).getFirst().getValue());
    }

    @Test
    public void putTwoValWithSameHashCodeTest() {
        HashMapImpl<StringObjectWithSameHC, Integer> hashMap = new HashMapImpl<>();
        StringObjectWithSameHC key1 = new StringObjectWithSameHC("key1");
        StringObjectWithSameHC key2 = new StringObjectWithSameHC("key2");
        hashMap.put(key1, 1);
        hashMap.put(key2, 2);

        Assert.assertEquals("expected size of bucket for first is different", 2, hashMap.getBucket(key1).size());
        Assert.assertEquals(Integer.valueOf(1), hashMap.getBucket(key1).getFirst().getValue());
        Assert.assertEquals(Integer.valueOf(2), hashMap.getBucket(key1).getLast().getValue());
    }

    @Test
    public void getValTest() {
        HashMapImpl<String, Integer> hashMap = new HashMapImpl<>();
        String key1 = "testKey1";
        hashMap.put(key1, 1);

        Assert.assertEquals(Integer.valueOf(1), hashMap.get(key1));
    }

    @Test
    public void operationForNotExistKey() {
        HashMapImpl<String, Integer> hashMap = new HashMapImpl<>();
        String key = "noExistKey";
        Assert.assertNull(hashMap.get(key));
        Assert.assertFalse(hashMap.remove(key));
    }

    @Test
    public void getAndRmTwoValWithSameHashCodeTest() {
        HashMapImpl<StringObjectWithSameHC, Integer> hashMap = new HashMapImpl<>();
        StringObjectWithSameHC key1 = new StringObjectWithSameHC("key1");
        StringObjectWithSameHC key2 = new StringObjectWithSameHC("key2");
        hashMap.put(key1, 1);
        hashMap.put(key2, 2);

        Assert.assertEquals(Integer.valueOf(1), hashMap.get(key1));
        Assert.assertEquals(Integer.valueOf(2), hashMap.get(key2));
    }

    @Test
    public void rmTwoValWithSameHashCodeTest() {
        HashMapImpl<StringObjectWithSameHC, Integer> hashMap = new HashMapImpl<>();
        StringObjectWithSameHC key1 = new StringObjectWithSameHC("key1");
        StringObjectWithSameHC key2 = new StringObjectWithSameHC("key2");
        hashMap.put(key1, 1);
        hashMap.put(key2, 2);

        hashMap.remove(key1);
        Assert.assertEquals("expected size of bucket for first is different", 1, hashMap.getBucket(key1).size());
        Assert.assertEquals(Integer.valueOf(2), hashMap.getBucket(key1).getFirst().getValue());
        Assert.assertNull(hashMap.get(key1));
    }
}
