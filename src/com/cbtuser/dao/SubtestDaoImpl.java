package com.cbtuser.dao;

import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Test;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class SubtestDaoImpl implements DaoService<Subtest> {

    @Override
    public int addData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subtest> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Subtest.class).setFetchMode("test", FetchMode.JOIN);
        List<Subtest> subtests = criteria.list();
        session.close();
        return subtests;
    }
    
    public List<Subtest> getSpecificSubtest(Test object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subtest where test_id = :id");
        query.setParameter("id", object.getId());
        List<Subtest> result = query.list();
        return result;
    }

    @Override
    public Subtest getOneData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
