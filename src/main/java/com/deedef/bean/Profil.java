package com.deedef.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by birame ndiaye on 25/05/2015.
 */

@Entity
@Table(name = "utilisateurs")
public class Profil implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private BigInteger id;
    @Column(name="civilite")
    private String civilie;
    @Column(name="nom")
    private String  nom;
    @Column(name="prenom")
    private String  prenom;
    @Column(name="telephone")
    private String   telephone;
    @Column(name="mobile")
    private String mobile;
    @Column(name="email")
    private String  email;
    @Column(name="datenaissance")
    private String dateNaissance;
    @Column(name="datecreation")
    private Date dateCreation;
    @Column(name="login")
    private String login;
    @Column(name="societe")
    private String societe;
    @Column(name="adresse")
    private String adresse;
    @Column(name="codepostal")
    private Long codePostale;
    @Column(name="ville")
    private String ville;
    @Column(name="pays")
    private String pays;


    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }


    public String getCivilie() {
        return civilie;
    }

    public void setCivilie(String civilie) {
        this.civilie = civilie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Date getDateNaissance() {
//        return dateNaissance;
//    }
//
//    public void setDateNaissance(Date dateNaissance) {
//        this.dateNaissance = dateNaissance;
//    }


    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Long codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
//
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
