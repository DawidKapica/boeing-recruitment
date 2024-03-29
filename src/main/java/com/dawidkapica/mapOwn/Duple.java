package com.dawidkapica.mapOwn;

import java.util.Objects;

public class Duple<T, E> {

    private T key;
    private E value;

    public Duple(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duple<?, ?> duple = (Duple<?, ?>) o;
        return Objects.equals(key, duple.key) && Objects.equals(value, duple.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
