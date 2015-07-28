package com.deedef.db;

/**
 * Created by S2D on 7/25/15.
 */

/**
 * IMPORTANT:
 * Avant de supprimer donnees, etre absolument sur qu'on en aura plus besoin.
 * Meme etant sur, TOUJOURS avoir au moins un backup... On ne sait jamais.
 */
public class Deleter {

    DBConnector dbConnector;

    /*public Deleter(){

    }*/

    public Deleter(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
}
