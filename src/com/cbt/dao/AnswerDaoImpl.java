package com.cbt.dao;

import com.cbt.entity.Answer;
import com.cbt.entity.Question;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Kafka Febianto Agiharta - 1772012
 */
public class AnswerDaoImpl implements DaoService<Answer> {

    @Override
    public int addData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Answer> getAllData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Answer getOneData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Answer> getSpecificData(Question object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "from Answer where question_id = :id order by rand()");
        query.setParameter("id", object.getId());
        List<Answer> result = query.list();
        return result;
    }
}
