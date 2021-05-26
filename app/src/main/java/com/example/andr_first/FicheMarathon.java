package com.example.andr_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FicheMarathon extends AppCompatActivity {
    TextView tx_nom,tx_mail,tx_age,tx_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_marathon);
        tx_nom=findViewById(R.id.tx_nom);
        tx_mail=findViewById(R.id.tx_mail);
        tx_age=findViewById(R.id.tx_age);
        tx_phone=findViewById(R.id.tx_phone);

        String name=getIntent().getStringExtra("keyName");
        String phone=getIntent().getStringExtra("keyPhone");
        String email=getIntent().getStringExtra("keyEmail");

        tx_nom.setText(name);
        tx_phone.setText(phone);
        tx_mail.setText(email);
    }
}