package com.sj.demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSimpleSumComplex {

    @Test
    public void sum() {

        ISimpleSum testedObj = new SimpleSumComplex();
        int result = testedObj.sum(1, 2);
        assertEquals("Found incorrect sum result. ", 3, result);
    }
}