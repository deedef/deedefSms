package com.deedef.dao.Impl;

import com.deedef.bean.Profil;
import com.deedef.dao.IProfileMgr;
import com.sun.jersey.spi.inject.Inject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by Saliou on 04/08/2015.
 */

public class ProfileMgrImpl implements IProfileMgr, java.io.Serializable {

    @Inject
    SessionFactory sessionFactory;
    @Inject
    private HibernateTemplate hibernateTemplate;
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Profil profil) {
        // hibernateTemplate.save(profil);
        profil.setDateCreation(new Date());
        hibernateTemplate.saveOrUpdate(profil);
    }

    @Override
    public void put(Profil profil) {
        hibernateTemplate.saveOrUpdate(profil);
    }

    @Override
    public Profil get(String id) {
        return (Profil) hibernateTemplate.get(Profil.class.getSimpleName(), id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Profil get(BigInteger id) {
//        Query query = sessionFactory.openSession().createSQLQuery(
//                "select profil.id from utilisateurs profil where id = :stockCode")
//                .setParameter("stockCode", id);
//        List result = query.list();
//        return new Profil();
        // return (Profil) result.get(0);
//       List list;
//
        List list = hibernateTemplate.find(
                "from com.deedef.bean.Profil where id=?", id);
        if (list == null || list.isEmpty())
            return null;
        return (Profil) list.get(0);

    }

    @Override
    public Profil getByLogin(String login) {
        List list = hibernateTemplate.find("from com.deedef.bean.Profil where login=?", login);
        if (list == null || list.isEmpty())
            return null;
        return (Profil) list.get(0);
    }

    @Override
    public void delete(Profil profil) {
        hibernateTemplate.delete(profil);
    }

    @Override
    public List<Profil> getAllProfil() {

        List list = hibernateTemplate.find(
                "from com.deedef.bean.Profil");
        return list;
    }
}
