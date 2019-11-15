package com.cbtuser.dao;

import com.cbtuser.entity.Normalquestion;
import com.cbtuser.entity.Nrmansquestion;
import com.cbtuser.entity.Subtestdatabase;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class NrmanquestionDaoImpl implements DaoService<Nrmansquestion>{

    @Override
    public int addData(Nrmansquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Nrmansquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Nrmansquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nrmansquestion> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nrmansquestion getOneData(Nrmansquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Nrmansquestion> getSpecificData(Normalquestion object1, Subtestdatabase object2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Nrmansquestion WHERE normalquestion_id= :id1 AND normalquestion_subtestdatabase_id= :id2");
        query.setParameter("id1", object1.getId().getId());
        query.setParameter("id2", object2.getId());
        List<Nrmansquestion> result = query.list();
        return result;
    }
    
}
