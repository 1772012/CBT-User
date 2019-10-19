package com.cbtuser.dao;

import com.cbtuser.entity.Normalquestion;
import com.cbtuser.entity.Videoquestion;
import com.cbtuser.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

/**
 *
 * @author Redwolfer
 */
public class VideoquestionDaoImpl implements DaoService<Videoquestion>{

    @Override
    public int addData(Videoquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Videoquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Videoquestion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Videoquestion> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Videoquestion.class).setFetchMode("subtest", FetchMode.JOIN).setFetchMode("questiondb", FetchMode.JOIN);
        List<Videoquestion> videoquestions = criteria.list();
        session.close();
        return videoquestions;
    }
    
}
