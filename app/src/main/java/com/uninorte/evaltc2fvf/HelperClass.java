package com.uninorte.evaltc2fvf;
import java.io.Serializable;

/**
 * Created by Laboratorio on 06/02/2017.
 */

public class HelperClass implements Serializable {
    private float Funcionalidad;
    private float Presentacion;
    private float Usabilidad;

    public  HelperClass(float Func,float Presen,float Usa)
    {
        Funcionalidad=Func;
        Presentacion=Presen;
        Usabilidad=Usa;
    }
    public String FinalGrade()
    {
        String Final=Float.toString((Funcionalidad*0.5f)+(Presentacion*0.25f)+(Usabilidad*0.25f));
        return Final;
    }

}
