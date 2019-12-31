package com.sj.demo;

public class DemoUsingMock
{

/*    //pre implementation version1

    public DemoUsingMock() {
    }

    int sumTwiceUsingUtil(int a, int b)
    {
        return (new SimpleSum().sum(a, b))*2;
    }*/

    //post implementation

    private ISimpleSum util;

    public DemoUsingMock() {
        this(new SimpleSum());
    }

    //Dependency Injection 1
    DemoUsingMock(ISimpleSum util) {
        this.util = util;
    }

    //Option 1
    public int sumTwiceUsingUtil(int a, int b)
    {
        return (util.sum(a, b))*2;
    }

    //Option 2
    public int sumTwiceUsingUtilMethodMock(int a, int b)
    {
        return sumTwiceUsingUtilMethodMock(a,b, util);
    }

    //Dependency Injection 2  - ONLY FOR TESTING
    //@VisibleForTesting - guava annotation
    int sumTwiceUsingUtilMethodMock(int a, int b, ISimpleSum util)
    {
        return (util.sum(a, b))*2;
    }

}
