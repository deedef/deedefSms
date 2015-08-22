package com.deedef.dao;

import com.deedef.bean.Profil;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ndiaye on 04/08/2015.
 */

public interface IProfileMgr {
    public void save(Profil profil);
    public void put(Profil profil);
    public Profil get(String id);
    public Profil get(BigInteger id);
    public Profil getByLogin(String login);
    public void delete(Profil profil);
    public List<Profil> getAllProfil();
    //toutes les requetes traitant le profil

}
