package com.example.edfcompteur.controleur;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.edfcompteur.R;

public class AddClientActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_NOMCLIENT = "A" ;
    public static final String EXTRA_REPLY_PRENOMCLIENT = "B" ;
    public static final String EXTRA_REPLY_ADRESSECLIENT = "C";
    public static final String EXTRA_REPLY_CODEPOSTALCLIENT = "D";
    public static final String EXTRA_REPLY_VILLECLIENT = "E";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
    }
}