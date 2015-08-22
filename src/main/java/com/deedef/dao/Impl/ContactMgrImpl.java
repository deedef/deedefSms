package com.deedef.dao.Impl;

import com.deedef.bean.Contact;
import com.deedef.dao.IContactMgr;
import com.sun.jersey.spi.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by S2D on 8/20/15.
 */

public class ContactMgrImpl implements IContactMgr, java.io.Serializable{

    @Inject
    SessionFactory sessionFactory;
    @Inject
    private HibernateTemplate hibernateTemplate;
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Contact contact) {
        hibernateTemplate.saveOrUpdate(contact);
    }

    @Override
    public Contact getContactByEmailFromUser(BigInteger userId, String email) {
        List list = hibernateTemplate.find(
                "from com.deedef.bean.Contact where idutilisateur=? and emailcontact=?", userId, email);
        if (list == null || list.isEmpty())
            return null;
        return (Contact) list.get(0);
    }

    @Override
    public void delete(Contact contact) {
        hibernateTemplate.delete(contact);
    }

    @Override
    public List<Contact> getAllContactsFromUser(BigInteger userId) {
        List list = hibernateTemplate.find(
                "from com.deedef.bean.Contact where idutilisateur=?", userId);
        return list;
    }

    @Override
    public List<Contact> getAllContacts() {
        List list = hibernateTemplate.find(
                "from com.deedef.bean.Contact");
        return list;
    }
}
