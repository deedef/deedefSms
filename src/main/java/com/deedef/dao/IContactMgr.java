package com.deedef.dao;

import com.deedef.bean.Contact;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by S2D on 8/20/15.
 */

public interface IContactMgr {
    public void save(Contact contact);
    public Contact getContactByEmailFromUser(BigInteger userId, String email);
    public void delete(Contact contact);
    public List<Contact> getAllContactsFromUser(BigInteger userId);
    public List<Contact> getAllContacts();
    //toutes les requetes traitant le profil
}
