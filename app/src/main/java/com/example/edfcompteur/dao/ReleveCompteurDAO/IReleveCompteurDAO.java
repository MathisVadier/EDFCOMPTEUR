package com.example.edfcompteur.dao.ReleveCompteurDAO;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.edfcompteur.model.Client;
import com.example.edfcompteur.model.Compteur;
import com.example.edfcompteur.model.ReleveCompteur;

import java.util.List;

@Dao
public interface IReleveCompteurDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ReleveCompteur releveCompteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(ReleveCompteur releveCompteur);

    @Delete
    void delete(ReleveCompteur releveCompteur);

    @Query("DELETE FROM releve_compteur")
    void deleleAll();

    @Query("SELECT idReleveCompteur, releveCompteur, situationReleveCompteur, idReleveCompteur FROM RELEVE_COMPTEUR ORDER BY RELEVE_COMPTEUR.idReleveCompteur ASC")
    LiveData<List<ReleveCompteur>> getAlphabetizedReleveCompteur();


}
