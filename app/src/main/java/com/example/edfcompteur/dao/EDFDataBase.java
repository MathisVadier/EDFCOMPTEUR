package com.example.edfcompteur.dao;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.edfcompteur.dao.ClientDAO.IClientDAO;
import com.example.edfcompteur.dao.CompteurDAO.ICompteurDAO;
import com.example.edfcompteur.dao.ReleveCompteurDAO.IReleveCompteurDAO;
import com.example.edfcompteur.model.Client;
import com.example.edfcompteur.model.Compteur;
import com.example.edfcompteur.model.ReleveCompteur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class, Compteur.class, ReleveCompteur.class}, version = 1, exportSchema = false)
public abstract class EDFDataBase extends RoomDatabase {
    public abstract IClientDAO mIClientDAO();
    public abstract ICompteurDAO mICompteurDAO();
    public abstract IReleveCompteurDAO mIReleveCompteurDAO();
    private static volatile EDFDataBase INSTANCE;
    private static final int NUMBER_OF_TREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_TREADS);

    public static EDFDataBase getDatabase(final Context context) {if (INSTANCE == null) {synchronized (EDFDataBase.class) {if (INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                EDFDataBase.class, "edf_database").fallbackToDestructiveMigration().build();
            }
        }
    }
    return INSTANCE;
    }
}

