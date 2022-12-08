package com.example.edfcompteur.dao.ClientDAO;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.edfcompteur.dao.EDFDataBase;
import com.example.edfcompteur.model.Client;

import java.util.List;

public class ClientRepository {
    private IClientDAO mIClientDao;

    private LiveData<List<Client>> mAllClients;
    public ClientRepository(Application application) {
        EDFDataBase db = EDFDataBase.getDatabase(application);
        mIClientDao = db.mIClientDAO();
    }
    public LiveData<List<Client>> getAllClients() {mAllClients = mIClientDao.getAlphabetizedClients();
        return mAllClients;
    }
    public void insert(Client client) {EDFDataBase.databaseWriteExecutor.execute(() -> {mIClientDao.insert(client);
    });
    }
    public void update(Client client) {EDFDataBase.databaseWriteExecutor.execute(() -> {mIClientDao.update(client);
    });
    }
    public void delete(Client client) {EDFDataBase.databaseWriteExecutor.execute(() -> {mIClientDao.delete(client);
    });
    }
}
