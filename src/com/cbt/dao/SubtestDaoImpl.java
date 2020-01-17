package com.cbt.dao;

import com.cbt.entity.Subtest;
import com.cbt.entity.Test;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Kafka Febianto Agiharta - 1772012
 */
public class SubtestDaoImpl implements DaoService<Subtest> {

    @Override
    public int addData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Subtest> getAllData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Subtest getOneData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Subtest> getSpecificData(Test object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subtest where test_id = :id");
        query.setParameter("id", object.getId());
        List<Subtest> result = query.list();
        return result;
    }
}
