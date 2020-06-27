package com.nicolay.work.dao;

import com.nicolay.work.dao.PointDao;
import com.nicolay.work.model.Point;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

/*
 *
 *@Data 26.06.2020
 *@autor Fedorov Yuri
 *@project work
 *
 */
@Repository
public class PointImpl implements PointDao {
    @PersistenceContext
    private EntityManager em;



    @Override
    public Point get() {
        Point point=em.createQuery(
                "SELECT u FROM Point u ", Point.class).getSingleResult();
        return point;
    }

    @Override
    public  Point merge(Point point1) {
        Point  point =em.createQuery(
                "SELECT u FROM Point u ", Point.class)
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .getSingleResult();
        point.setNumber(point.getNumber() + 1);
        return   em.merge(point);
    }

    @Override
    public void init() {


        if (em.createQuery(
                "SELECT u FROM Point u ", Point.class).getResultList().size()==0) {
            Point point = new Point();
            em.persist(point);
        }
    }
}
