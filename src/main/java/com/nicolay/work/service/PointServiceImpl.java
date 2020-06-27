package com.nicolay.work.service;
/*
 *
 *@Data 26.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */

import com.nicolay.work.dao.PointDao;
import com.nicolay.work.model.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PointServiceImpl implements PointService {
    private final PointDao pointDao;

    public PointServiceImpl(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    @Override
    @Transactional//(isolation = Isolation.READ_COMMITTED)
    public Point add() {
//        Point point = get();
//        point.setNumber(point.getNumber() + 1);
        Point point3=new Point();
        return pointDao.merge(point3);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void delete() {
        Point point = get();
        point.setNumber(0);
        pointDao.merge(point);
    }

    @Override
    @Transactional(readOnly = true)
    public Point get() {
        return pointDao.get();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void init() {
        pointDao.init();
    }
}
