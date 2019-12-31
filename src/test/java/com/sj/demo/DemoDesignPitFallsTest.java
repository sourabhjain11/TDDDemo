package com.sj.demo;

import com.sj.demo.DemoDesignPitFalls.DemoClassWithStaticMethods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoClassWithStaticMethods.class)
public class DemoDesignPitFallsTest {

    @Test
    public void exponential() {
        assertEquals("Wrong exponential result", Math.E*Math.E, new DemoDesignPitFalls().exponential(2), 0.001);
    }

    @Test
    public void testStaticMock() {
        PowerMockito.mockStatic(DemoClassWithStaticMethods.class);
        when(DemoClassWithStaticMethods.exp(2)).thenReturn(100.0);
        when(DemoClassWithStaticMethods.exp(2)).thenReturn(Math.exp(2));



        assertEquals("Wrong exponential result", Math.E*Math.E, new DemoDesignPitFalls().exponential(2), 0.001);

        PowerMockito.verifyStatic(DemoClassWithStaticMethods.class, atLeast(2));
        DemoClassWithStaticMethods.exp(2);

    }
}