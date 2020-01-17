package com.cbt.dao;

import com.cbt.entity.Participant;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Kafka Febianto Agiharta - 1772012
 */
public class ParticipantDaoImpl implements DaoService<Participant> {

    @Override
    public int addData(Participant object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Participant> getAllData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Participant getOneData(Participant object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "FROM Participant WHERE username= :user AND password= :pass");
        query.setParameter("user", object.getUsername());
        query.setParameter("pass", object.getPassword());
        Participant result = (Participant) query.uniqueResult();
        return result;
    }

}
