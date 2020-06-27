package com.nicolay.work;

import com.nicolay.work.service.PointService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("com")
@EnableTransactionManagement
public class WorkApplication {
    private final PointService pointService;

    public WorkApplication(PointService pointService) {
        this.pointService = pointService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);

    }
    @PostConstruct
    public void init() {
        pointService.init();
    }
}
