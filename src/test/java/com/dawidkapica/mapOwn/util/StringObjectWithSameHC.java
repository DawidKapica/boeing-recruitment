package com.dawidkapica.mapOwn.util;

import java.util.Objects;

public class StringObjectWithSameHC {
    private String value;

    public StringObjectWithSameHC(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringObjectWithSameHC that = (StringObjectWithSameHC) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
