package com.nicolay.work.dao;
/*
 *
 *@Data 26.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */


import com.nicolay.work.model.Point;

public interface PointDao {
    Point merge(Point point);
    Point get();
    void init();

}
