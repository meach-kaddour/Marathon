package com.example.andr_first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class forminscription extends AppCompatActivity {
     Button btn_valid;
     EditText nom,age,phone,email;
     DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forminscription);
        btn_valid=findViewById(R.id.btn_valid);
        nom=findViewById(R.id.nom);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        btn_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            registre();
            }
        });
    }
    public void registre(){
        boolean  tNom=false;
        boolean  tAge=false;
        boolean  tPhone=false;
        boolean  tEmail;
        String _name=nom.getText().toString();
        String _email=email.getText().toString();
        String _age=age.getText().toString();
        String _phone=phone.getText().toString();



        try {
            /** Vérifier  name*/

            if( _name.length() == 0 ){
                nom.setError( "Name is required!" );
                tNom=true;
            }
            /** Vérifier age*/
            if (age.length()==0){
                age.setError("l'age et nécessaire");
                tAge=true;
            }
            /** Vérifier email*/
            if (email.length()==0){
                email.setError("please enter email adress");
                tEmail=true;
            }else if(isValidEmailId(_email.trim())){
                    tEmail=false;
                }else{
                Toast.makeText(getApplicationContext(), "InValid Email Address.", Toast.LENGTH_SHORT).show();
                tEmail=true;
            }
            /** Vérifier phone*/
            if (phone.length()==0){
               phone.setError("Please enter your phone");
               tPhone=true;
            }else if(!_phone.matches("[0-9]{10}")){
                phone.setError("Only 10 number");
                tNom=true;
            }

            if(tNom==false && tAge==false && tPhone==false && tEmail==false){
                Toast.makeText(forminscription.this,"l'inscirption fait avec succes",Toast.LENGTH_LONG).show();
                Intent i =new Intent (forminscription.this, FicheMarathon.class);
                i.putExtra("keyName",_name);
                i.putExtra("keyEmail",_email);
                i.putExtra("keyPhone",_phone);
                startActivity(i);
            }


        }catch (Exception e){
            Toast.makeText(forminscription.this,"l'inscription a echoué",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

}