package edu.cftic.fichapp.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.utils.Validar;

public class LoginActivity extends AppCompatActivity  {

    EditText usuario = null;
    EditText contraseña = null;
    private DB database = null;
    public static final String ROL_EMPLEADO = "empleado";
    public static final String ROL_GESTOR = "gestor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        database = new DB(this);

    }

    /**
     * TODO COTEJAR LOS DATOS INTRODUCIDOS CON LA BASE DE DATOS (USUARIO Y CONTRASEÑA)
     * @return
     */
    public void entrar(View view) {

        String nombre = usuario.getText().toString();
        String cont = contraseña.getText().toString();
        Empleado u = database.empleados.getEmpleadoUsuarioClave(nombre,cont);

        if(u==null){

            TextView incorrecto = findViewById(R.id.incorrecto);

            limpiarText(usuario,contraseña);

            incorrecto.setText("Usuario y/o contraseña incorrectos, \n Contacte con el administrador");

        }
        //TODO SALTAR AL MENU DE TRABAJADOR O GESTOR

        if (u.getRol()==ROL_EMPLEADO ){
            Intent intent = new Intent(this,MenuEmpleado.class);
            intent.putExtra("ID_EMPLEADO",u.getId_empleado());
            intent.putExtra("ROL_EMPLEADO",u.getRol());
            startActivity(intent);

        }else if(u.getRol()==ROL_GESTOR ){
            Intent intent = new Intent(this,MenuGestor.class);
            intent.putExtra("ID_EMPLEADO",u);
            intent.putExtra("ROL_EMPLEADO",u.getRol());
            startActivity(intent);
        }
    }


    public void limpiarText(EditText ... array ) {//VARARGS

        for (EditText e : array) {

            e.setText("");
            //e.clearFocus();

        }
    }

}
