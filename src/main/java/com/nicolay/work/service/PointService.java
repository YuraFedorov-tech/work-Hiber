package com.nicolay.work.service;

import com.nicolay.work.model.Point;

/*
 *
 *@Data 26.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */
public interface PointService {
    Point add();
    void delete();
    Point get();
    void init();

}
