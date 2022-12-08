package com.example.edfcompteur.dao.CompteurDAO;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.edfcompteur.dao.EDFDataBase;
import com.example.edfcompteur.model.Compteur;

import java.util.List;

public class CompteurRepository {
    private ICompteurDAO mCompteurDao;
    private LiveData<List<Compteur>> mAllCompteur;

    public CompteurRepository(Application application) {
        EDFDataBase db = EDFDataBase.getDatabase(application);
        mCompteurDao = db.mICompteurDAO();
    }

    public LiveData<List<Compteur>> getmAllCompteur() {mAllCompteur = mCompteurDao.getAlphabetizedCompteur();
        return mAllCompteur;
    }
    public void insert(Compteur compteur) {EDFDataBase.databaseWriteExecutor.execute(() -> {mCompteurDao.insert(compteur);
    });
    }
    public void update(Compteur compteur) {EDFDataBase.databaseWriteExecutor.execute(() -> {mCompteurDao.update(compteur);
    });
    }
    public void delete(Compteur compteur) {EDFDataBase.databaseWriteExecutor.execute(() -> {mCompteurDao.delete(compteur);
    });
    }
}
