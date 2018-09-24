package com.sj.demo;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

/**
 * Used in cases to remove external dependency like DB reads; files; web services etc.
 * ***/
public class TestDemoUsingMock {

    SimplestDemoOne utilMock;

   //format 2
    @Before
    public void setUp() throws Exception {
        utilMock = EasyMock.createNiceMock(SimplestDemoOne.class);
    }

    @After
    public void tearDown() throws Exception {
        utilMock = null;
    }

    @Test
    public void testSumTwiceUsingUtil()
    {
        System.out.println("inside test");
        expect(utilMock.sum(1,2)).andReturn(12).times(1);
        replay(utilMock);


        DemoUsingMock testedObj = new DemoUsingMock(utilMock);
        int result = testedObj.sumTwiceUsingUtil(1, 2);

        assertEquals("Invalid results found", 24, result);

        verify(utilMock);
    }
}