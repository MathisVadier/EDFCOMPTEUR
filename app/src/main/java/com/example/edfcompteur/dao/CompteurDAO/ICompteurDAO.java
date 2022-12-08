package com.example.edfcompteur.dao.CompteurDAO;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.edfcompteur.model.Client;
import com.example.edfcompteur.model.Compteur;

import java.util.List;

@Dao
public interface ICompteurDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Compteur compteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Compteur compteur);

    @Delete
    void delete(Compteur compteur);

    @Query("DELETE FROM compteur")
    void deleleAll();

    @Query("SELECT * FROM compteur ORDER BY compteur.idCompteur ASC")
    LiveData<List<Compteur>> getAlphabetizedCompteur();
}
