package com.example.edfcompteur.controleur;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.edfcompteur.R;
import com.example.edfcompteur.dao.EDFDataBase;
import com.example.edfcompteur.model.Client;
import com.example.edfcompteur.view.ClientListAdapter;
import com.example.edfcompteur.view.ClientViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityClient extends AppCompatActivity {

    private ClientViewModel mClientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final ClientListAdapter adapter = new ClientListAdapter(new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
        mClientViewModel.getmAllClients().observe(this, adapter::submitList);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddClientActivity.class);
            NewClientActivityResultLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> NewClientActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        assert result.getData() != null;
                        Client client = new Client(
                                result.getData().getStringExtra(AddClientActivity.EXTRA_REPLY_NOMCLIENT),
                                result.getData().getStringExtra(AddClientActivity.EXTRA_REPLY_PRENOMCLIENT),
                                result.getData().getStringExtra(AddClientActivity.EXTRA_REPLY_ADRESSECLIENT),
                                result.getData().getStringExtra(AddClientActivity.EXTRA_REPLY_CODEPOSTALCLIENT),
                                result.getData().getStringExtra(AddClientActivity.EXTRA_REPLY_VILLECLIENT)
                        );
                        EDFDataBase.databaseWriteExecutor.execute(() -> mClientViewModel.insert(client));
                        clientInsere();
                    } else {
                        clientNonInsere();
                    }
                }
            });


    private void clientInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Résultat :")
                .setMessage("Client inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {
                })
                .create()
                .show();
    }

    private void clientNonInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Problème :")
                .setMessage("Client non inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {
                })
                .create()
                .show();
    }
}