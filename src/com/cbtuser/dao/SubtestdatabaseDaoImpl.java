/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbtuser.dao;

import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Subtestdatabase;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class SubtestdatabaseDaoImpl implements DaoService<Subtestdatabase> {

    @Override
    public int addData(Subtestdatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Subtestdatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Subtestdatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subtestdatabase> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subtestdatabase getOneData(Subtestdatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Subtestdatabase getSpecificOneData(Subtest object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Subtestdatabase WHERE id= :id");
        query.setParameter("id", object.getSubtestdatabase().getId());
        Subtestdatabase result = (Subtestdatabase) query.uniqueResult();
        return result;
    }
}
