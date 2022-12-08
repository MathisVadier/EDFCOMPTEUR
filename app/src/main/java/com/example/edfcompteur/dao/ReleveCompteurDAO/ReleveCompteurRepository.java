package com.example.edfcompteur.dao.ReleveCompteurDAO;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.edfcompteur.dao.EDFDataBase;
import com.example.edfcompteur.model.ReleveCompteur;

import java.util.List;

public class ReleveCompteurRepository {
    private IReleveCompteurDAO mReleveCompteurDao;private LiveData<List<ReleveCompteur>> mAllReleveCompteur;

    public ReleveCompteurRepository(Application application) {
        EDFDataBase db = EDFDataBase.getDatabase(application);
        mReleveCompteurDao = db.mIReleveCompteurDAO();
    }

    public LiveData<List<ReleveCompteur>> getAllReleveCompteur() {
        mAllReleveCompteur = mReleveCompteurDao.getAlphabetizedReleveCompteur();
        return mAllReleveCompteur;
    }

    public void insert(ReleveCompteur releveCompteur) {
        EDFDataBase.databaseWriteExecutor.execute(() -> {
            mReleveCompteurDao.insert(releveCompteur);
    });
    }

    public void update(ReleveCompteur releveCompteur) {
        EDFDataBase.databaseWriteExecutor.execute(() -> {
            mReleveCompteurDao.update(releveCompteur);
    });
    }

    public void delete(ReleveCompteur releveCompteur) {
        EDFDataBase.databaseWriteExecutor.execute(() -> {
            mReleveCompteurDao.delete(releveCompteur);
    });
    }
}
