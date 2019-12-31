package com.sj.demo;

public class DemoDesignPitFalls
{
    //Use of Static - How to mock and inject
    public double exponential(int a)
    {
        DemoClassWithStaticMethods.exp(a);
        return DemoClassWithStaticMethods.exp(a);
    }

    //

    public static class DemoClassWithStaticMethods
    {
        public static double exp(int a)
        {
            return Math.exp(a);
        }
    }
}
