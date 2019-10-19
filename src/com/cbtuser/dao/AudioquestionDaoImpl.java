package com.cbtuser.dao;

import com.cbtuser.entity.Audioquestion;
import com.cbtuser.entity.Normalquestion;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class AudioquestionDaoImpl implements DaoService<Audioquestion> {

    @Override
    public int addData(Audioquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Audioquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Audioquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Audioquestion> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Audioquestion.class).setFetchMode("subtest", FetchMode.JOIN).setFetchMode("questiondb", FetchMode.JOIN);
        List<Audioquestion> audioquestions = criteria.list();
        session.close();
        return audioquestions;
    }

}
