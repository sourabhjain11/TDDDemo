package com.sj.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSimplestDemoOne {

    @Test
    public void sum() {

        SimplestDemoOne testedObj = new SimplestDemoOne();
        int result = testedObj.sum(1, 2);
        assertEquals("Found incorrect sum result. ", 3, result);
    }
}