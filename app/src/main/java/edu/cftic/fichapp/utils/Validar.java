package edu.cftic.fichapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {


    private static final String PATRON_MAIL = "\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,4})+";
    private static final String PATRON_NOMBRE = "\\w{6,45}";
    private static final String PATRON_TELF = "\\+?\\d{7,15}";
    private static final String PATRON_ANUNCIO = "(https?://)?([\\\\da-z.-]+).([a-z.]{2,6})([/\\\\w .-]*)*/?";
    private static final String PATRON_PWD = "\\w{6,45}";

    public static boolean emailValido (String email)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_MAIL);
        Matcher m = p.matcher(email);
        bdev = m.matches();

        return bdev;
    }

    public static boolean nombreUsuarioValido (String nombre_usuario)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_NOMBRE);
        Matcher m = p.matcher(nombre_usuario);
        bdev = m.matches();

        return bdev;
    }

    public static boolean telefonoValido(String p1)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_TELF);
        Matcher m = p.matcher(p1);
        bdev = m.matches();

        return bdev;
    }

    public static boolean anuncioValido(String p1)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_ANUNCIO);
        Matcher m = p.matcher(p1);
        bdev = m.matches();

        return bdev;
    }

    public static boolean contrasenaValida (String p1)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_PWD);
        Matcher m = p.matcher(p1);
        bdev = m.matches();

        return bdev;
    }

    public static boolean contrasenasValida (String p1, String p2)
    {
        boolean bdev = false;

        bdev = p1.equals(p2);

        return bdev;
    }

    public static boolean mayorDeEdad (String fecha_comprobar)
    {
        boolean mayor_edad = false;
        Date fecha_introducida = null;


        if (fecha_comprobar!=null) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                fecha_introducida = sdf.parse(fecha_comprobar);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, -18);
                Date fecha_18 = new Date(calendar.getTimeInMillis());
                mayor_edad = fecha_introducida.before(fecha_18);
            } catch (Exception e) {
                e.printStackTrace();
            }



        }
        return mayor_edad;
    }


}

