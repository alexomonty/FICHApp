package edu.cftic.fichapp.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.utils.Validar;

public class Login extends AppCompatActivity {

    EditText usuario = null;
    EditText contraseña = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);

    }

    public void entrar(View view) {


       if(!validar()){

           TextView incorrecto = findViewById(R.id.incorrecto);

           limpiarText(usuario,contraseña);

           incorrecto.setText("Usuario y/o contraseña incorrectos, \n Contacte con el administrador");

       }
        //TODO SALTAR AL MENU DE TRABAJADOR O GESTOR
        Intent intent = new Intent();

       startActivity(intent);


    }

    /**
     * TODO COTEJAR LOS DATOS INTRODUCIDOS CON LA BASE DE DATOS (USUARIO Y CONTRASEÑA)
     * @return
     */
    private boolean validar() {
        return true;
    }


    private void limpiarText(EditText ... array ) {//VARARGS

        for (EditText e : array) {

            e.setText("");
            //e.clearFocus();

        }
    }
}
