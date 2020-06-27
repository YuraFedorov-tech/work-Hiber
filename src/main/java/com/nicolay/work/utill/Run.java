package com.nicolay.work.utill;

import com.nicolay.work.controller.RestControllers;
import com.nicolay.work.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 *
 *@Data 27.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */
public class Run implements Runnable
{

    PointService pointService;

    public Run(PointService pointService) {
        this.pointService = pointService;
    }
//szdf
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 3000; i++)
            pointService.add();
    }
//    private CountDownLatch latch;
//    private int j;
//    private int countThread;
//    @Autowired
//    PointService pointService;
//
//    public Run(CountDownLatch latch, int j){
//        this.latch=latch;
//        this.j=j;
//    }
//
//    @Override
//    public void run() {
//        try {
//            countThread++;
//            latch.await();
//            System.out.println(countThread);
//            throw new IllegalArgumentException();
//               // pointService.add();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
}
