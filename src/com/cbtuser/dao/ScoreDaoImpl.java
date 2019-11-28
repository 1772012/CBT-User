package com.cbtuser.dao;

import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Score;
import com.cbtuser.entity.Test;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Redwolfer
 */
public class ScoreDaoImpl implements DaoService <Score> {

    @Override
    public int addData(Score object) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Score> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Score getOneData(Score object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int updateData(Score object) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }
    
    public Score getOneSpecificData(Participant obj1, Test obj2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Score WHERE test_id= :test AND participant_id= :id");
        query.setParameter("id", obj1.getId());
        query.setParameter("test", obj2.getId());
        Score result = (Score) query.uniqueResult();
        return result;
    }
    
}
