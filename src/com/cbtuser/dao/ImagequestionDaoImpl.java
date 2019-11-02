package com.cbtuser.dao;

import com.cbtuser.entity.Imagequestion;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class ImagequestionDaoImpl implements DaoService<Imagequestion> {

    @Override
    public int addData(Imagequestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Imagequestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Imagequestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imagequestion> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Imagequestion.class).setFetchMode("subtest", FetchMode.JOIN).setFetchMode("questiondb", FetchMode.JOIN);
        List<Imagequestion> imagequestions = criteria.list();
        session.close();
        return imagequestions;
    }

    @Override
    public Imagequestion getOneData(Imagequestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
