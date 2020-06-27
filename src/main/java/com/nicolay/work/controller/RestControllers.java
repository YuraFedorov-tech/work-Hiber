package com.nicolay.work.controller;

import com.nicolay.work.model.Point;
import com.nicolay.work.service.PointService;
import com.nicolay.work.utill.Run;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/*
 *
 *@Data 26.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */
@RestController
public class RestControllers {
    private final PointService pointService;

    public RestControllers(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("get")
    public ResponseEntity<Point> get() {
        return new ResponseEntity<>(pointService.get(), HttpStatus.OK);
    }

    // PostMapping("post")
    @GetMapping("post")
    public ResponseEntity<Point> post() {
        return new ResponseEntity<>(pointService.add(), HttpStatus.OK);
    }

    // DeleteMapping("delete")
    @GetMapping("delete")
    public String delete() {
        pointService.delete();
        return "delete, number = 0";
    }


    @GetMapping("cuncur")
    public String cuncur() {


        Thread thread = new Thread(new Run(pointService));
        Thread thread1 = new Thread(new Run(pointService));
        Thread thread2 = new Thread(new Run(pointService));
        Thread thread3 = new Thread(new Run(pointService));
        Thread thread4 = new Thread(new Run(pointService));

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

//        try {
//            Thread.currentThread().sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "cuncur";
    }

    private CountDownLatch latch = new CountDownLatch(999);
}
