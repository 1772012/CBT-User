package com.cbtuser.dao;

import com.cbtuser.entity.Test;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class TestDaoImpl implements DaoService <Test> {

    @Override
    public int addData(Test object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Test> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Test getOneData(Test object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Test WHERE token= :token");
        query.setParameter("token", object.getToken());
        Test result = (Test) query.uniqueResult();
        return result;
    }
    
}
