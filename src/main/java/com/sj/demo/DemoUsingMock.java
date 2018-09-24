package com.sj.demo;

public class DemoUsingMock
{
    /*
    //version1
    int sumTwiceUsingUtil(int a, int b)
    {
        return (new SimplestDemoOne().sum(a, b))*2;
    }*/

    //post implementation

    private SimplestDemoOne util;

    public DemoUsingMock() {
    }

    //Dependency Injection 1
    public DemoUsingMock(SimplestDemoOne util) {
        this.util = util;
    }

    public int sumTwiceUsingUtil(int a, int b)
    {
        return sumTwiceUsingUtil(a,b, util);
    }

    //Dependency Injection 2  - ONLY FOR TESTING
    //@VisibleForTesting - guava annotation
    int sumTwiceUsingUtil(int a, int b, SimplestDemoOne util)
    {
        return (util.sum(a, b))*2;
    }

}
