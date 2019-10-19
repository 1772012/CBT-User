package com.cbtuser.dao;

import com.cbtuser.entity.Test;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class TestDaoImpl implements DaoService<Test>{

    @Override
    public int addData(Test object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Test object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Test object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Test> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Test.class).setFetchMode("questionmaker", FetchMode.JOIN);
        List<Test> tests = criteria.list();
        session.close();
        return tests;
    }
    
}
