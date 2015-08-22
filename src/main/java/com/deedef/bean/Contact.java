package com.deedef.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by birame ndiaye on 25/05/2015.
 */

@Entity
@Table(name = "contacts")
public class Contact implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="contactid")
    private BigInteger contactId;
    @Column(name="idutilisateur")
    private BigInteger id;
    @Column(name="prenomcontact")
    private String prenomContact;
    @Column(name="nomcontact")
    private String  nomContact;
    @Column(name="telephonecontact")
    private String telephoneContact;
    @Column(name="emailcontact")
    private String emailContact;

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getTelephoneContact() {
        return telephoneContact;
    }

    public void setTelephoneContact(String telephoneContact) {
        this.telephoneContact = telephoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
}
