package com.cbtuser.dao;

import com.cbtuser.entity.Answer;
import com.cbtuser.entity.Question;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class AnswerDaoImpl implements DaoService <Answer> {

    @Override
    public int addData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Answer> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer getOneData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Answer> getSpecificData(Question object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Answer where question_id = :id");
        query.setParameter("id", object.getId());
        List<Answer> result = query.list();
        return result;
    }
    
}
