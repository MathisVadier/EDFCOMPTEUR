package com.example.edfcompteur.controleur;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.edfcompteur.R;
import com.example.edfcompteur.model.Client;

public class MainActivity extends AppCompatActivity {

    private Button mImageViewIdentification;
    private Button mImageViewClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewIdentification = findViewById(R.id.imageViewIdentification);
        mImageViewIdentification.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {Intent Identification = new Intent(MainActivity.this, ReleveCompteur.class);
                startActivity(Identification);

            }});

        mImageViewClient = findViewById(R.id.imageViewClient);
        mImageViewClient.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {Intent Identification = new Intent(MainActivity.this, ActivityClient.class);
                startActivity(Identification);

            }});
    }
}