package edu.cftic.fichapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.EditText;

public class Preferences {

    public static final String MODO_OSCURO = "modo_oscuro";
    public static final String PRIMERA_VEZ = "primera_vez";


    private static final String NOMBRE_FICHERO = "fichero_prefs";

    public static void guardarTexto (Context context, EditText... array){

        String text;
        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        for (EditText e : array){

            String i = e.getText().toString();
            String x = String.valueOf(e.getId());
            editor.putString(x, i) ;

        }
        editor.commit();


    }

    public static void mostrarTexto(Context context, EditText ... array){

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = fichero.edit();
        for (EditText e : array){

            String x = String.valueOf(e.getId());//NO SE PUEDE HACER ASI
            String i = fichero.getString(x,null);
            e.setText(i);
        }

    }

    public static void check(Context context, CheckBox checkBox) {


        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        String x = String.valueOf(checkBox.getId());

        editor.putBoolean(x,true);

    }

    public static void guardar_booleano(Context context, boolean b) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        editor.putBoolean("booleano",b);

    }

    public static boolean mostrar_booleano(Context context) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = fichero.edit();

        return fichero.getBoolean("booleano",false);

    }



}
