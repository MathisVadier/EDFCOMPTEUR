package com.example.edfcompteur.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "client")

    public class Client {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "idClient")
        private int idClient;
        @ColumnInfo(name = "nom")
        private String nom;
        @ColumnInfo(name = "prenom")
        private String prenom;
        @ColumnInfo(name = "adresse")
        private String adresse;
        @ColumnInfo(name = "codePostal")
        private String codePostal;
        @ColumnInfo(name = "villeClient")
        private String villeClient;

        public Client(String nom, String prenom, String adresse, String codePostal, String villeClient) {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = adresse;
            this.codePostal = codePostal;
            this.villeClient = villeClient;
        }

        public Client() {
        }

        public int getIdClient() {
            return idClient;
        }

        public void setIdClient(int idClient) {
            this.idClient = idClient;
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

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getCodePostal() {
            return codePostal;
        }

        public void setCodePostal(String codePostal) {
            this.codePostal = codePostal;
        }

        public String getVilleClient() {
            return villeClient;
        }

        public void setVilleClient(String villeClient) {
            this.villeClient = villeClient;
        }

    }


