package com.cbtuser.dao;

import com.cbtuser.entity.Normalquestion;
import com.cbtuser.entity.Subtestdatabase;
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
public class NormalquestionDaoImpl implements DaoService<Normalquestion>{

    @Override
    public int addData(Normalquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Normalquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Normalquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Normalquestion> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Normalquestion.class).setFetchMode("subtest", FetchMode.JOIN).setFetchMode("questiondb", FetchMode.JOIN);
        List<Normalquestion> normalquestions = criteria.list();
        session.close();
        return normalquestions;
    }

    @Override
    public Normalquestion getOneData(Normalquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Normalquestion> getSpecificData(Subtestdatabase object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Normalquestion WHERE subtestdatabase_id= :id");
        query.setParameter("id", object.getId());
        List<Normalquestion> result = query.list();
        return result;
    }
    
}
