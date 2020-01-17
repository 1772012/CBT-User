package com.cbt.dao;

import com.cbt.entity.Question;
import com.cbt.entity.Subtest;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Kafka Febianto Agiharta - 1772012
 */
public class QuestionDaoImpl implements DaoService<Question> {

    @Override
    public int addData(Question object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Question> getAllData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Question getOneData(Question object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Question> getSpecificData(Subtest object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (object.getCoursedatabase().getEnableShuffle() == 1) {
            Query query = session.createQuery(
                    "from Question where coursedatabase_id = :id order by rand()");
            query.setParameter("id", object.getCoursedatabase().getId());
            query.setMaxResults(object.getAmount());
            List<Question> result = query.list();
            return result;
        } else {
            Query query = session.createQuery(
                    "from Question where coursedatabase_id = :id");
            query.setParameter("id", object.getCoursedatabase().getId());
            query.setMaxResults(object.getAmount());
            List<Question> result = query.list();
            return result;
        }
    }
}
