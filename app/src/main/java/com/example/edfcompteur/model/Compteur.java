package com.example.edfcompteur.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName="compteur",
        foreignKeys = {@ForeignKey(entity = Client.class,
        parentColumns = ("idClient"),
        childColumns = ("idClientCompteur"),
                onDelete = ForeignKey.CASCADE)})

public class Compteur {
    @PrimaryKey
    private int idCompteur;
    @ColumnInfo(name ="idClientCompteur")
    private int idClientCompteur;

    public int getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    public int getIdClientCompteur() {
        return idClientCompteur;
    }

    public void setIdClientCompteur(int idCientCompteur) {
        this.idClientCompteur = idCientCompteur;
    }


    public Compteur() { }

    public Compteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }
}
