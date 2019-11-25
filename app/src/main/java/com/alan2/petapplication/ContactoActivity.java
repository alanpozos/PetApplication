package com.alan2.petapplication;

import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class ContactoActivity extends AppCompatActivity {

    TextInputEditText campoNombre;
    TextInputEditText campoCorreo;
    TextInputEditText campoMensaje;

    Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        campoNombre = (TextInputEditText) findViewById(R.id.edtTxtNombre);
        campoCorreo = (TextInputEditText) findViewById(R.id.edtTxtCorreo);
        campoMensaje = (TextInputEditText) findViewById(R.id.edtTxtMensaje);

        botonEnviar = (Button) findViewById(R.id.btnEnviar);
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
                Intent intent1 = new Intent(ContactoActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        setToolbar();
    }

    private void setToolbar(){
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbarMain);
        setSupportActionBar(miActionBar);
        final ActionBar ab = getSupportActionBar();
        getSupportActionBar().setTitle("Contacto");

        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.left_48black);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void sendEmail() {
        //Getting content for email
        String email = campoCorreo.getText().toString().trim();
        String subject = campoNombre.getText().toString().trim();
        String message = campoMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
