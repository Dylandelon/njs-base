package com.njs.basecore.myBeans;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TreadStatusTest
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(4, 4,1,TimeUnit.MINUTES, new LinkedBlockingDeque<>(30),new ThreadPoolExecutor.CallerRunsPolicy());

        StaticThread staticThread = new StaticThread(null);
        StaticThread staticThread2 = new StaticThread("222");
        StaticThread staticThread3 = new StaticThread("3333");
        Future<?> future1  = threadPoolExecutor.submit(staticThread);
        System.out.println(future1);
        threadPoolExecutor.submit(staticThread2);
        threadPoolExecutor.submit(staticThread3);

    }
}
