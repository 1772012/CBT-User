package com.cbtuser.dao;

import com.cbtuser.entity.Coursedatabase;
import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Test;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
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
    public List<Subtest> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subtest getOneData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
