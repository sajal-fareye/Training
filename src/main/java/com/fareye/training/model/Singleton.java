package com.fareye.training.model;

public class Singleton {
//    private static volatile Singleton obj  = null;
//
//    private Singleton() {}

//    public static Singleton getInstance()
//    {
//        if (obj == null)
//        {
//            // To make thread safe
//            synchronized (Singleton.class)
//            {
//                // check again as multiple threads
//                // can reach above step
//                if (obj==null)
//                    obj = new Singleton();
//            }
//        }
//        return obj;
//    }


//    private static Singleton obj;
//
//    // private constructor to force use of
//    // getInstance() to create Singleton object
//    private Singleton() {}
//
//    public static Singleton getInstance()
//    {
//        if (obj==null)
//            obj = new Singleton();
//        return obj;
//    }


//    private static Singleton obj;
//
//    private Singleton() {}
//
//    // Only one thread can execute this at a time
//    public static synchronized Singleton getInstance()
//    {
//        if (obj==null)
//            obj = new Singleton();
//        return obj;
//    }



}
