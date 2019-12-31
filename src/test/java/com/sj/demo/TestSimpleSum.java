package com.sj.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSimpleSum {

    @Test
    public void sum() {

        SimpleSum testedObj = new SimpleSum();
        int result = testedObj.sum(1, 2);
        assertEquals("Found incorrect sum result. ", 3, result);
    }
}