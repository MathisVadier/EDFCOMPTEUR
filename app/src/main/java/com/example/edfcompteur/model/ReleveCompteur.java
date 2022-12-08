package com.example.edfcompteur.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "releve_compteur",
        foreignKeys = {@ForeignKey(entity = Compteur.class,
        parentColumns = "idCompteur",
        childColumns = "idReleveCompteur",
        onDelete = ForeignKey.CASCADE)
        })
public class ReleveCompteur {
    @PrimaryKey
    private int idReleveCompteur;

    @ColumnInfo(name ="releveCompteur")
    private double releveCompteur;

    @ColumnInfo(name ="dateReleveCompteur")
    private String dateReleveCompteur;

    @ColumnInfo(name = "situationReleveCompteur")
    private int situationReleveCompteur;

    public ReleveCompteur(int idReleveCompteur, double releveCompteur, String dateReleveCompteur, int situationReleveCompteur) {
        this.idReleveCompteur = idReleveCompteur;
        this.releveCompteur = releveCompteur;
        this.dateReleveCompteur = dateReleveCompteur;
        this.situationReleveCompteur = situationReleveCompteur;
    }

    public int getIdReleveCompteur() {
        return idReleveCompteur;
    }

    public void setIdReleveCompteur(int idReleveCompteur) {
        this.idReleveCompteur = idReleveCompteur;
    }

    public double getReleveCompteur() {
        return releveCompteur;
    }

    public void setReleveCompteur(double releveCompteur) {
        this.releveCompteur = releveCompteur;
    }

    public String getDateReleveCompteur() {
        return dateReleveCompteur;
    }

    public void setDateReleveCompteur(String dateReleveCompteur) {
        this.dateReleveCompteur = dateReleveCompteur;
    }

    public int getSituationReleveCompteur() {
        return situationReleveCompteur;
    }

    public void setSituationReleveCompteur(int situationReleveCompteur) {
        this.situationReleveCompteur = situationReleveCompteur;
    }
}