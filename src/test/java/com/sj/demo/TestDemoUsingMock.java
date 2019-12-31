package com.sj.demo;

import org.easymock.EasyMock;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Used in cases to remove external dependency like DB reads; files; web services etc.
 * ***/
public class TestDemoUsingMock {

    @Test
    public void testSumTwiceUsingUtilInstance()
    {
        ISimpleSum utilMock = createUtilMock();
        System.out.println("inside test");
        expect(utilMock.sum(1,2)).andReturn(12).times(1);
        replay(utilMock);


        DemoUsingMock testedObj = new DemoUsingMock(utilMock);
        int result = testedObj.sumTwiceUsingUtil(1, 2);

        assertEquals("Invalid results found", 24, result);

        verify(utilMock);
    }

    @Test
    public void testSumTwiceUsingUtilMethodMock()
    {
        ISimpleSum utilMock = createUtilMock();
        System.out.println("inside test Method Mock");
        expect(utilMock.sum(1,2)).andReturn(12).times(1);
        replay(utilMock);


        DemoUsingMock testedObj = new DemoUsingMock();
        int result = testedObj.sumTwiceUsingUtilMethodMock(1, 2, utilMock);

        assertEquals("Invalid results found", 24, result);

        verify(utilMock);
    }


    private ISimpleSum createUtilMock() {
        return EasyMock.createNiceMock(ISimpleSum.class);
    }
}